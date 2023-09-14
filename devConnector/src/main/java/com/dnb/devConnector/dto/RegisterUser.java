package com.dnb.devConnector.dto;

import java.util.regex.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.devConnector.exceptions.InvalidEmailAddressException;
import com.dnb.devConnector.exceptions.InvalidNameException;
import com.dnb.devConnector.exceptions.InvalidPasswordException;
import com.dnb.devConnector.utils.CustomIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private String password;
}
