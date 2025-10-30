package com.spring.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix ="cities")
public class UserConfig {

	private List<String> maharashtra;

	public List<String> getMaharashtra() {
		return maharashtra;
	}

	public void setMaharashtra(List<String> maharashtra) {
		this.maharashtra = maharashtra;
	}

	
}
