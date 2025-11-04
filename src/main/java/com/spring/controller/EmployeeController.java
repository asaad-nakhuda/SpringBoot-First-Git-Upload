package com.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Employee;
import com.spring.service.EmployeeService;

@RestController
@RequestMapping("emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/addEmp/depart/{departId}")
	public ResponseEntity<Employee> createEmpForDepart(@PathVariable int departId, 
					@RequestBody Employee employee){
		
		Employee saveEmpInDept = employeeService.saveEmpInDept(departId, employee);
		
		return ResponseEntity.ok(saveEmpInDept);
	}
	
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> fetchEmpById(@PathVariable int empId){
		Optional<Employee> empById = employeeService.findEmpById(empId);
		
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
}
