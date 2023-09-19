package com.ryryanb.shopupspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryryanb.shopupspot.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	User getUserByEmailId(String emailId);
}
