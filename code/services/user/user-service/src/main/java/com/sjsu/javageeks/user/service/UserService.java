package com.sjsu.javageeks.user.service;

import java.util.List;
import java.util.Optional;

import com.sjsu.javageeks.user.model.User;

public interface UserService {
	public List<User> getUsers();
	public Optional<User> getUser(Long userId);
	public Optional<User> updateUser(Long userId, User user);
	public Optional<User> saveUser(User user);
	public Optional<User> deleteUser(Long userId);
	public Optional<User> authenticate(String userName, String password);
	public void deleteAllUsers();
}
