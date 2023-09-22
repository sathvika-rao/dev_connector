package com.dnb.devConnector.service;

import java.util.List;
import java.util.Optional;

import com.dnb.devConnector.dto.RegisterUser;
import com.dnb.devConnector.exceptions.EmailNotFoundException;

public interface RegisterUserService {
	
	public RegisterUser createUser(RegisterUser registerUser);
	
	public Optional<RegisterUser> getUserById(String userId);
	
	public boolean deleteUserById(String userId);
	
	public List<RegisterUser> getUsers();
	
}
