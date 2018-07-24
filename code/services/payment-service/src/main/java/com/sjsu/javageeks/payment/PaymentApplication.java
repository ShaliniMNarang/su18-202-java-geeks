package com.sjsu.javageeks.payment;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.sjsu.javageeks.payment.controller"})
@ComponentScan
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PaymentApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}