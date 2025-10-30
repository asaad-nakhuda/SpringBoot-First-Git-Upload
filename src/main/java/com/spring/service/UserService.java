package com.spring.service;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class UserService {

	
	@CircuitBreaker(name ="myService", fallbackMethod = "fallbackForGetData")
	public String getDataFromExternalService(boolean fail) {
		if(fail) {
			throw new RuntimeException("Simulated service got failed");
		}
		return "Data from external service";
	}
	
	public String fallbackForGetData(boolean fail, Throwable t) {
        return "Fallback: External service is unavailable or circuit is open. Error: " + t.getMessage();
    }
}
