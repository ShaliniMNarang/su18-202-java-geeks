package com.javageeks.cardservice.exception;

import com.javageeks.cardservice.util.Constants;

public class CardAlreadyExistException extends Exception{
	
	private static final long serialVersionUID = 1L;

	CardAlreadyExistException(){
		super(Constants.NOT_ENOUGH_BALANCE_EXP);
	}
}
