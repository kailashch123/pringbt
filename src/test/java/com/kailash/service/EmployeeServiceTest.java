package com.kailash.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.kailash.repository.EmployeeRepository;

@RunWith(PowerMockRunner.class)
@PrepareForTest({EmployeeService.class})
public class EmployeeServiceTest {
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private IEmployeeService employeeService;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	/*
	 * private Txnstatic txnStaticMock = mock(Txnstatic.class);
	 * when(txnStaticMock.getstaticmethod).thenretur(trure);
	 */
	@Test
	public void testFindOneById() throws Exception {
		int input = 2;
		EmployeeService txnStaticMock = mock(EmployeeService.class);
		mockStatic(EmployeeService.class);
		when(EmployeeService.staticMethodCall()).thenReturn("abcd");
		String actual = EmployeeService.staticMethodCall();
		assertEquals("static method call", actual);
		
	}

}
