package com.dnb.devConnector.payload.request;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterUserRequest {
	private String name;
	@NotBlank(message = "email address should not be blank")
	private String emailAddress;
	//@jakarta.validation.constraints.Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\\\d)[A-Za-z\\\\d]{8,}$")
	private String password;
//	@NotBlank
//	@Transient
//	private String confirmPassword;
}
