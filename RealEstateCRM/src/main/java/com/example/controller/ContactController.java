package com.example.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Contact;
import com.example.model.User;
import com.example.service.ContactService;
import com.example.service.UserService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/contact")
public class ContactController {
	
	ContactService cServe;
	UserService uServe;
	
	@Autowired
	public ContactController(ContactService cServe, UserService uServe) {
		super();
		this.cServe = cServe;
		this.uServe = uServe;
	}
	
	@GetMapping(value="/init")
	public ResponseEntity<String> initialMockContacts() {
		
		User mockUser = uServe.getUserByEmail("arnbristerdjr@gmail.com");
		
		
		Contact mockContact1 = new Contact("Christina O'Neal", "realtoroneal@gmail.com", LocalDate.of(1968, 11, 9), "209-321-6122", mockUser);
		
		cServe.saveContact(mockContact1);
		
		return ResponseEntity.status(201).body("Success");
		
	}
	
	
	

}
