package com.kailash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kailash.model.Employee;
import com.kailash.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeService implements IEmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public static String staticMethodCall() {
		return "static method call";
	}

	@Override
	public Employee findOneById(int empId) {
		Optional<Employee> optional = employeeRepository.findById(empId);
		Employee emp = null;
		if(optional.isPresent()) {
			emp = optional.get();
		}
		return emp;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public Employee delete(int empId) {
		Employee e = findOneById(empId);
		if(null != e) {
			employeeRepository.delete(e);
		}
		return e;
	}

	
}
