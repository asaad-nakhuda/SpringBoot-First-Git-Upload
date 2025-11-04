package com.spring.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name="Users")
public class UserDto {
	
	@Id
	private Long id;
    private String name;
    private String username;
    private String email;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;
    private String phone;
    private String website;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="company_id")
    private Company company;
	
}
