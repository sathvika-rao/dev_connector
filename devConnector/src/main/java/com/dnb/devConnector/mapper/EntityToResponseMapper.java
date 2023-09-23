package com.dnb.devConnector.mapper;

import org.springframework.stereotype.Component;

import com.dnb.devConnector.dto.CreateProfile;
import com.dnb.devConnector.payload.response.CreateProfileResponse;
import com.dnb.devConnector.utils.Conversions;

@Component
public class EntityToResponseMapper {
	
	Conversions converter = new Conversions();
	
	public CreateProfileResponse getProfileResponse(CreateProfile profile) {
		CreateProfileResponse profileResponse = new CreateProfileResponse();

		profileResponse.setProfessionalStatus(profile.getProfessionalStatus());

		profileResponse.setCompanyName(profile.getCompanyName());

		profileResponse.setCompanyWebsite(profile.getCompanyWebsite());

		profileResponse.setCompanyLocation(profile.getCompanyLocation());

		profileResponse.setSkills(converter.stringToArrayList(profile.getSkills()));

		profileResponse.setGithubUsername(profile.getGithubUsername());

		profileResponse.setBio(profile.getBio());

		profileResponse.setLinks(profile.getLinks());
		
		profileResponse.setUserId(profile.getRegisterUser().getUserId());

		return profileResponse;
	}
	
}
