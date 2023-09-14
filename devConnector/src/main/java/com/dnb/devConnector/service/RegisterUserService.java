package com.dnb.devConnector.service;

import java.util.List;
import java.util.Optional;

import com.dnb.devConnector.dto.RegisterUser;
import com.dnb.devConnector.exceptions.EmailNotFoundException;

public interface RegisterUserService {
	
	public RegisterUser createUser(RegisterUser registerUser);
	
	public Optional<RegisterUser> getUserByEmail(String email);
	
	public boolean deleteUserByEmail(String email) throws EmailNotFoundException;
	
	public List<RegisterUser> getUsers();
	
}
