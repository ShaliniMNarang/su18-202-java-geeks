package com.javageeks.cardservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javageeks.cardservice.entity.Card;
import com.javageeks.cardservice.entity.CardService;
import com.javageeks.cardservice.exception.InValidCardException;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/card")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test() {
		return "Test";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Card> getCard(@PathVariable Long id) {
		return new ResponseEntity<Card>(cardService.getCard(id),HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET)
	public ResponseEntity<List<Card>> getCardBYUserId(@PathVariable Long userId) {
		return new ResponseEntity<List<Card>>(cardService.getCardBYUserId(userId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Card>> getCards() {
		return new ResponseEntity<List<Card>>(cardService.getCards(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Card> addCard(@RequestBody Card card) {
		return new ResponseEntity<Card>(cardService.addCard(card),HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Card> updateCard(@RequestBody Card card) throws InValidCardException {
		return new ResponseEntity<Card>(cardService.updateCard(card),HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Card> deleteCard(@PathVariable Long id) {
		return new ResponseEntity<Card>(cardService.deleteCard(id),HttpStatus.OK);
	}
	
}
