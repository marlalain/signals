package com.pauloelienay.authenticationservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ExistentUniqueEntityFieldException extends RuntimeException {
	public ExistentUniqueEntityFieldException(String message) {
		super(message);
	}
}
