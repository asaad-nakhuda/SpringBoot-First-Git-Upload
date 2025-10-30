package com.spring.entity;

import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DataRecord {
	

	private String id;
	private String description;
	
	
	public void sanitizeId() {
        if (this.id != null) {
            Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
            this.id = pattern.matcher(this.id).replaceAll("");
        }
    }
}
