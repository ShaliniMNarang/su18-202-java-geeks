package com.sjsu.javageeks.payment.service.impl;

import com.sjsu.javageeks.payment.constants.PaymentConstants;
import com.sjsu.javageeks.payment.dao.interfaces.PaymentDAO;
import com.sjsu.javageeks.payment.model.Card;
import com.sjsu.javageeks.payment.model.CardInfo;
import com.sjsu.javageeks.payment.model.Payment;
import com.sjsu.javageeks.payment.service.interfaces.PaymentService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDAO paymentDAO;


    @Override
    public Optional<Payment> getPayment(String orderId) {
        List<Payment> paymentInfo = paymentDAO.findByOrderid(orderId);
        if (!paymentInfo.isEmpty()) {
            return Optional.ofNullable(paymentInfo.get(0));
        }
        return Optional.ofNullable(null);
    }


    @Override
    public Optional<Payment> makePayment(Payment payment) {
        if (payment.getAmount() > PaymentConstants.PAYMENT_MIN_AMOUNT) {
            payment.setStatus(PaymentConstants.SUCCESS_STATUS);
        }
        Optional<Payment> paidPayment = Optional.ofNullable(paymentDAO.save(payment));
        updatePayment(paidPayment.get().getAmount(), paidPayment.get().getCardId());

        return paidPayment;
    }


    private void updatePayment(Double balance, String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Card card = getCardInfo(id);
        CardInfo cardInfo = new CardInfo();
        cardInfo.setId(id);
        cardInfo.setCardBalance(card.getCardBalance() - balance);
        cardInfo.setCardNumber(card.getCardNumber());
        cardInfo.setCardHolderName(card.getCardHolderName());
        cardInfo.setCardExpirationDate(card.getCardExpirationDate());
        cardInfo.setUserId(card.getUserId() + "");
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpEntity<CardInfo> requestUpdate = new HttpEntity<>(cardInfo, headers);
            restTemplate.exchange(PaymentConstants.CARD_REST_URL, HttpMethod.PUT, requestUpdate, Void.class);
        } catch (Exception exception) {
            System.out.println("Exception while updatePayment ");
            exception.printStackTrace();
        }
    }


    private Card getCardInfo(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(PaymentConstants.CARD_REST_URL)
                .queryParam("id", id);

        HttpEntity<?> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);
        String responseString = response.getBody();
        List<Card> cardsList = new ArrayList<Card>();
        System.out.println(response.toString().indexOf("["));
        try {
            JSONArray array = new JSONArray(responseString);
            List<JSONObject> list = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                Card card = new Card();
                card.setCardBalance((Double) jsonObject.get("cardBalance"));
                card.setId((Integer) jsonObject.get("id"));
                card.setUserId(jsonObject.get("userId") == JSONObject.NULL ? null : (Integer) jsonObject.get("userId"));
                card.setCardNumber(jsonObject.get("cardNumber") == JSONObject.NULL ? null : (String) jsonObject.get("cardNumber"));
                card.setCardHolderName(jsonObject.get("cardHolderName") == JSONObject.NULL ? null : (String) jsonObject.get("cardHolderName"));
                card.setCardExpirationDate(jsonObject.get("cardExpirationDate") == JSONObject.NULL ? null : (String) jsonObject.get("cardExpirationDate"));
                card.setCardType(jsonObject.get("cardType") == JSONObject.NULL ? null : (String) jsonObject.get("cardType"));
                card.setDefaultCard(jsonObject.get("defaultCard") == JSONObject.NULL ? null : (String) jsonObject.get("defaultCard"));
                card.setStatus(jsonObject.get("status") == JSONObject.NULL ? null : (String) jsonObject.get("status"));
                if (id.equals(card.getId() + "")) {
                    cardsList.add(card);
                    break;
                }
            }
        } catch (Exception e) {

        }

        return cardsList.get(0);
    }

}

