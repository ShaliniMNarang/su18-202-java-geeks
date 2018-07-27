package com.javageeks.cardservice;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.javageeks.cardservice.controller.CardController;
import com.javageeks.cardservice.entity.Card;
import com.javageeks.cardservice.entity.CardService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CardController.class, secure = false)
public class CardControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CardService cardServiceMock;
	
	private List<Card> cards=new ArrayList<>();
	private Long userId=999L;
	
	@Before
	public void initData() {
		Card card;
		card=new Card();
		card.setUserId(userId);
		card.setCardNumber("4444444444444444");
		card.setCardHolderName("Test card Holder 3");
		card.setCardExpirationDate("12/22");
		cards.add(card);
	}
	
	@Test
	public void testGetCardByUserId() throws Exception {
		Mockito.when(cardServiceMock.getCardBYUserId(userId)).thenReturn(cards);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/card/user/"+userId).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("chida:"+result.getResponse().getContentAsString());
		String expected = "[{\"id\":null,\"userId\":999,\"cardNumber\":\"4444444444444444\",\"cardHolderName\":\"Test card Holder 3\",\"cardExpirationDate\":\"12/22\",\"cardBalance\":0.0,\"cardType\":null,\"defaultCard\":null,\"status\":null}]";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}
