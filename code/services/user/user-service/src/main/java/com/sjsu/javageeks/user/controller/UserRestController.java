package com.sjsu.javageeks.user.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sjsu.javageeks.user.model.User;
import com.sjsu.javageeks.user.service.UserService;
import com.sjsu.javageeks.user.util.CustomErrorType;
import com.sjsu.javageeks.user.util.CustomMessageType;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = {"*"})
public class UserRestController {
	@Autowired
	private UserService userservice;

	public static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

	// -------------------Retrieve All Users ---------------------------------------

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> listAllUsers() {
		List<User> users = (List<User>) userservice.getUsers();
		if (users.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// -------------------Retrieve User based on
	// Id------------------------------------------

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> listUserById(@PathVariable("userId") Long id) {

		Optional<User> user = userservice.getUser(id);
		if (user == null) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("User with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
	}

	// -------------------Authenticate based on username && password
	// ------------------------------------------


	 @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	 public ResponseEntity<?> authenticate(@RequestBody User inbounduser) { 
		 
		Optional<User> user = userservice.authenticate(inbounduser.getUserName(),  inbounduser.getPassword());
		if(user.isPresent()) {
			 return new ResponseEntity<CustomMessageType>(new CustomMessageType("Success"), HttpStatus.OK); 
		}
	 
		return new ResponseEntity<CustomMessageType>(new CustomMessageType("Failure"), HttpStatus.OK);
	}
	 

	// -------------------Create a User -------------------------------------------

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user) {
		Optional<User> savedUser = userservice.saveUser(user);
		if (savedUser.isPresent()) {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
					.buildAndExpand(savedUser.get().getUserId()).toUri();
			return ResponseEntity.created(location).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	// ------------------- Update a User Profile
	// ------------------------------------------------

	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("userId") Long id, @RequestBody User user) {
		Optional<User> currentUser = userservice.updateUser(id, user);

		if (currentUser.isPresent()) {
			return new ResponseEntity<User>(currentUser.get(), HttpStatus.OK);
		}
		return new ResponseEntity<CustomErrorType>(
				new CustomErrorType("Unable to upate. User with id " + id + " not found."), HttpStatus.NOT_FOUND);

	}

	// ------------------- Delete User
	// ------------------------------------

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("userId") Long id) {

		Optional<User> deletedUser = userservice.deleteUser(id);

		if (deletedUser.isPresent()) {
			return ResponseEntity.noContent().build();
		}

		return new ResponseEntity<CustomErrorType>(
				new CustomErrorType("Unable to delete. User with id " + id + " not found."),
				HttpStatus.NOT_FOUND);
	}

	// ------------------- Delete All Users-----------------------------

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAllUsers() {
		userservice.deleteAllUsers();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}
