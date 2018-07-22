package com.javageeks.cardservice.exception;

import com.javageeks.cardservice.util.Constants;

public class InValidCardException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public InValidCardException(){
		super(Constants.INVALID_CARD_EXP);
	}
}
