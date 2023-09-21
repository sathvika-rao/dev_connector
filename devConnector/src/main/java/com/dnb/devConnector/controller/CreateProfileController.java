package com.dnb.devConnector.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.devConnector.dto.CreateProfile;

@RestController
@RequestMapping("/api/createProfile")
public class CreateProfileController {

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody CreateProfile createProfile) {
		
		return createProfile;
	}
	
}
