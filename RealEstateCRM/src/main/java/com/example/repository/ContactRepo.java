package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Contact;
import com.example.model.User;

public interface ContactRepo extends JpaRepository<Contact, Long>{
	
	public Contact findById(long id);
	public Contact findByEmail(String email);
	public List<Contact> findByUser(User user);

}
