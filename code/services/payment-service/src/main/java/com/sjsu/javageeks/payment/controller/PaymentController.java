package com.sjsu.javageeks.payment.controller;


import com.sjsu.javageeks.payment.constants.PaymentConstants;
import com.sjsu.javageeks.payment.model.Payment;
import com.sjsu.javageeks.payment.service.interfaces.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = {"*"})
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> makePayment(@RequestBody Payment payment) {

        Optional<Payment> paymentAmount = paymentService.makePayment(payment);
        return new ResponseEntity<String>(PaymentConstants.SUCCESS_STATUS, HttpStatus.OK);


    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPayment(@PathVariable("id") String id) {
        Optional<Payment> payment = paymentService.getPayment(id);
        return new ResponseEntity<Optional<Payment>>(payment, HttpStatus.OK);


    }
}