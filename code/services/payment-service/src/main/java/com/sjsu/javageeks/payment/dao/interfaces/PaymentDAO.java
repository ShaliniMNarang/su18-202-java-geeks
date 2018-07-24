package com.sjsu.javageeks.payment.dao.interfaces;

import com.sjsu.javageeks.payment.model.Payment;

public interface PaymentDAO {

    void makePayment(Payment payment);

}
