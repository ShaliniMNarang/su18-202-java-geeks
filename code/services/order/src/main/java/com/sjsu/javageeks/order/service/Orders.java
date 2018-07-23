package com.sjsu.javageeks.order.service;

import java.util.List;

import com.sjsu.javageeks.order.entity.OrdersEO;

public interface Orders {
	public List<OrdersEO> getOrders();
	public OrdersEO getOrder(long orderId);
	public OrdersEO saveOrder(OrdersEO oEO);
}
