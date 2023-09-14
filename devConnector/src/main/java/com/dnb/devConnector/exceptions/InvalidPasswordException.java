package com.dnb.devConnector.exceptions;

public class InvalidPasswordException extends Exception{
	
	public InvalidPasswordException(String msg) {
		super(msg);
	}

	public String toString() {
		return super.toString()+ super.getMessage();
	}
}
