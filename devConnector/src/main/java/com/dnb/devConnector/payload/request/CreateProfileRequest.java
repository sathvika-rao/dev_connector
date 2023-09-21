package com.dnb.devConnector.payload.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateProfileRequest {
	@Column(nullable = false)
	@NotBlank(message = "Professional status should not be blank")
	private String professionalStatus;
	private String companyName;
	private String companyWebsite;
	private String companyLocation;
	@Column(nullable = false)
	@NotBlank(message = "Skills should not be blank")
	private String skills;
	private String githubUsername;
	private String bio;
	private String twitterURL;
	private String facebookURL;
	private String youtubeURL;
	private String linkedinURL;
	private String instagramURL;
	@NotBlank(message = "User Id should not be blank")
	private String userId;
}
