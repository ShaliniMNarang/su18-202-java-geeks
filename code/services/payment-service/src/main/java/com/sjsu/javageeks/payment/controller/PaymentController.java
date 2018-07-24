package com.sjsu.javageeks.payment.controller;


import com.sjsu.javageeks.payment.constants.PaymentConstants;
import com.sjsu.javageeks.payment.model.Payment;
import com.sjsu.javageeks.payment.service.interfaces.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public  ResponseEntity<?>  makePayment(@RequestBody Payment payment) {
        Optional<Payment> paymentAmount  = paymentService.makePayment(payment);
        if(paymentAmount.get().getStatus().equals(PaymentConstants.SUCCESS_STATUS)) {
            return new ResponseEntity<String>(PaymentConstants.SUCCESS_STATUS, HttpStatus.OK);
        }else{
            return new ResponseEntity<String>(PaymentConstants.FAILURE_STATUS, HttpStatus.OK);

        }

    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> getPayment(@PathVariable("userId") String id) {
        Optional<Payment> payment  = paymentService.getPayment(id);
        return new ResponseEntity<Optional<Payment>>(payment, HttpStatus.OK);

    }
}