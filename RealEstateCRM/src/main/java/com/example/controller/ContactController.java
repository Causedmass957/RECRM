package com.example.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//initial mock data. edit the logic to make your own mock data
	@GetMapping(value="/init")
	public ResponseEntity<String> initialMockContacts() {
		
		User mockUser = uServe.getUserByEmail("arnbristerdjr@gmail.com");
		
		
		Contact mockContact1 = new Contact("Christina O'Neal", "realtoroneal@gmail.com", LocalDate.of(1968, 11, 9), "209-321-6122", mockUser);
		
		cServe.saveContact(mockContact1);
		
		return ResponseEntity.status(201).body("Success");		
	}
	
	//get single contact by unique id
	@GetMapping(value="/{id}")
	public ResponseEntity<Contact> getContact(@PathVariable(name="id") int contactId) {
		return ResponseEntity.status(201).body(cServe.getContactById(contactId));
	}
	
	//get all contacts joined by user
	@GetMapping(value="/all/{username}")
	public ResponseEntity<List<Contact>> getAllContacts(@PathVariable(name="username") String username) {
		List<Contact> contactList = cServe.getAllContacts(uServe.getUserByUsername(username));
		return ResponseEntity.status(201).body(contactList);
		
	}
	
	//add new contact to specified user via username
	/*JSON format
    "contactName": "Christina O'Neal",
    "dob": "1968-11-09",
    "contactPhone": "209-321-6122",
    "contactEmail": "realtoroneal@gmail.com"
    */
	@PostMapping(value="/{username}")
	public ResponseEntity<String> addNewContact(@RequestBody Contact contact, @PathVariable(name="username") String username) {
		System.out.println(contact);
		User contactOwner = uServe.getUserByUsername(username);
		Optional<Contact> contactOpt = Optional.ofNullable(contact);
		contactOpt.get().setUser(contactOwner);
		if(!contactOpt.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		cServe.saveContact(contact);
		return ResponseEntity.status(202).body("Success");
	}
	
	//endpoint to edit a specific contact
	/*JSON format
	 "contactId": 1,						{note: contact id is ONLY used when editing a specific contact)
    "contactName": "Christina O'Neal",
    "dob": "1968-11-09",
    "contactPhone": "209-321-6122",
    "contactEmail": "realtoroneal@gmail.com",
    "userName": //user associated with contact
    */
	@PutMapping(value="/edit/contact/{username}/{id}")
	public ResponseEntity<String> editContact(@PathVariable(name="id") int id, @RequestBody Contact contact, @PathVariable(name="username") String username) {
		Optional<Contact> contactOpt = Optional.ofNullable(cServe.getContactById(id));
		System.out.println(contactOpt.get());
		if(contactOpt.isPresent()) {
			Contact tempContact = new Contact(id, contact.getContactName(), contact.getContactEmail(), contact.getDob(), contact.getContactPhone(), uServe.getUserByUsername(username));
			cServe.saveContact(tempContact);
			return ResponseEntity.status(201).body("Success");
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable(name="id") int contactId) {
		Contact contactDel = cServe.getContactById(contactId);
		System.out.println(contactDel.toString());
		cServe.removeContact(contactDel);
		System.out.println("contact deleted");
		return ResponseEntity.status(201).body("Success");
	}

}
