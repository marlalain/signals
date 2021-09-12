package com.pauloelienay.authenticationservice.service;

import com.pauloelienay.authenticationservice.model.User;
import com.pauloelienay.authenticationservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
	private final UserRepository repository;

	public void register(User user) {
		repository.save(user);
	}
}
