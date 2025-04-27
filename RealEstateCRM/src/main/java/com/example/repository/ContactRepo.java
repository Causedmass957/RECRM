package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Contact;
import com.example.model.User;

public interface ContactRepo extends JpaRepository<Contact, Integer>{
	
	public Contact findById(int contactId);
	public Contact findByEmail(String email);
	public List<Contact> findByUser(User user);

}
