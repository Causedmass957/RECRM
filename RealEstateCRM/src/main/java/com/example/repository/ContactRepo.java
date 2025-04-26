package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer>{
	
	public Contact findById(int contactId);
	public Contact findByEmail(String email);

}
