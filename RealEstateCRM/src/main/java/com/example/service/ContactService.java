package com.example.service;

import org.springframework.stereotype.Service;

import com.example.repository.ContactRepo;

@Service
public class ContactService {
	
	private ContactRepo cRepo;

	public ContactService() {
		super();
	}

	public ContactService(ContactRepo cRepo) {
		super();
		this.cRepo = cRepo;
	}
	
	

}
