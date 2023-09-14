package com.dnb.devConnector.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.devConnector.dto.RegisterUser;

@Repository
public interface RegisterUserRepo extends CrudRepository<RegisterUser, String>{

}
