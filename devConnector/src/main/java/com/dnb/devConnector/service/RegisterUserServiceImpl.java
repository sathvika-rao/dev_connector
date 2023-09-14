package com.dnb.devConnector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devConnector.dto.RegisterUser;
import com.dnb.devConnector.exceptions.EmailNotFoundException;
import com.dnb.devConnector.repo.RegisterUserRepo;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {

	@Autowired
	RegisterUserRepo registerUserRepo;
	
	@Override
	public RegisterUser createUser(RegisterUser registerUser) {
		// TODO Auto-generated method stub
		return registerUserRepo.save(registerUser);
	}

	@Override
	public Optional<RegisterUser> getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return registerUserRepo.findById(email);
	}

	@Override
	public boolean deleteUserByEmail(String email) throws EmailNotFoundException {
		if(registerUserRepo.existsById(email)) {
			registerUserRepo.deleteById(email);
			return true;
		}
		else
			throw new EmailNotFoundException("Email not found");
	}

	@Override
	public List<RegisterUser> getUsers() {
		// TODO Auto-generated method stub
		return (List<RegisterUser>) registerUserRepo.findAll();
	}

}
