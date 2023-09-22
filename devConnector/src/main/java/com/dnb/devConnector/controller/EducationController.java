package com.dnb.devConnector.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.devConnector.dto.Education;
import com.dnb.devConnector.exceptions.DataNotFoundException;
import com.dnb.devConnector.exceptions.IdNotFoundException;
import com.dnb.devConnector.mapper.RequestToEntityMapper;
import com.dnb.devConnector.payload.request.EducationRequest;
import com.dnb.devConnector.service.EducationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/education")
public class EducationController {
	
	@Autowired
	EducationService educationService;
	
	@Autowired
	RequestToEntityMapper mapper;
	
	@PostMapping("/create")
	public ResponseEntity<?> createEducationProfile(@Valid @RequestBody EducationRequest educationRequest){
		Education education=mapper.getEducation(educationRequest);
		try {
			Education education2 = educationService.createEducation(education);
			return new ResponseEntity(education2,HttpStatus.CREATED);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/eduid/{educationId}")
	public ResponseEntity<?> getEducationProfileById(@PathVariable("educationId")String educationId) throws IdNotFoundException{
		Optional<Education>optional=educationService.getEducationById(educationId);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new IdNotFoundException("Education id is not valid");
		}
	}
	
	@GetMapping("/getEducations")
	public ResponseEntity<?> getAllEducations() throws DataNotFoundException{
		List<Education>educations=(List<Education>) educationService.getAllEducations();
		if(educations.isEmpty()) {
			throw new DataNotFoundException("Data not found");
		}
		else {
			return ResponseEntity.ok(educations);
		}
	}
	
	@DeleteMapping("/{educationId}")
	public ResponseEntity<?> deleteEducationById(@PathVariable("educationId")String educationId) throws IdNotFoundException {
		if(educationService.deleteEducationById(educationId)) {
			return ResponseEntity.noContent().build();
		}
		else {
			throw new IdNotFoundException("Education id is not valid");
		}
	}
	
}
