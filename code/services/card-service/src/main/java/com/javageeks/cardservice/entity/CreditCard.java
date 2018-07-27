package com.javageeks.cardservice.entity;

import com.javageeks.cardservice.exception.InvalidCardTypeException;

public class CreditCard extends CardBase{
	private String securityCode;

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	
	@Override
	public void setCardType(String cardType) throws InvalidCardTypeException {
		super.setCardType("CC");
	}
	
}
