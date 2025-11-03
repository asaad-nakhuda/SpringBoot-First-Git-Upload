package com.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.UserCrud;
import com.spring.repo.UserRepo;
import com.spring.service.UserCrudService;

@RestController
@RequestMapping("crud")
public class UserCrudController {

	private final UserRepo repo;
	private UserCrudService crudService;
	

	public UserCrudController(UserRepo repo, UserCrudService crudService) {
		super();
		this.repo = repo;
		this.crudService = crudService;
	}

	@GetMapping("fetch-all")
	public List<UserCrud> getAllUser() {
		return repo.findAll();
		
	}
	
	@GetMapping("fetch/{id}")
	public ResponseEntity<UserCrud> getUserById(@PathVariable int id){
		Optional<UserCrud> userById = crudService.fetchUserById(id);
		
		return userById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping("create-user")
	public ResponseEntity<UserCrud> createUser(@RequestBody UserCrud user) {
		 UserCrud savedUser = repo.save(user);
		 return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("delete-user/{id}")
	public ResponseEntity<?> removeUser(@PathVariable int id){
		Optional<UserCrud> userById = repo.findById(id);
		
		if(userById.isPresent()) {
			repo.deleteById(id);
		}
		
		return new ResponseEntity<>("User Deleted ",HttpStatus.GONE);
	}
	
	@PutMapping("modify/{id}")
	public ResponseEntity<UserCrud> modifyUsr(@RequestBody UserCrud usr,@PathVariable int id){
		UserCrud modifyUser = crudService.modifyUser(usr, id);
		
		return new ResponseEntity<>(modifyUser,HttpStatus.OK);
		
	}
	
}
