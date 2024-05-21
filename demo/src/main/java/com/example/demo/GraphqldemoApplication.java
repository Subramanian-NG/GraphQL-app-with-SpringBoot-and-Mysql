package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.EmployeeRepository;

@SpringBootApplication
public class GraphqldemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(GraphqldemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
		return test -> {
			// getEmployees(employeeRepository);
		};
	}

	public void getEmployees(EmployeeRepository employeeRepository) {
		System.out.println("print employees");
		System.out.println(employeeRepository.findAll());
	}

}
