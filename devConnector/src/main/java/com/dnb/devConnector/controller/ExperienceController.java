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

import com.dnb.devConnector.dto.Experience;
import com.dnb.devConnector.exceptions.DataNotFoundException;
import com.dnb.devConnector.exceptions.IdNotFoundException;
import com.dnb.devConnector.mapper.RequestToEntityMapper;
import com.dnb.devConnector.payload.request.ExperienceRequest;
import com.dnb.devConnector.service.ExperienceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
	@Autowired
	ExperienceService experienceService;
	
	@Autowired
	RequestToEntityMapper mapper;
	
	@PostMapping("/create")
	public ResponseEntity<?> createExperience(@Valid @RequestBody ExperienceRequest experienceRequest){
		Experience experience = mapper.getExperienceEntityObject(experienceRequest);
		try {
			Experience experience2 = experienceService.createExperience(experience);
			return new ResponseEntity(experience2,HttpStatus.CREATED);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/expid/{exerienceId}")
	public ResponseEntity<?> getExperienceById(@PathVariable("experienceId")String experienceId) throws IdNotFoundException{
		Optional<Experience> optional = experienceService.getExperienceById(experienceId);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new IdNotFoundException("Experience id is not valid");
		}
	}
	
	@GetMapping("/exp/getExperiences")
	public ResponseEntity<?>getAllExperiences() throws DataNotFoundException{
		List<Experience> experiences = (List<Experience>) experienceService.getExperiences();
		if(experiences.isEmpty()) {
			throw new DataNotFoundException("Data not found");
		}
		else {
			return ResponseEntity.ok(experiences);
		}
	}
	
	@DeleteMapping("/delete/{experienceId}")
	public ResponseEntity<?> deleteExperienceById(@PathVariable("experienceId")String experienceId) throws IdNotFoundException{
		if(experienceService.deleteExperienceById(experienceId)) {
			return ResponseEntity.noContent().build();
		}
		else {
			throw new IdNotFoundException("Experience id is not valid");
		}
	}
}
