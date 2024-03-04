package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.EmployeeRepository;
import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeInput;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employRepository;
	
	public Employee createEmployee(EmployeeInput employeeInput) {
		var employee =  new Employee(employeeInput.getName(),employeeInput.getAge(),employeeInput.getDepartment());
		employRepository.save(employee);
		return employee;
	}

}
