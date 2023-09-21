package com.dnb.devConnector.payload.request;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ExperienceRequest {
	@Column(nullable = false)
	@NotBlank(message = "jobTitle should not be blank")
	private String jobTitle;
	@Column(nullable = false)
	@NotBlank(message = "Company name should not be blank")
	private String company;
	private String location;
	private LocalDate fromDate;
	private LocalDate toDate;
	private Boolean currentJob;
	private String jobDescription;
	@NotBlank(message = "Profile id should not be blank")
	private String profileId;
}
