package com.pauloelienay.authenticationservice.controller;

import com.pauloelienay.authenticationservice.model.User;
import com.pauloelienay.authenticationservice.model.dto.LoginRequest;
import com.pauloelienay.authenticationservice.model.dto.LoginResponse;
import com.pauloelienay.authenticationservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
	private final UserService service;

	@PostMapping("/register")
	public ResponseEntity<Void> register(@Valid @RequestBody User user) {
		service.register(user);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest user) {
		return new ResponseEntity<>(service.login(user), HttpStatus.OK);
	}
}
