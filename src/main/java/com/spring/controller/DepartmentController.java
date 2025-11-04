package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Department;
import com.spring.service.DepartmentService;


@RestController
@RequestMapping("dept")
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	@PostMapping("/create")
	public ResponseEntity<Department> createDepart(@RequestBody Department department) {
		//Department saveNewDepartment = service.saveNewDepartment(department);
		if (department.getEmployee() != null) {
	        department.getEmployee().forEach(emp -> emp.setDepartment(department));
	    }
		service.saveNewDepartment(department);
		
		return ResponseEntity.ok(department);
	}
	
	
	@GetMapping("/fetch-all-dept")
	public List<Department> getAllDepartment(){
		return service.getAllDepartment();
	}
	
	
}
