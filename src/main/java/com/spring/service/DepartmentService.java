package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.entity.Department;
import com.spring.repo.DeptRepo;

@Service
public class DepartmentService {

	private DeptRepo deptRepo;

	public DepartmentService(DeptRepo deptRepo) {
		super();
		this.deptRepo = deptRepo;
	}
	
	public Department saveNewDepartment(Department department) {
		return deptRepo.save(department);
	}
	
	public List<Department> getAllDepartment(){
		return deptRepo.findAll();
	}
}
