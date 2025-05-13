package com.example.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Contact;
import com.example.model.User;
import com.example.repository.ContactRepo;
import com.example.repository.UserRepo;

@Service
public class ContactService {
	
	private ContactRepo cRepo;
	private UserRepo uRepo;

	public ContactService() {
		super();
	}

	@Autowired
	public ContactService(ContactRepo cRepo, UserRepo uRepo) {
		super();
		this.cRepo = cRepo;
		this.uRepo = uRepo;
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
	
	public Contact getContactById(long id) {
		return cRepo.findById(id);
	}
	
	public Contact getContactByEmail(String email) {
		return cRepo.findByEmail(email);
	}
	
	public List<Contact> getAllContacts(User user) {
		return cRepo.findByUser(user);
	}
	
	public List<Contact> getContactsByUsername(String username) {
	    User user = uRepo.findByUsername(username);
	    return cRepo.findByUser(user);
	}
	
	public List<Contact> getUpcomingBirthdays(String username) {
	    User user = uRepo.findByUsername(username);
	    List<Contact> allContacts = cRepo.findByUser(user);
	    LocalDate today = LocalDate.now();
	    LocalDate upperBound = today.plusDays(30);

	    return allContacts.stream()
	        .filter(contact -> {
	            LocalDate dob = contact.getContactDOB();
	            if (dob == null) return false;

	            // Convert dob to this year's birthday
	            LocalDate thisYearBirthday = dob.withYear(today.getYear());

	            // Handle wrap-around year if birthday has already passed and is near New Year
	            if (thisYearBirthday.isBefore(today)) {
	                thisYearBirthday = thisYearBirthday.plusYears(1);
	            }

	            return !thisYearBirthday.isAfter(upperBound);
	        })
	        .toList();
	}



}
