package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.UserDto;

@Repository
public interface UsrRestRepo extends JpaRepository<UserDto, Long>{

}
