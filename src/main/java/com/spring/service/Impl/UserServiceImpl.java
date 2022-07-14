package com.spring.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.UserEntity;
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
}
