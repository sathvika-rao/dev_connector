package com.dnb.devConnector.service;

import java.util.List;
import java.util.Optional;

import com.dnb.devConnector.dto.CreateProfile;
import com.dnb.devConnector.dto.Experience;
import com.dnb.devConnector.exceptions.IdNotFoundException;

public interface ExperienceService {
	
	public Experience createExperience(Experience experience) throws IdNotFoundException;

	public Optional<Experience> getExperienceById(String experienceId);

	public boolean deleteExperienceById(String experienceId);

	public List<Experience> getExperiences();
	
}
