package com.sjsu.javageeks.order;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sjsu.javageeks.order.entity.OrdersEO;
import com.sjsu.javageeks.order.serviceImpl.OrdersImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderApplicationTests {
	@Mock
	OrdersImpl orders;

	@Test
	public void testSaveOrder() {
		OrdersEO order = new OrdersEO();
		order.setAmount(3.25);
		order.setCustomerId("C1");
		order.setProductId("P1");
		order.setProductName("PName");
		
		OrdersEO order1= new OrdersEO();
		order1.setOrderId(1);
		order.setAmount(3.25);
		order.setCustomerId("C1");
		order.setProductId("P1");
		order.setProductName("PName");
		when(orders.saveOrder(order)).thenReturn(order1);
		
		assertTrue(order1.getOrderId()== 1);
	}
	
	@Test
	public void testgetOrder() {
		OrdersEO order = new OrdersEO();
		order.setOrderId(1);
		order.setAmount(3.25);
		order.setCustomerId("C1");
		order.setProductId("P1");
		order.setProductName("PName");
		
		when(orders.getOrder(1)).thenReturn(order);
		
		assertTrue(order.getOrderId()== 1);
		assertTrue(order.getAmount() == 3.25);
		assertTrue(order.getProductId().equals("P1"));
		assertTrue(order.getProductName().equals("PName"));
		
		
	}

}
