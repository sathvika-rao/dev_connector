package com.dnb.devConnector.payload.response;

import java.util.ArrayList;
import java.util.List;

import com.dnb.devConnector.dto.Education;
import com.dnb.devConnector.dto.Experience;
import com.dnb.devConnector.dto.RegisterUser;
import com.dnb.devConnector.dto.SocialNetworkLinks;

import lombok.Data;

@Data
public class CreateProfileResponse {
	private String profileId;
	private String professionalStatus;
	private String companyName;
	private String companyWebsite;
	private String companyLocation;
	private List<String> skills = new ArrayList<String>();
	private String githubUsername;
	private String bio;
	private SocialNetworkLinks links;
	private RegisterUser registerUser;
	private List<Experience> expList = new ArrayList<Experience>();
	private List<Education> eduList = new ArrayList<Education>();
}
