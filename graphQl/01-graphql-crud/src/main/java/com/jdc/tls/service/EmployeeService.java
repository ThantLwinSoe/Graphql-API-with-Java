package com.jdc.tls.service;

import com.jdc.tls.entity.Employee;
import com.jdc.tls.entity.EmployeeInput;
import com.jdc.tls.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeeRepository repository;

    public Employee createEmployee(EmployeeInput input) {
        var emp = new Employee(input.getName(),input.getAge(),input.getDepartment());
        repository.save(emp);
        return emp;
    }

    public List<Employee> findAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Integer id){
        Optional<Employee> employee = repository.findById(id);

        return employee.get();
    }

    public Employee updateEmployee(Integer id, EmployeeInput employeeInput){

        var emp = getEmployeeById(id);
        emp.setName(employeeInput.getName());
        emp.setAge(employeeInput.getAge());
        emp.setDepartment(employeeInput.getDepartment());

        repository.saveAndFlush(emp);

        return emp;
    }

    public Employee deleteEmployee(Integer id){

        var emp = getEmployeeById(id);

        repository.delete(emp);

        return emp;
    }

}
