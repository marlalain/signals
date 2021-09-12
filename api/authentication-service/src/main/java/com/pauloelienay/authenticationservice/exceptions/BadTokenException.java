package com.pauloelienay.authenticationservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class BadTokenException extends RuntimeException {
	public BadTokenException(String message) {
		super(message);
	}
}
