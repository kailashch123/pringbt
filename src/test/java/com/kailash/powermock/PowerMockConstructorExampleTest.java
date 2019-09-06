package com.kailash.powermock;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Test1.class)
public class PowerMockConstructorExampleTest {

	@Mock
	private Test1 instance;

	@Before
	public void setUp() {
		System.out.println("aaa");
		when(Test1.getMessage()).thenReturn("asfd");
		System.out.println(111);
//		PowerMockito.mockStatic(Test1.class);
	}

	@Test
	public void testMockConstructor() throws Exception {
		System.out.println("sdasd");
//		PowerMockito.mockStatic(Test1.class);

	}
}
