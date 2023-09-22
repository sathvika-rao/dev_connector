package com.dnb.devConnector.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devConnector.dto.CreateProfile;
import com.dnb.devConnector.dto.RegisterUser;
import com.dnb.devConnector.exceptions.IdNotFoundException;
import com.dnb.devConnector.repo.CreateProfileRepo;
import com.dnb.devConnector.repo.RegisterUserRepo;

@Service
public class CreateProfileServiceImpl implements CreateProfileService {
	
	@Autowired
	CreateProfileRepo createProfileRepo;
	
	@Autowired
	RegisterUserRepo registerUserRepo;
	
	@Override
	public CreateProfile createProfile(CreateProfile createProfile) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<RegisterUser> user = registerUserRepo.findById(createProfile.getRegisterUser().getUserId());
		if(user.isPresent()) {
			createProfile.setRegisterUser(user.get());
			return createProfileRepo.save(createProfile);
		}
		else
			throw new IdNotFoundException("User id is not present");
	}

	@Override
	public Optional<CreateProfile> getProfileById(String id) {
		// TODO Auto-generated method stub
		return createProfileRepo.findById(id);
	}

	@Override
	public boolean deleteProfileById(String id) {
		if(createProfileRepo.existsById(id)) {
			createProfileRepo.deleteById(id);
			return true;
		}
		else 
			return false;
	}

	@Override
	public List<CreateProfile> getProfiles() {
		// TODO Auto-generated method stub
		return (List<CreateProfile>) createProfileRepo.findAll();
	}

	

}
