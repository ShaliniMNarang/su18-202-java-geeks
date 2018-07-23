package com.sjsu.javageeks.order.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersEORepository extends JpaRepository<OrdersEO, Long> {
	
	List<OrdersEO> findByOrderId(Long orderId);
	
	 //To get all orders of a customer
	List<OrdersEO> findByCustomerId(Long customerId);

	OrdersEO save(OrdersEO oEO);
}
