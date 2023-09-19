package com.ryryanb.shopupspot.service;

import java.util.List;

import com.ryryanb.shopupspot.model.User;

public interface UserService {

	List<User> getAllUsers();
	
	void deleteUser(String userId);
	
	void addUser(User user);
	
	User getUserById(String userId);
}
