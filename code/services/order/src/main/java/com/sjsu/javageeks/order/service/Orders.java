package com.sjsu.javageeks.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sjsu.javageeks.order.entity.OrdersEO;

public interface Orders {
	public List<OrdersEO> getOrders();
	public OrdersEO getOrder(long orderId);
	public void saveOrder(OrdersEO oEO);
}
