package com.javageeks.cardservice.entity;

import java.util.List;

public interface CardDao {

	public Card getCard(Long id);
	
	public Card getCardBYUserId(Long userId);
	
	public List<Card> getCards();
	
	public Card addCard(Card card);
	
	public Card updateCard(Card card);
	
	public Card deleteCard(Long id);
}
