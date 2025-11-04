package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.UserDto;
import com.spring.entity.UserDto1;
import com.spring.service.UsrService;

@RestController
@RequestMapping("rest")
public class UsrRestController {

	@Autowired
	private UsrService service;
	
	
	@GetMapping("fetch-user")
	public ResponseEntity<?> getUserDetail(){
		List<UserDto> fetchAllUsr = service.fetchAllUsr();
		
		return new ResponseEntity<>(fetchAllUsr,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> getUserById(@PathVariable long id){
		UserDto fetUsrById = service.fetUsrById(id);
		service.fetchOnlyOne(id);
		service.fetchByEntity(id);
		
		return new ResponseEntity<>(fetUsrById, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/save-users")
	public List<UserDto> fetchAndSave(){
		return service.fetchAndSaveUser();
	}
	
	@GetMapping("/fetch-from-db")
    public List<UserDto> getAllFromDb() {
        return service.getAllUsersFromDb();
    }
	
	@PostMapping("/create-new")
	public ResponseEntity<UserDto1> createUsr() {
		
		UserDto1 createdUser = service.creatUser();
		return new ResponseEntity<>(createdUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
