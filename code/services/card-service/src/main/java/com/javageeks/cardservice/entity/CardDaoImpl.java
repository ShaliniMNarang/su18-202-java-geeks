package com.javageeks.cardservice.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javageeks.cardservice.exception.InValidCardException;

@Service
public class CardDaoImpl {

	@Autowired
	CardRepository cardRepository;
	
	public Card getCard(Long id) {
		return cardRepository.findById(id).get();
	}
	
	public List<Card> getCardBYUserId(Long userId) {
		return cardRepository.findByUserId(userId);
	}
	
	public List<Card> getCards() {
		return cardRepository.findAll();
	}
	
	public Card addCard(Card card) {
		return cardRepository.save(card);
	}
	
	public Card updateCard(Card card) throws InValidCardException {
		validateExistingCard(card);
		return cardRepository.save(card);
	}
	
	public Card deleteCard(Long id) {
		Card card=cardRepository.findById(id).get();
		cardRepository.delete(card);
		return card;
	}
	
	private void validateExistingCard(Card card) throws InValidCardException{
		Card existingCard=null;
		
		if (card.getId() == null)
			throw new InValidCardException(); 
		else
			existingCard=cardRepository.findById(card.getId()).get();
		
		if (card.getCardNumber() == null || card.getCardNumber().equals(""))
			card.setCardNumber(existingCard.getCardNumber());
		
		if (card.getCardHolderName() == null || card.getCardHolderName().equals(""))
			card.setCardHolderName(existingCard.getCardHolderName());
		
		if (card.getCardExpirationDate() == null || card.getCardExpirationDate().equals(""))
			card.setCardExpirationDate(existingCard.getCardExpirationDate());
		
	}
}
