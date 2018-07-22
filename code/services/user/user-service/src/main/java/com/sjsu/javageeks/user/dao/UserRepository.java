package com.sjsu.javageeks.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjsu.javageeks.user.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserId(Long userId);
	List<User> findByEmail(String email);
	List<User> findByPhone(String phone);
	List<User> findByUserName(String username);	
	
}
