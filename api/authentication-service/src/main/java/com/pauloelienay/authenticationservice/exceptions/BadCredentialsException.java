package com.pauloelienay.authenticationservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class BadCredentialsException extends RuntimeException{
	public BadCredentialsException(String message) {
		super(message);
	}
}
