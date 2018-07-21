package com.sjsu.javageeks.order;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sjsu.javageeks.order.entity.OrdersEO;
import com.sjsu.javageeks.order.service.Orders;
import com.sjsu.javageeks.order.serviceImpl.OrdersImpl;
import com.sjsu.javageeks.order.util.Constants;

@SpringBootApplication
public class OrderApplication implements CommandLineRunner {
	@Autowired Orders o;
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(OrderApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
	}
		
	@Override
	public void run(String... args) throws Exception {
		
		OrdersEO oEO = new OrdersEO();
		oEO.setAmount(3.25);
		oEO.setCustomerId("C1");
		oEO.setOrderDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		
		oEO.setProductId("P1");
		oEO.setProductName("Latte");
		oEO.setStatus(Constants.CONFIRMED_STATUS);
		o.saveOrder(oEO);
		
	}
}
