package com.spring.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.config.UserConfig;
import com.spring.entity.DataRecord;
import com.spring.entity.User;
import com.spring.service.JsonProcessingService;
import com.spring.service.UserService;

@RestController
@RequestMapping("api")
public class UserController {
	
	private final UserConfig config;
	private UserService service;
	private JsonProcessingService processingService;

	

	public UserController(UserConfig config, UserService service, JsonProcessingService processingService) {
		super();
		this.config = config;
		this.service = service;
		this.processingService = processingService;
	}

	LocalDateTime date = LocalDateTime.now();
	
	@GetMapping("/user")
	public User getUser(@RequestParam(name ="brand", required = false) String brand,
			@RequestParam(name = "name", required = false) String name) {
		
		
		return new User(brand,name,date);
		
	}
	
	@GetMapping("cities")
	public List<?> getCities(){
		return config.getMaharashtra();
	}
	
	@GetMapping("/test-circuit")
	public String testCircuitBreaker(@RequestParam(defaultValue = "false") boolean fail) {
		return service.getDataFromExternalService(fail);
	}
	
	@PostMapping("dirty-json")
	public ResponseEntity<?> cleanJsonObject(@RequestBody String dirtyJson) throws Exception{
		DataRecord processDirtyJson = processingService.processDirtyJson(dirtyJson);
		
		return new ResponseEntity<>(processDirtyJson,HttpStatus.OK);
		
	}
	
	@GetMapping("/items/{id}")
    public String getItem(@PathVariable String id) throws Exception {
        if ("invalid".equals(id)) {
            throw new IllegalArgumentException("Invalid item ID provided.");
        }
        if ("notfound".equals(id)) {
            throw new Exception("Item not found with ID: " + id);
        }
        return "Item details for ID: " + id;
    }
	
	@GetMapping("new-git")
	public String getFirstNewGitChanges()
	{
		return "Added some changes into the controller";
	}
}
