package com.sjsu.javageeks.payment.constants;

public interface PaymentConstants {
    String SUCCESS_STATUS="success";
    String FAILURE_STATUS="failure";
    Double PAYMENT_MIN_AMOUNT = 20.00;
    String CARD_REST_URL = "http://ec2co-ecsel-1m2a435d30sfq-1565654261.us-west-2.elb.amazonaws.com:5000/api/card";



}
