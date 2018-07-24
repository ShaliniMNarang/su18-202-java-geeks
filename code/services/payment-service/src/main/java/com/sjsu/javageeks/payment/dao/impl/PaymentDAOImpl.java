package com.sjsu.javageeks.payment.dao.impl;

import com.sjsu.javageeks.payment.dao.interfaces.PaymentDAO;
import com.sjsu.javageeks.payment.model.Payment;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public void makePayment(Payment payment) {
        System.out.println("Payment Done..");

    }
}
