package com.sjsu.javageeks.payment.service.impl;

import com.sjsu.javageeks.payment.dao.impl.PaymentDAOImpl;
import com.sjsu.javageeks.payment.dao.interfaces.PaymentDAO;
import com.sjsu.javageeks.payment.model.Payment;
import com.sjsu.javageeks.payment.service.interfaces.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentDAO paymentDAO = new PaymentDAOImpl();


    @Override
    public void makePayment(Payment payment) {
        paymentDAO.makePayment(payment);
    }
}
