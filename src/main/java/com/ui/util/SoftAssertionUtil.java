package com.ui.util;

import static org.testng.Assert.assertEquals;

public class SoftAssertionUtil { 
	//Custom AssertEquals which returns boolean values on Fail or Pass
	public static boolean customAssertEquals(String actual, String expected) {
		boolean status = true;
		try {
			assertEquals(actual, expected);
		}catch (AssertionError e) {
			status = false;
			throw e;
		}
		return status;
	}
}