package com.dnb.devConnector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dnb.devConnector.dto.CreateProfile;
import com.dnb.devConnector.dto.Education;

@Service
public class EducationServiceImpl implements EducationService {
	
	

	@Override
	public Education createEducation(Education education) {
		// TODO Auto-generated method stub
		Optional<CreateProfile> profile = profileRepository.findById(education.getProfile().getProfileUUID());
		
		if(profile.isPresent()) {
			education.setProfile(profile.get());
			return educationRepository.save(education);
		}
		else {
			profile.orElseThrow(()->new IdNotFoundException("Profile id is not valid"));
		}
		return null;
	}

	@Override
	public Optional<Education> getEducationById(String educationId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Education> getAllEducations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEducationById(String educationId) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
