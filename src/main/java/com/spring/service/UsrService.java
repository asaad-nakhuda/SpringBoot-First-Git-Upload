package com.spring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.entity.UserDto;
import com.spring.entity.UserDto1;
import com.spring.repo.UsrRestRepo;

@Service
public class UsrService {
	
	private static final Logger log = LoggerFactory.getLogger(UsrService.class);

	private RestTemplate template;
	private UsrRestRepo repo;
	private final ModelMapper modelMapper;
	
	
	public UsrService(RestTemplate template, UsrRestRepo repo, ModelMapper modelMapper) {
		super();
		this.template = template;
		this.repo = repo;
		this.modelMapper = modelMapper;
	}

	@Value("${app.user.url}")
	private String url;
	
	public List<UserDto> fetchAllUsr(){
		
		ResponseEntity<List<UserDto>> exchangeValue = template.exchange(url, 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<List<UserDto>>() {
		});
		
		return exchangeValue.getBody();
	}
	
	public UserDto fetUsrById(long id) {
		String apiUrl = url +"/"+id;
		ResponseEntity<UserDto> exchangeByID = template.exchange(apiUrl, 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<UserDto>() {
		});
		
		return exchangeByID.getBody();
	}
	
	public List<UserDto> fetchAndSaveUser(){
		ResponseEntity<List<UserDto>> exchangeValue = template.exchange(url, 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<List<UserDto>>() {
		});
		
		List<UserDto> Usersbody = exchangeValue.getBody();
		List<UserDto> collectedBody = Usersbody.stream()
		.map(dto -> modelMapper.map(dto, UserDto.class))
		.collect(Collectors.toList());
		
		return repo.saveAll(collectedBody);
	}
	
	public List<UserDto> getAllUsersFromDb() {
        return repo.findAll();
    }
	
	public void fetchOnlyOne(Long id) {
		String apiUrl = url +"/"+id;
		UserDto UserByObject = template.getForObject(apiUrl, UserDto.class);
		System.out.println(UserByObject);
	}
	
	public void fetchByEntity(Long id) {
		String apiUrl = url +"/"+id;
		ResponseEntity<UserDto> UserByEntity = template.getForEntity(apiUrl, UserDto.class);
		
		if(UserByEntity.getStatusCode().is2xxSuccessful()) {
			System.out.println(UserByEntity.getHeaders());
			System.out.println(UserByEntity.getStatusCode());
			System.out.println(UserByEntity.getBody());
		}
	}
	
	public UserDto1 creatUser () {
		UserDto1 dtoo = new UserDto1();
		
		dtoo.setId(0);
		dtoo.setName("Asaad");
		dtoo.setEmail("asaadSample@gmail.com");
		dtoo.setUsername("asaad-nakhuda");
		
		ResponseEntity<UserDto1> postForEntity = template.postForEntity(url, dtoo, UserDto1.class);
		return postForEntity.getBody();
	}
	
	public void deleteUser(int id) {
		String apiUrl = url +"/"+id;
		template.delete(apiUrl + "/{id}", id);
		
		log.info("User got deleted ");
		
		
		
	}
}
