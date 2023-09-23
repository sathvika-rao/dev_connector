package com.dnb.devConnector.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.devConnector.utils.CustomIdGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
@Entity
public class CreateProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "createProfile_seq") //if generator is specified, then it'll know to use its wrapper class
	@GenericGenerator(name = "createProfile_seq", strategy = "com.dnb.devConnector.utils.CustomIdGenerator",
			parameters = {@Parameter(name =CustomIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "pro_"),
			@Parameter(name=CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d"),
			@Parameter(name=CustomIdGenerator.FLAG_PARAMETER, value = "false")
	})
	private String profileId;
	@Column(nullable = false)
	private String professionalStatus;
	private String companyName;
	private String companyWebsite;
	private String companyLocation;
	private String skills;
	private String githubUsername;
	private String bio;
	@Embedded
	private SocialNetworkLinks links = new SocialNetworkLinks();
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private RegisterUser registerUser;
	

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "createProfile")
	private List<Experience> expList = new ArrayList<Experience>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "createProfile")
	private List<Education> eduList = new ArrayList<Education>();
}
