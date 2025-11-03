package com.spring.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.entity.UserCrud;
import com.spring.repo.UserRepo;

@Service
public class UserCrudService {

	private UserRepo repo;

	public UserCrudService(UserRepo repo) {
		super();
		this.repo = repo;
	}
	
	public UserCrud modifyUser(UserCrud user,int id) {
		Optional<UserCrud> UserbyId = repo.findById(id);
		UserCrud userCrud = null;
		
		if(UserbyId.isPresent()) {
			userCrud = UserbyId.get();
			userCrud.setFirstName(user.getFirstName());
			userCrud.setDept(user.getDept());
			userCrud.setRole(user.getRole());
			
		}
		UserCrud newUser = repo.save(userCrud);
		
		return newUser;
	}
	
	public Optional<UserCrud> fetchUserById(int id) {
		Optional<UserCrud> findById = repo.findById(id);
		
		return findById;
	}
}
