package com.sjsu.javageeks.payment.service.interfaces;

import com.sjsu.javageeks.payment.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

     public Optional<Payment> getPayment(String userId);
     public Optional<Payment> makePayment(Payment payment);

}
