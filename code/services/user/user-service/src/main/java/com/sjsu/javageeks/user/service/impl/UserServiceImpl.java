package com.sjsu.javageeks.user.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjsu.javageeks.user.dao.UserRepository;
import com.sjsu.javageeks.user.model.User;
import com.sjsu.javageeks.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public List<User> getUsers() {
		List <User> users = userRepo.findAll();
		if(users != null)
			return users;
		else
			return null;
	}

	@Override
	public Optional<User> getUser(Long userId) {
		return userRepo.findById(userId);		
	}

	@Override
	public Optional<User> saveUser(User user) {
		Optional<User> createdUser = Optional.ofNullable(userRepo.save(user));
		return createdUser;
	}

	@Override
	public Optional<User> updateUser(Long userId, User userInBound) {
		if(userRepo.existsById(userId)) {
			userInBound.setUserId(userId);	
			return Optional.ofNullable(userInBound);
		}
		return Optional.ofNullable(null);
		
	}

	@Override
	public Optional<User> deleteUser(Long userId) {
		Optional<User> userToDelete = userRepo.findById(userId);
		if(userToDelete.isPresent()) {
			userRepo.deleteById(userId);
		}
		return userToDelete;
		
	}

	@Override
	public  void deleteAllUsers() {
		userRepo.deleteAll();
		
	}

	@Override
	public Optional<User> authenticate(String userName, String password) {
		List<User> authenticatedUser = userRepo.findByUserName(userName);
		if(!authenticatedUser.isEmpty()) {
			if(password.equals(authenticatedUser.get(0).getPassword())) {
				return Optional.ofNullable(authenticatedUser.get(0));
			}
		}
		return Optional.ofNullable(null);
	}

}
