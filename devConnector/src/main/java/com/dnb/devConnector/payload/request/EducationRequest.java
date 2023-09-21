package com.dnb.devConnector.payload.request;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EducationRequest {
	@NotNull
	@NotBlank(message = "Enter school or bootcamp name")
	private String school;
	@NotNull
	@NotBlank(message = "Degree or certificate should not be blank")
	private String degree;
	private String fieldOfStudy;
	private LocalDate fromDate;
	private LocalDate toDate;
	private Boolean currentSchool;
	private String programDescription;
	@NotBlank(message = "Profile id cannot be blank")
	private String profileId;
}
