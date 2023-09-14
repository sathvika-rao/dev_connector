package com.dnb.devConnector.dto;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.devConnector.utils.CustomIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Education {

	public Education(String school, String degree, String fieldOfStudy, LocalDate fromDate, LocalDate toDate,
			boolean currentSchool, String programDescription) {
		super();
		this.school = school;
		this.degree = degree;
		this.fieldOfStudy = fieldOfStudy;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.currentSchool = currentSchool;
		this.programDescription = programDescription;
	}
	@Id
	@NotBlank(message = "experience id should not be blank")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "experience_seq") //if generator is specified, then it'll know to use its wrapper class
	@GenericGenerator(name = "experience_seq", strategy = "com.dnb.devConnector.utils.CustomIdGenerator",
			parameters = {@Parameter(name =CustomIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "exp_"),
			@Parameter(name=CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d"),
			@Parameter(name=CustomIdGenerator.FLAG_PARAMETER, value = "true")
	})
	private String eduid;
	
	@Column(nullable = false)
	private String school;
	private String degree;
	private String fieldOfStudy;
	private LocalDate fromDate;
	private LocalDate toDate;
	private boolean currentSchool;
	private String programDescription;
}
