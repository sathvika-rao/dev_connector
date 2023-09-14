package com.dnb.devConnector.exceptions;

public class InvalidEmailAddressException extends Exception{

	public InvalidEmailAddressException(String msg) {
		super(msg);
	}

	public String toString() {
		return super.toString()+ super.getMessage();
	}
	
}
