package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.entity.UserEntity;
import com.spring.payload.UserRequest;


@Service
public interface UserService {
	
	public List<UserEntity> getAllUsers();
	
	public Optional<UserEntity> getUserById(Long userId);
	
	public UserEntity createUser(UserRequest userRequest);
	
	public void deleteById(Long userId);
	
	

}
