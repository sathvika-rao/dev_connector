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

import com.dnb.devConnector.dto.CreateProfile;
import com.dnb.devConnector.exceptions.IdNotFoundException;
import com.dnb.devConnector.mapper.RequestToEntityMapper;
import com.dnb.devConnector.payload.request.CreateProfileRequest;
import com.dnb.devConnector.service.CreateProfileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/createProfile")
public class CreateProfileController {

	@Autowired
	RequestToEntityMapper mapper;

	@Autowired
	CreateProfileService profileService;

	@PostMapping("/create")
	public ResponseEntity<?> createProfile(@Valid @RequestBody CreateProfileRequest profileRequest) {
		CreateProfile profile = mapper.getProfile(profileRequest);
		try {
			CreateProfile profile2 = profileService.createProfile(profile);
			return new ResponseEntity(profile2, HttpStatus.CREATED);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/pid/{profileId}")
	public ResponseEntity<?> getProfileById(@PathVariable("profileId") String profileId) throws IdNotFoundException {
		Optional<CreateProfile> optional = profileService.getProfileById(profileId);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		} else {
			throw new IdNotFoundException("Profile id is not valid");
		}
	}

	@GetMapping("/pro/allProfiles")
	public ResponseEntity<?> getAllProfiles() {
		List<CreateProfile> profiles = (List<CreateProfile>) profileService.getProfiles();

		return ResponseEntity.ok(profiles);
	}

	@DeleteMapping("/delete/{profileId}")
	public ResponseEntity<?> deleteProfileById(@PathVariable("profileId") String profileId) throws IdNotFoundException
	{
		if(profileService.deleteProfileById(profileId)) {
				return ResponseEntity.noContent().build();
		} 
		else {
			throw new IdNotFoundException("Profile id is not valid");
		}
}
}
