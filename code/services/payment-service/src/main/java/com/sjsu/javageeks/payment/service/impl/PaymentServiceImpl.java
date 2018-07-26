package com.sjsu.javageeks.payment.service.impl;

import com.sjsu.javageeks.payment.constants.PaymentConstants;
import com.sjsu.javageeks.payment.dao.interfaces.PaymentDAO;
import com.sjsu.javageeks.payment.model.Payment;
import com.sjsu.javageeks.payment.service.interfaces.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentDAO paymentDAO;


    @Override
    public Optional<Payment> getPayment(String orderId) {
        List<Payment> paymentInfo = paymentDAO.findByOrderid(orderId);
        if(!paymentInfo.isEmpty()) {
                return Optional.ofNullable(paymentInfo.get(0));
        }
        return Optional.ofNullable(null);
    }


    @Override
    public Optional<Payment> makePayment(Payment payment) {
        if(payment.getAmount() > PaymentConstants.PAYMENT_MIN_AMOUNT) {
            payment.setStatus(PaymentConstants.SUCCESS_STATUS);
        }
        Optional<Payment> paidPayment = Optional.ofNullable(paymentDAO.save(payment));
        updatePayment(paidPayment.get().getAmount(),paidPayment.get().getCardId());

        return paidPayment;
    }


    private void updatePayment(Double balance, String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("id", id);
        map.add("cardBalance", balance.toString());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity( PaymentConstants.CARD_REST_URL, request , String.class );
    }
}
