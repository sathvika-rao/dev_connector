package com.dnb.devConnector.service;

import java.util.List;
import java.util.Optional;

import com.dnb.devConnector.dto.Education;
import com.dnb.devConnector.exceptions.IdNotFoundException;

public interface EducationService {
	
	public Education createEducation(Education education) throws IdNotFoundException;
	
	public Optional<Education> getEducationById(String educationId); 
	
	public List<Education> getAllEducations();
	
	public boolean deleteEducationById(String educationId);
	
}
