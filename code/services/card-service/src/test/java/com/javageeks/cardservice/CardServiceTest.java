package com.javageeks.cardservice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.javageeks.cardservice.entity.Card;
import com.javageeks.cardservice.entity.CardBase;
import com.javageeks.cardservice.entity.CardFactory;
import com.javageeks.cardservice.entity.CardService;


public class CardServiceTest extends CardServiceApplicationTests{

	@Autowired
	CardService cardService;
	
	Card card1=new Card();
	Long userId=999L;
	
	@Before
	public void initData() {
		CardBase card1=(new CardFactory()).getCard("CC");
		card1.setCardNumber("4444444444444444");
		card1.setCardHolderName("Test User 1");
		card1.setCardExpirationDate("12/23");
		card1.setUserId(999L);
		addCard(card1);
	}
	
	@Test
	public void testGetCardById() {
		Assert.assertEquals("4444444444444444", cardService.getCard(card1.getId()).getCardNumber());
	}
	
	@Test
	public void testGetCardByUserId() {
		Assert.assertEquals("4444444444444444", cardService.getCardBYUserId(userId).get(0).getCardNumber());
	}
	
	@Test
	public void testUpdateCard() {
		Assert.assertEquals("Test User 1", cardService.getCardBYUserId(userId).get(0).getCardHolderName());
		card1.setCardHolderName("Test User 1 Updated");
		card1.setCardNumber("9999999999999999");
		try {
			cardService.updateCard(card1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals("Test User 1 Updated", cardService.getCardBYUserId(userId).get(0).getCardHolderName());
	}
	
	@Test
	public void testUpdateInvalidCard() {
		card1.setCardHolderName("Test User 1 Updated");
		card1.setCardNumber("99999999999999"); //length 15
		try {
			cardService.updateCard(card1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotEquals("Test User 1 Updated", cardService.getCardBYUserId(userId).get(0).getCardHolderName());
	}
	
	public void addCard(CardBase card) {
		card1.setUserId(card.getUserId());
		card1.setCardHolderName(card.getCardHolderName());
		card1.setCardNumber(card.getCardNumber());
		card1.setCardExpirationDate(card.getCardExpirationDate());
		card1=cardService.addCard((Card)card1);
	}
	
	@After
	public void cleanUp() {
		cardService.deleteCard(card1.getId());
	}

}
