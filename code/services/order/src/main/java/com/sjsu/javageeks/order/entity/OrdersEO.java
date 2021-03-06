package com.sjsu.javageeks.order.entity;

import javax.persistence.Entity;
import java.sql.Date;
import javax.persistence.GeneratedValue;

@Entity
@javax.persistence.Table(name = "orders")
public class OrdersEO {
	@javax.persistence.Id
	@GeneratedValue
	private long orderId;

	private String customerId;
	
	private Date orderDate;

	private String productId;

	private String productName;
	
	private double amount;
	
	private String status;
	
	public OrdersEO() {
		
	}

	public OrdersEO(long orderId, String customerId, Date orderDate, String productId,
			 String productName, double amount, String status) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.productId = productId;
		this.productName = productName;
		this.amount = amount;
		this.status = status;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
