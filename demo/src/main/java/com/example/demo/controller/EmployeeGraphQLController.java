package com.example.demo.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.dao.EmployeeRepository;

import com.example.demo.entity.*;

@Controller
public class EmployeeGraphQLController {

    EmployeeRepository employeeRepository;

    public EmployeeGraphQLController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @QueryMapping
    public List<Employee> employees() {
        List<Employee> employees = employeeRepository.findAll();
        // System.out.println("printing employees");
        // System.out.println(employees);
        return employees;
    }

    @QueryMapping
    public Employee getEmployee(@Argument Integer id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @QueryMapping
    public Employee getEmployeeByEmail(@Argument String email) {
        return employeeRepository.findEmployeeByEmail(email);
    }

    @MutationMapping
    public Employee createEmployee(@Argument(name = "input") EmployeeInput employeeInput) {
        Employee employee = employeeInput.getEmployeeEntity();
        return employeeRepository.save(employee);
    }

    @MutationMapping
    public Employee updateEmployee(@Argument Integer id, @Argument(name = "input") EmployeeInput employeeInput) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        if (employeeInput.getFirstName() != null) {
            employee.setFirstName(employeeInput.getFirstName());
        }
        if (employeeInput.getLastName() != null) {
            employee.setLastName(employeeInput.getLastName());
        }
        if (employeeInput.getEmail() != null) {
            employee.setEmail(employeeInput.getEmail());
        }
        return employeeRepository.save(employee);
    }

    @MutationMapping
    public String deleteEmployee(@Argument Integer id) {
        employeeRepository.deleteById(id);
        return "Employee deleted";
    }
}
