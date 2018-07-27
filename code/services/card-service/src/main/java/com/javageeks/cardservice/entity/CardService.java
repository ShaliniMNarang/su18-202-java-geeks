package com.javageeks.cardservice.entity;

import java.util.List;

import com.javageeks.cardservice.exception.InValidCardException;

public interface CardService {

	public Card getCard(Long id);
	
	public List<Card> getCardBYUserId(Long userId);
	
	public List<Card> getCards();
	
	public Card addCard(Card card);
	
	public Card updateCard(Card card) throws InValidCardException;
	
	public Card deleteCard(Long id);
}
