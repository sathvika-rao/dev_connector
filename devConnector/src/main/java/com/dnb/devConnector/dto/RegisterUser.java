package com.dnb.devConnector.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.devConnector.exceptions.InvalidEmailAddressException;
import com.dnb.devConnector.exceptions.InvalidNameException;
import com.dnb.devConnector.exceptions.InvalidPasswordException;
import com.dnb.devConnector.utils.CustomIdGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity

public class RegisterUser {

	public RegisterUser(String name, String emailAddress, String password) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		this.password = password;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registerUser_seq") //if generator is specified, then it'll know to use its wrapper class
	@GenericGenerator(name = "registerUser_seq", strategy = "com.dnb.devConnector.utils.CustomIdGenerator",
			parameters = {@Parameter(name =CustomIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "user_"),
			@Parameter(name=CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d"),
			@Parameter(name=CustomIdGenerator.FLAG_PARAMETER, value = "false")
	})
	private String userId;
	private String name;
	private String emailAddress;
	@jakarta.validation.constraints.Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\\\d)[A-Za-z\\\\d]{8,}$")
	private String password;
//	@NotBlank
//	@Transient
//	private String confirmPassword;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy =  "registerUser")
	private CreateProfile createProfile;
}
