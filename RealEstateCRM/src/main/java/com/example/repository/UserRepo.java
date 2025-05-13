package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>{	
	
	public User findById(long id);
	public User findByEmail(String email);	
	public User findByUsername(String username);
}
