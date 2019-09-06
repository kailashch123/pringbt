package com.kailash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kailash.model.Employee;
import com.kailash.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="/{empId}")
	Employee findOneById(int empId) {
		return employeeService.findOneById(empId);
	}
	@GetMapping
	List<Employee> findAll() {
		return employeeService.findAll();
	}

	@PostMapping
	Employee save(@RequestBody Employee emp) {
		return employeeService.save(emp);
	}

	@DeleteMapping(value="/{empId}")
	Employee delete(@PathVariable int empId) {
		return employeeService.delete(empId);
	}
}
