package com.dnb.devConnector.exceptions;

public class EmailNotFoundException extends Exception{

	public EmailNotFoundException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return super.getMessage()+super.toString();
	}
	
}
