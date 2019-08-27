package com.kailash.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PalindromeControllerTest {

	@Test
	public void test() {
		PalindromeController palindromeTester = new PalindromeController();
		String expected = "No input available";
		assertEquals(expected, palindromeTester.isPalindrome(""));
	}

}
