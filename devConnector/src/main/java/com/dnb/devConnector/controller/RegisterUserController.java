package com.dnb.devConnector.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.devConnector.dto.RegisterUser;
import com.dnb.devConnector.exceptions.IdNotFoundException;
import com.dnb.devConnector.mapper.RequestToEntityMapper;
import com.dnb.devConnector.payload.request.RegisterUserRequest;
import com.dnb.devConnector.service.RegisterUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/registerUser")
public class RegisterUserController {

	@Autowired
	RegisterUserService userService;

	@Autowired
	RequestToEntityMapper requestToEntityMapper;

	@PostMapping("/create")
	public ResponseEntity<?> createUser(@Valid @RequestBody RegisterUserRequest userRequest) {
		RegisterUser user = requestToEntityMapper.getRegisterUser(userRequest);
		RegisterUser user2 = userService.createUser(user);
		return new ResponseEntity(user2, HttpStatus.CREATED);
	}

	@GetMapping("/usr/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable("userId") String userId) throws IdNotFoundException {
		Optional<RegisterUser> optional = userService.getUserById(userId);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		} else {
			throw new IdNotFoundException("User id is not valid");
		}
	}

	@GetMapping("/allUsers")
	public ResponseEntity<?> getAllUsers() {
		List<RegisterUser> users = (List<RegisterUser>) userService.getUsers();
		return ResponseEntity.ok(users);
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> deleteUserById(@PathVariable("userId") String userId) throws IdNotFoundException
	{
		if (userService.deleteUserById(userId)) {
			return ResponseEntity.noContent().build();
		} else {
			throw new IdNotFoundException("User id is not valid");
		}
	}
}
