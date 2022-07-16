package com.spring.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.UserEntity;
import com.spring.payload.UserRequest;
import com.spring.repository.UserRepository;
import com.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public List<UserEntity> getAllUsers() {
		List<UserEntity> userEntity=null;
		try {
			userEntity = userRepository.findAll();
			System.out.println(userEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("hi");
		return userEntity;
	}

	@Override
	@Transactional
	public UserEntity createUser(UserRequest userRequest) {
		UserEntity userEntity = null;
		
		try {
     
			userEntity = new UserEntity();
			userEntity.setFirstName(userRequest.getFirstName());
			userEntity.setLastName(userRequest.getLastName());
			userEntity.setEmail(userRequest.getEmail());
			userEntity.setRole(userRequest.getRole());
			userEntity.setSsn(userRequest.getSsn());
			userEntity.setUserName(userRequest.getUserName());
			userEntity = userRepository.save(userEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userEntity;
	}

	@Override
	@Transactional
	public void deleteById(Long userId) {
		try {
			userRepository.deleteById(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Optional<UserEntity> getUserById(Long userId) {
		return userRepository.findById(userId);
		 
	}
}
