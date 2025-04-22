package com.example.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.model.Contact;
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
	
	public void saveContact(Contact contact) {
		cRepo.save(contact);
	}
	
	public LocalDate getDob(Contact contact) {
		return contact.getDob();
	}
	
	public String getContactName(Contact contact) {
		return contact.getContactName();
	}
	
	public String getContactPhone(Contact contact) {
		return contact.getContactPhone();
	}
	
	public String getContactEmail(Contact contact) {
		return contact.getContactEmail();
	}
	
	public Contact getContactById(int contactId) {
		return cRepo.findById(contactId);
	}
	
	public Contact getContactByEmail(String contactEmail) {
		return cRepo.findByEmail(contactEmail);
	}

}
