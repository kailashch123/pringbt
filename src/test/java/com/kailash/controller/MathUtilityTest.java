package com.kailash.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MathUtilityTest {

	MathUtility mu = new MathUtility();

	/**
	 * @Before and @After 
	 * Run before every test methods.
	 */
	@Before
	public void before() {
		System.out.println("before");
	}

	@After
	public void after() {
		System.out.println("after");
	}

	/**
	 * @BeforeClass and @AfterClass 
	 * stattic methods which are execute once before and after the test class.
	 */
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass");
	}

	@Test
	public void testSum() {
		int expected = 6;
		assertEquals(expected, mu.sum(4, 2));
		System.out.println("testSum");
	}

}
