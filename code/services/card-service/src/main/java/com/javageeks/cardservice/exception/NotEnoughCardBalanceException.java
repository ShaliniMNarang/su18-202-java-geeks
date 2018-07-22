package com.javageeks.cardservice.exception;

import com.javageeks.cardservice.util.Constants;

public class NotEnoughCardBalanceException extends Exception{
	
	private static final long serialVersionUID = 1L;

	NotEnoughCardBalanceException(){
		super(Constants.NOT_ENOUGH_BALANCE_EXP);
	}
}
