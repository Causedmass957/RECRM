package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;


@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/user")
public class UserController {
	
	private UserService uServe;
		
	public UserController() {
		super();
	}

	@Autowired
	public UserController(UserService uServe) {
		super();
		this.uServe = uServe;
	}
	
	@GetMapping("/init")
	public ResponseEntity<String> insertMockUserData() {
		System.out.println("endpoint reached");
		
		User mockUser = new User("DustyDaClown", "Passw0rd", "Realtor", "arnbristerdjr@gmail.com");
		
		uServe.registerUser(mockUser);
		
		return ResponseEntity.status(201).body("Success");
	}	
	

}
