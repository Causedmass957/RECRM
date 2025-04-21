package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer>{	
	
	public User findById(int userId);
	public User findByEmail(String email);	
	
}
