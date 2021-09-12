package com.pauloelienay.authenticationservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users", uniqueConstraints = {
	@UniqueConstraint(columnNames = "username"),
	@UniqueConstraint(columnNames = "email"),
})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "A name is required.")
	@Size(min = 1, max = 100)
	private String name;

	@NotBlank(message = "An email is required.")
	@Email(message = "This is not a valid email.")
	private String email;

	@NotBlank(message = "A username is required.")
	@Size(min = 3, max = 100)
	private String username;

	@NotBlank(message = "A password is required.")
	private String password;

	private LocalDateTime createdAt = LocalDateTime.now();
}
