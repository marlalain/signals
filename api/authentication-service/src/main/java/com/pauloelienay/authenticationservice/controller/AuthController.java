package com.pauloelienay.authenticationservice.controller;

import com.pauloelienay.authenticationservice.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {
	private final JwtUtil util;

	@GetMapping("/validate")
	public ResponseEntity<Void> validate(@RequestHeader("Authorization") String auth) {
		boolean isValid = util.validateToken(auth);
		if (!isValid) return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
