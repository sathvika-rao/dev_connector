package com.dnb.devConnector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devConnector.dto.CreateProfile;
import com.dnb.devConnector.dto.Education;
import com.dnb.devConnector.dto.Experience;
import com.dnb.devConnector.exceptions.IdNotFoundException;
import com.dnb.devConnector.repo.CreateProfileRepo;
import com.dnb.devConnector.repo.ExperienceRepo;

@Service
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	ExperienceRepo experienceRepo;
	
	@Autowired
	CreateProfileRepo profileRepo;

	@Override
	public Experience createExperience(Experience experience) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<CreateProfile> profile = profileRepo.findById(experience.getCreateProfile().getProfileId());
		if(profile.isPresent()) {
			experience.setCreateProfile(profile.get());
			return experienceRepo.save(experience);
		}
		else 
			throw new IdNotFoundException("Profile Id does not exist");
	}

	@Override
	public Optional<Experience> getExperienceById(String experienceId) {
		// TODO Auto-generated method stub
		return experienceRepo.findById(experienceId);
	}

	@Override
	public boolean deleteExperienceById(String experienceId) {
		// TODO Auto-generated method stub
		if(experienceRepo.existsById(experienceId)) {
			experienceRepo.deleteById(experienceId);
			return true;
		}
		else
			return false;
	}

	@Override
	public List<Experience> getExperiences() {
		// TODO Auto-generated method stub
		return (List<Experience>) experienceRepo.findAll();
	}

	

}
