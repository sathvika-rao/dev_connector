package com.dnb.devConnector.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devConnector.dto.CreateProfile;
import com.dnb.devConnector.exceptions.IdNotFoundException;
import com.dnb.devConnector.repo.CreateProfileRepo;

@Service
public class CreateProfileServiceImpl implements CreateProfileService {
	
	@Autowired
	CreateProfileRepo createProfileRepo;
	
	@Override
	public CreateProfile createProfile(CreateProfile createProfile) {
		// TODO Auto-generated method stub
		/*String str = UUID.randomUUID().toString().substring(0, 5);
		createProfile.setProfileId(str);*/
		return createProfileRepo.save(createProfile);
	}

	@Override
	public Optional<CreateProfile> getProfileById(String id) {
		// TODO Auto-generated method stub
		return createProfileRepo.findById(id);
	}

	@Override
	public boolean deleteProfileById(String id) throws IdNotFoundException {
		if(createProfileRepo.existsById(id)) {
			createProfileRepo.deleteById(id);
			return true;
		}
		else 
			throw new IdNotFoundException("Id is not present");
	}

	@Override
	public List<CreateProfile> getProfiles() {
		// TODO Auto-generated method stub
		return (List<CreateProfile>) createProfileRepo.findAll();
	}

	

}
