package com.dnb.devConnector.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.devConnector.dto.Education;

@Repository
public interface EducationRepo extends CrudRepository<Education, String>{

}
