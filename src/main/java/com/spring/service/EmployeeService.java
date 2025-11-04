package com.spring.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.entity.Department;
import com.spring.entity.Employee;
import com.spring.repo.DeptRepo;
import com.spring.repo.EmpRepo;

@Service
public class EmployeeService {

	private EmpRepo empRepo;
	private DeptRepo deptRepo;
	
	public EmployeeService(EmpRepo empRepo, DeptRepo deptRepo) {
		super();
		this.empRepo = empRepo;
		this.deptRepo = deptRepo;
	}



	public Employee saveEmpInDept(int deptId,Employee employee) {
		Optional<Department> DeptById = deptRepo.findById(deptId);
		
		Department department = deptRepo.findById(deptId)
	            .orElseThrow(() -> new RuntimeException("Department not found with id: " + deptId));
		
		employee.setDepartment(department);
		return empRepo.save(employee);
	}
	
	public Optional<Employee> findEmpById(int id) {
		Optional<Employee> byId = empRepo.findById(id);
		
		return byId;
	}
}
