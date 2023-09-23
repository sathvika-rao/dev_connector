package com.dnb.devConnector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devConnector.dto.CreateProfile;
import com.dnb.devConnector.dto.Education;
import com.dnb.devConnector.exceptions.IdNotFoundException;
import com.dnb.devConnector.repo.CreateProfileRepo;
import com.dnb.devConnector.repo.EducationRepo;

@Service
public class EducationServiceImpl implements EducationService {

	@Autowired
	EducationRepo educationRepository;

	@Autowired
	CreateProfileRepo profileRepository;

	@Override
	public Education createEducation(Education education) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<CreateProfile> profile = profileRepository.findById(education.getCreateProfile().getProfileId());

		if (profile.isPresent()) {
			System.out.println("Hello");
			education.setCreateProfile(profile.get());
			return educationRepository.save(education);
		} else {
			profile.orElseThrow(() -> new IdNotFoundException("Profile id is not valid"));
		}
		return null;
	}

	@Override
	public Optional<Education> getEducationById(String educationId) {
		// TODO Auto-generated method stub
		return educationRepository.findById(educationId);
	}

	@Override
	public List<Education> getAllEducations() {
		// TODO Auto-generated method stub
		return (List<Education>) educationRepository.findAll();
	}

	@Override
	public boolean deleteEducationById(String educationId) {
		// TODO Auto-generated method stub
		if (educationRepository.existsById(educationId)) {
			educationRepository.deleteById(educationId);
			return true;
		} else
			return false;
	}

}
