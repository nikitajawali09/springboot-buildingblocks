package com.spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class NoDataFoundException extends RuntimeException {

	public NoDataFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}
