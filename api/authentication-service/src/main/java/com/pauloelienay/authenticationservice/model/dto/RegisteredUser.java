package com.pauloelienay.authenticationservice.model.dto;

import com.pauloelienay.authenticationservice.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisteredUser {
	private String email;
	private String name;
	private String username;

	public static RegisteredUser convertToDto(User user) {
		return builder().email(user.getEmail()).username(user.getUsername()).name(user.getName()).build();
	}
}
