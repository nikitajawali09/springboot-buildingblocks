package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.entity.UserEntity;


@Service
public interface UserService {
	
	public List<UserEntity> getAllUsers();
	
	

}
