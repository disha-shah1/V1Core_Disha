package helper;

import org.testng.asserts.SoftAssert;

public class Assert {
	
protected Assert() {
		
	}
	
	//Assertion for true conditions
	public static void assertTrue(boolean condition, String message1, String message2) {
		try {
			org.testng.Assert.assertTrue(condition);
			pass(message1, message2);
		} catch (AssertionError e) {
			fail(message1, message2, e);
			throw (e);
		}
	}
	
	//Assertion for false conditions
	public static void assertFalse(boolean condition, String message1, String message2) {
		try {
			org.testng.Assert.assertFalse(condition);
			pass(message1,message2);
		} catch (AssertionError e) {
			fail(message1, message2, e);
			throw (e);
		}
	}
	
	//Soft-assertion
	public static void softAssertTrue(boolean condition, String message1, String message2){
		try {
			SoftAssert softAssertion= new SoftAssert();
			softAssertion.assertTrue(condition);
			pass(message1,message2);
		} catch (AssertionError e) {
			fail(message1, message2, e);
			throw (e);
		}	
	}
	
	
	//Assertion for compare and verification
	public static void assertEquals(boolean actual, boolean expected, String message) {
		assertEquals(actual, expected, message, null);
	}
		
	public static void assertEquals(String actual, String expected) {
		assertEquals(actual, expected, null, null);
	}
	
	public static void assertEquals(String actual, String expected, String message) {
		assertEquals(actual, expected, message, null);
	}
	
	public static void assertEquals(Object actual, Object expected, String message1, String message2) {
		try {
			org.testng.Assert.assertEquals(actual, expected);
			pass(message1, message2);
		} catch (AssertionError e) {
			fail(message1, message2, e);
			throw (e);
		}
	}
	

	private static void pass(String message1, String message2) {
		String msg1 = "";
		String msg2 = "";
		if(message1 != null) 
			msg1 = message1;
		if(message2 != null) 
			msg2 = message2;
		System.out.println("PASS:" +msg1+" "+ msg2);
	}
	
	private static void fail(String message1, String message2, Throwable e) {
		String msg1 = "";
		String msg2 = "";
		if(message1 != null) 
			msg1 = message1;
		if(message2 != null) 
			msg2 = "not " + message2;
		System.out.println("FAIL:" +msg1+" "+ msg2+" error is: "+e.getMessage());
	}


}
