package com.javageeks.cardservice.entity;

import com.javageeks.cardservice.exception.InvalidCardTypeException;

public class GiftCard extends CardBase{
	private double cardBalance;

	public double getCardBalance() {
		return cardBalance;
	}

	public void setCardBalance(double cardBalance) {
		this.cardBalance = cardBalance;
	}
	
	@Override
	public void setCardType(String cardType) throws InvalidCardTypeException {
		super.setCardType("GC");
	}
	
}
