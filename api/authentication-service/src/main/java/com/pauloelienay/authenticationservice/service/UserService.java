package com.pauloelienay.authenticationservice.service;

import com.pauloelienay.authenticationservice.exceptions.BadCredentialsException;
import com.pauloelienay.authenticationservice.exceptions.EntityNotFoundException;
import com.pauloelienay.authenticationservice.exceptions.ExistentUniqueEntityFieldException;
import com.pauloelienay.authenticationservice.model.User;
import com.pauloelienay.authenticationservice.model.dto.LoginRequest;
import com.pauloelienay.authenticationservice.model.dto.LoginResponse;
import com.pauloelienay.authenticationservice.repository.UserRepository;
import com.pauloelienay.authenticationservice.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
	private final UserRepository repository;
	private final JwtUtil util;

	public void register(User user) {
		try {
			repository.save(user);
		} catch (Exception e) {
			throw new ExistentUniqueEntityFieldException("This username or email are being used.");
		}
	}

	public LoginResponse login(LoginRequest user) {
		User userDB = repository.findByUsername(user.getUsername())
			.orElseThrow(() -> new EntityNotFoundException("Username not found."));

		if (!Objects.equals(userDB.getPassword(), user.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}

		return new LoginResponse(util.generateToken(user));
	}
}
