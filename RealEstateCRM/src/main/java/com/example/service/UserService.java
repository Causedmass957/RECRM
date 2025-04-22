package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo uRepo;

	public UserService() {
		super();
	}

	@Autowired
	public UserService(UserRepo uRepo) {
		super();
		this.uRepo = uRepo;
	}
	
	public List<User> getAllUsers() {
		return uRepo.findAll();
	}

	public void registerUser(User user) {
		uRepo.save(user);
	}
	
	public User getUserByEmail(String email) {
		return uRepo.findByEmail(email);
	}
	
	public User getUserById(int userId) {
		return uRepo.findById(userId);
	}
	
	public User getUserByUsername(String username) {
		return uRepo.findByUsername(username);
	}

}
