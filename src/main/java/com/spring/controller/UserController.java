package com.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.spring.entity.UserEntity;
import com.spring.exceptions.CustomGlobalExceptionHandler;
import com.spring.exceptions.NoDataFoundException;
import com.spring.exceptions.UserNameNotFoundException;
import com.spring.payload.UserRequest;
import com.spring.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
@Api(tags = "User management service",description = "controller for user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@ApiOperation(value = "Retrieve List of all users")
	@GetMapping("/getAllUsers")
	public List<UserEntity> getAllUsers(){
		return userService.getAllUsers();
	}

	@GetMapping("/getUserById/{userId}")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> getUserById(@PathVariable("userId") Long userId) throws UserNameNotFoundException{
		 Optional<UserEntity> u = userService.getUserById(userId);
		 
		 if(u==null) {
			 throw new NoDataFoundException("No data found");
		 }
		return new ResponseEntity<>(u,HttpStatus.OK) ;
	}

	
	@PostMapping("/createUser")
	
	public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserRequest userRequest)
	{
	    UserEntity u =userService.createUser(userRequest);
		return new ResponseEntity<>(u,HttpStatus.OK) ;
	}

}
