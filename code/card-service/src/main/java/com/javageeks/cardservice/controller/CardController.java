package com.javageeks.cardservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javageeks.cardservice.entity.Card;
import com.javageeks.cardservice.entity.CardRepository;
import com.javageeks.cardservice.exception.InValidCardException;

@RestController
@RequestMapping("/api/card")
public class CardController {

	@Autowired
	private CardRepository cardRepository;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test() {
		return "Test";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Card> getCard(@PathVariable Long id) {
		return new ResponseEntity<Card>(cardRepository.findById(id).get(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET)
	public ResponseEntity<List<Card>> getCardBYUserId(@PathVariable Long userId) {
		return new ResponseEntity<List<Card>>(cardRepository.findByUserId(userId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Card>> getCards() {
		return new ResponseEntity<List<Card>>(cardRepository.findAll(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Card> addCard(@RequestBody Card card) {
		return new ResponseEntity<Card>(cardRepository.save(card),HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Card> updateCard(@RequestBody Card card) throws InValidCardException {
		validateExistingCard(card);
		return new ResponseEntity<Card>(cardRepository.save(card),HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Card> deleteCard(@PathVariable Long id) {
		Card card=cardRepository.findById(id).get();
		cardRepository.delete(card);
		return new ResponseEntity<Card>(card,HttpStatus.OK);
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
