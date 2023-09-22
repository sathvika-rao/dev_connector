package com.dnb.devConnector.exceptions;

public class DataNotFoundException extends Exception {

	public DataNotFoundException(String msg) {
		super(msg);
	}
	
	public String toString() {
		return super.getMessage()+super.toString();
	}
	
}
