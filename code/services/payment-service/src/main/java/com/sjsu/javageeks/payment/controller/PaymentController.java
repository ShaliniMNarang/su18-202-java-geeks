package com.sjsu.javageeks.payment.controller;


import com.sjsu.javageeks.payment.model.Payment;
import com.sjsu.javageeks.payment.service.interfaces.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService = null;

    /*
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void makePayment(@RequestBody Payment payment) {
        paymentService.makePayment(payment);

    }*/

    @RequestMapping(value="/test",method=RequestMethod.GET)
    public String test() {
        paymentService.makePayment(null);
        return "Test";
    }



    }
