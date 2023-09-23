package com.dnb.devConnector.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conversions {

	public List stringToArrayList(String str) {
		List<String> list = new ArrayList<String>(Arrays.asList(str.split(",")));
		return list;
		
	}
	
}
