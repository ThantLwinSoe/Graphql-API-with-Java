package com.jdc.tls.controller;

import com.jdc.tls.entity.Employee;
import com.jdc.tls.entity.EmployeeInput;
import com.jdc.tls.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @MutationMapping
    public Employee create(@Argument EmployeeInput employeeInput) {
        return service.createEmployee(employeeInput);
    }

    @QueryMapping
    public List<Employee> getEmployees() {
        return service.findAllEmployees();
    }

    @QueryMapping
    public Employee getEmployeeById(@Argument Integer uid){
        return service.getEmployeeById(uid);
    }

    @MutationMapping
    public Employee update(@Argument Integer id,
                           @Argument EmployeeInput employeeInput){
        return service.updateEmployee(id,employeeInput);
    }

    @MutationMapping
    public Employee delete(@Argument Integer id){
        return service.deleteEmployee(id);
    }

}
