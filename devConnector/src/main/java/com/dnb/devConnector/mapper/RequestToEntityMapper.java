package com.dnb.devConnector.mapper;

import org.springframework.stereotype.Component;

import com.dnb.devConnector.dto.CreateProfile;
import com.dnb.devConnector.dto.Education;
import com.dnb.devConnector.dto.Experience;
import com.dnb.devConnector.dto.RegisterUser;
import com.dnb.devConnector.dto.SocialNetworkLinks;
import com.dnb.devConnector.payload.request.CreateProfileRequest;
import com.dnb.devConnector.payload.request.EducationRequest;
import com.dnb.devConnector.payload.request.ExperienceRequest;
import com.dnb.devConnector.payload.request.RegisterUserRequest;

@Component
public class RequestToEntityMapper {
	
	SocialNetworkLinks links = new SocialNetworkLinks();
	
	public RegisterUser getRegisterUser(RegisterUserRequest registerUserRequest) {
		RegisterUser user= new RegisterUser();
		user.setName(registerUserRequest.getName());
		user.setEmailAddress(registerUserRequest.getEmailAddress());
		user.setPassword(registerUserRequest.getPassword());
		//user.setConfirmPassword(registerUserRequest.getConfirmPassword());
		return user;
	}
	

	public CreateProfile getProfile(CreateProfileRequest profileRequest) {
		CreateProfile profile=new CreateProfile();
		profile.setProfessionalStatus(profileRequest.getProfessionalStatus());
		profile.setCompanyName(profileRequest.getCompanyName());
		profile.setCompanyWebsite(profileRequest.getCompanyWebsite());
		profile.setCompanyLocation(profileRequest.getCompanyLocation());
		profile.setSkills(profileRequest.getSkills());
		profile.setGithubUsername(profileRequest.getGithubUsername());
		profile.setBio(profileRequest.getBio());
		profile.getLinks().setTwitterURL(profileRequest.getLinks().getTwitterURL());
		profile.getLinks().setFacebookURL(profileRequest.getLinks().getFacebookURL());
		profile.getLinks().setYoutubeURL(profileRequest.getLinks().getYoutubeURL());
		profile.getLinks().setLinkedinURL(profileRequest.getLinks().getLinkedinURL());  
		profile.getLinks().setInstagramURL(profileRequest.getLinks().getInstagramURL());;
		
		RegisterUser user=new RegisterUser();
		user.setUserId(profileRequest.getUserId());
		profile.setRegisterUser(user);
		
		return profile;
	}
	
	
	public Education getEducation(EducationRequest educationRequest) {
		Education education=new Education();
		education.setSchool(educationRequest.getSchool());
		education.setDegree(educationRequest.getDegree());
		education.setFieldOfStudy(educationRequest.getFieldOfStudy());
		education.setFromDate(educationRequest.getFromDate());
		education.setCurrentSchool(educationRequest.getCurrentSchool());;
		education.setToDate(educationRequest.getToDate());
		education.setProgramDescription(educationRequest.getProgramDescription());;
		
		CreateProfile profile=new CreateProfile();
		profile.setProfileId(profile.getProfileId());;
		education.setCreateProfile(profile);
		
		return education;
	}
	
	public Experience getExperienceEntityObject(ExperienceRequest experienceRequest) {
		Experience experience=new Experience();
		experience.setJobTitle(experienceRequest.getJobTitle());
		experience.setCompany(experienceRequest.getCompany());
		experience.setLocation(experienceRequest.getLocation());
		experience.setFromDate(experienceRequest.getFromDate());
		experience.setCurrentJob(experienceRequest.getCurrentJob());
		experience.setToDate(experienceRequest.getToDate());
		experience.setJobDescription(experienceRequest.getJobDescription());
		
		CreateProfile profile=new CreateProfile();
		profile.setProfileId(profile.getProfileId());;
		experience.setCreateProfile(profile);
		
		return experience;
	}
	
	
	
}
