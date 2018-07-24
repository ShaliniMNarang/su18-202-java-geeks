package com.sjsu.javageeks.payment.service.impl;

import com.sjsu.javageeks.payment.constants.PaymentConstants;
import com.sjsu.javageeks.payment.dao.interfaces.PaymentDAO;
import com.sjsu.javageeks.payment.model.Payment;
import com.sjsu.javageeks.payment.service.interfaces.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return paidPayment;
    }
}
