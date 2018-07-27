package com.javageeks.cardservice.entity;

public class CardFactory {
	
	public CardBase getCard(String cardType) {
		if (cardType.equals("CC"))
			return new CreditCard();
		else 
			return new GiftCard();
	}

}
