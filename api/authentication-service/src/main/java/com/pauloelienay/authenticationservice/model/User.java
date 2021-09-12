package com.pauloelienay.authenticationservice.model;

import com.pauloelienay.authenticationservice.model.dto.RegisteredUser;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Document("users")
public class User {
	@MongoId
	private String id;

	@NotBlank(message = "A name is required.")
	@Size(min = 1, max = 100)
	private String name;

	@Indexed(unique = true)
	@NotBlank(message = "An email is required.")
	@Email(message = "This is not a valid email.")
	private String email;

	@Indexed(unique = true)
	@NotBlank(message = "A username is required.")
	@Size(min = 3, max = 100)
	private String username;

	@NotBlank(message = "A password is required.")
	private String password;

	private LocalDateTime createdAt = LocalDateTime.now();

	public RegisteredUser convertToDto() {
		return RegisteredUser.convertToDto(this);
	}
}
