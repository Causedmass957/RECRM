package com.example.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Contact;
import com.example.model.User;
import com.example.repository.ContactRepo;

@Service
public class ContactService {
	
	private ContactRepo cRepo;

	public ContactService() {
		super();
	}

	@Autowired
	public ContactService(ContactRepo cRepo) {
		super();
		this.cRepo = cRepo;
	}
	
	public void saveContact(Contact contact) {
		cRepo.save(contact);
	}
	
	public void removeContact(Contact contact) {
		cRepo.delete(contact);
	}
	
	public LocalDate getContactDOB(Contact contact) {
		return contact.getContactDOB();
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
	
	public Contact getContactByEmail(String email) {
		return cRepo.findByEmail(email);
	}
	
	public List<Contact> getAllContacts(User user) {
		return cRepo.findByUser(user);
	}

}
