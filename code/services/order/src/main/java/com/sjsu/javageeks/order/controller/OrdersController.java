package com.sjsu.javageeks.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sjsu.javageeks.order.entity.OrdersEO;
import com.sjsu.javageeks.order.service.Orders;

@RestController
@RequestMapping("/api/order")
public class OrdersController {
	@Autowired
	Orders orderService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<OrdersEO>> getOrders() {
		return new ResponseEntity<List<OrdersEO>>(orderService.getOrders(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<OrdersEO> getOrder(@PathVariable Long id) {
		return new ResponseEntity<OrdersEO>(orderService.getOrder(id),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<OrdersEO> saveOrder(@RequestBody OrdersEO order) {
		return new ResponseEntity<OrdersEO>(orderService.saveOrder(order),HttpStatus.OK);
	}

}
