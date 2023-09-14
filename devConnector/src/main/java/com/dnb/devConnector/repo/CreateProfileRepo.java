package com.dnb.devConnector.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.devConnector.dto.CreateProfile;

@Repository
public interface CreateProfileRepo extends CrudRepository<CreateProfile, String>{
	
}
