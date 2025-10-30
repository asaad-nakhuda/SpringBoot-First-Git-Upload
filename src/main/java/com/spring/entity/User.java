package com.spring.entity;

import java.time.LocalDateTime;

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
public class User {
	private String name;
	private String brand;
	private LocalDateTime time;
	/*
	 * public String getName() { return name; } public void setName(String name) {
	 * this.name = name; } public String getBrand() { return brand; } public void
	 * setBrand(String brand) { this.brand = brand; } public LocalDateTime getTime()
	 * { return time; } public void setTime(LocalDateTime time) { this.time = time;
	 * } public User(String name, String brand, LocalDateTime time) { super();
	 * this.name = name; this.brand = brand; this.time = time; }
	 * 
	 * @Override public String toString() { return "User [name=" + name + ", brand="
	 * + brand + ", time=" + time + "]"; }
	 */
	
	

}
