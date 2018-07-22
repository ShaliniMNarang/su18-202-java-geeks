package com.javageeks.cardservice.exception;

import com.javageeks.cardservice.util.Constants;

public class InvalidCardTypeException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public InvalidCardTypeException(){
		super(Constants.INVALID_CARD_TYPE_EXP);
	}
}
