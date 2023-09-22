package com.dnb.devConnector.dto;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.devConnector.utils.CustomIdGenerator;
import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Experience {
	
	public Experience(String jobTitle, String company, String location, LocalDate fromDate, LocalDate toDate,
			boolean currentJob, String jobDescription) {
		super();
		this.jobTitle = jobTitle;
		this.company = company;
		this.location = location;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.currentJob = currentJob;
		this.jobDescription = jobDescription;
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
	private String experienceId;
	
	@Column(nullable = false)
	private String jobTitle;
	private String company;
	private String location;
	private LocalDate fromDate;
	private LocalDate toDate;
	private Boolean currentJob;
	private String jobDescription;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profileId")
	private CreateProfile createProfile;
}
