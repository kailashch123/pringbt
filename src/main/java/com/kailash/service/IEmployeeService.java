package com.kailash.service;

import java.util.List;

import com.kailash.model.Employee;

public interface IEmployeeService {
	
	Employee findOneById(int empId);

	List<Employee> findAll();

	Employee save(Employee user);

	Employee delete(int empId);
}
