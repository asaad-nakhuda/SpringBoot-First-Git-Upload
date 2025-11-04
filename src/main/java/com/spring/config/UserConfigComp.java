package com.spring.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserConfigComp {

	@Value("#{'${cities.maharashtra}'.split(',')}")
	private List<String> cities;
	
	public List<String> getAllMahCities(){
		return cities;
	}
	
	@Value("${app.name}")
    private String applicationName;

    public void printAppName() {
        System.out.println("Application Name: " + applicationName);
    }
}
