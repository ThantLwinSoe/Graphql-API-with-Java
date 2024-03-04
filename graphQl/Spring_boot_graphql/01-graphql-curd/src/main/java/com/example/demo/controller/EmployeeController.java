package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeInput;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@QueryMapping
	public Employee createEmployee(EmployeeInput employeeInput) {
		Employee emp = service.createEmployee(employeeInput);
		return emp;
	}
	
}
