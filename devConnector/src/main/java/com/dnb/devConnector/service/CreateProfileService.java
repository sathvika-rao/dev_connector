package com.dnb.devConnector.service;

import java.util.List;
import java.util.Optional;

import com.dnb.devConnector.dto.CreateProfile;
import com.dnb.devConnector.exceptions.IdNotFoundException;


public interface CreateProfileService {

	public CreateProfile createProfile(CreateProfile createProfile) throws IdNotFoundException;

	public Optional<CreateProfile> getProfileById(String id);

	public boolean deleteProfileById(String id);

	public List<CreateProfile> getProfiles();

}
