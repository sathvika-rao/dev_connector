package com.dnb.devConnector.mapper;

import org.springframework.stereotype.Component;

import com.dnb.devConnector.dto.CreateProfile;
import com.dnb.devConnector.payload.response.CreateProfileResponse;

@Component
public class EntityToResponseMapper {
	
	public CreateProfileResponse getProfileResponse(CreateProfile createProfile) {
		CreateProfileResponse response = new CreateProfileResponse();
		
		return response;
	}
	
}
