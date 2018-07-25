package com.javageeks.cardservice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.javageeks.cardservice.entity.Card;
import com.javageeks.cardservice.entity.CardDaoImpl;
import com.javageeks.cardservice.exception.InValidCardException;


public class CardDaoImplTest extends CardServiceApplicationTests{

	@Autowired
	CardDaoImpl cardDaoImpl;
	
	Card card1=null;
	Long userId=999L;
	
	@Before
	public void initData() {
		card1=new Card();
		card1.setCardNumber("4444444444444444");
		card1.setCardHolderName("Test User 1");
		card1.setCardExpirationDate("12/23");
		card1.setUserId(999L);
		card1=cardDaoImpl.addCard(card1);
	}
	
	@Test
	public void testGetCardById() {
		Assert.assertEquals("4444444444444444", cardDaoImpl.getCard(card1.getId()).getCardNumber());
	}
	
	@Test
	public void testGetCardByUserId() {
		Assert.assertEquals("4444444444444444", cardDaoImpl.getCardBYUserId(userId).get(0).getCardNumber());
	}
	
	@Test
	public void testUpdateCard() {
		Assert.assertEquals("Test User 1", cardDaoImpl.getCardBYUserId(userId).get(0).getCardHolderName());
		card1.setCardHolderName("Test User 1 Updated");
		try {
			cardDaoImpl.updateCard(card1);
		} catch (InValidCardException e) {
			e.printStackTrace();
		}
		Assert.assertEquals("Test User 1 Updated", cardDaoImpl.getCardBYUserId(userId).get(0).getCardHolderName());
	}
	
	@After
	public void cleanUp() {
		cardDaoImpl.deleteCard(card1.getId());
	}

}
