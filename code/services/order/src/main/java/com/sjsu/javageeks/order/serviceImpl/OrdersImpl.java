package com.sjsu.javageeks.order.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.sjsu.javageeks.order.entity.OrdersEO;
import com.sjsu.javageeks.order.entity.OrdersEORepository;
import com.sjsu.javageeks.order.service.Orders;
import com.sjsu.javageeks.order.util.*;
import org.springframework.stereotype.Service;

@Service
public class OrdersImpl implements Orders{

	@Autowired
	private OrdersEORepository orderEORepository;
	
	@Override
	public List<OrdersEO> getOrders() {
		List <OrdersEO> ordersList=orderEORepository.findAll();
		return ordersList;
	}

	@Override
	public OrdersEO getOrder(long orderId) {
		List <OrdersEO> ordersList=orderEORepository.findByOrderId(orderId);
		if(ordersList != null)
			return ordersList.get(0);
		else
			return null;
	}

	@Override
	public OrdersEO saveOrder(OrdersEO oEO) {
			oEO.setStatus(Constants.CONFIRMED_STATUS);
			oEO = orderEORepository.save(oEO);
			return oEO;
	}

}
