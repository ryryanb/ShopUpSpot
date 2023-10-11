package com.ryryanb.shopupspot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ryryanb.shopupspot.model.User;
import com.ryryanb.shopupspot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public List<User> getAllUsers() {
List<User> users=	 userRepository.findAll();
	 System.out.println(users);

		return users;
	}

	@Transactional
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}
	@Transactional 
	public void addUser(User user){
		userRepository.save(user);
	}
	
	public User getUserById(Long userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		User user = userOptional.orElse(null); 
		return user;
	}

	
}
