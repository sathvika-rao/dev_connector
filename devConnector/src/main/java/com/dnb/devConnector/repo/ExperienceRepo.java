package com.dnb.devConnector.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.devConnector.dto.Experience;

@Repository
public interface ExperienceRepo extends CrudRepository<Experience, String> {

}
