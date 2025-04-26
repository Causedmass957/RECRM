package com.example.controller;

import java.util.LinkedHashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@ComponentScan(basePackages = {
	    "com.technicalkeeda"
	})
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
		//System.out.println("endpoint reached");
		
		User mockUser = new User("DustyDaClown", "Passw0rd", "Realtor", "arnbristerdjr@gmail.com");
		
		uServe.registerUser(mockUser);
		
		return ResponseEntity.status(201).body("Success");
	}	
	
	@PostMapping()
	public ResponseEntity<User> registerUser(@RequestBody User user){
		Optional<User> userOpt = Optional.ofNullable(uServe.getUserByUsername(user.getUsername()));
		Optional<User> emailOpt = Optional.ofNullable(uServe.getUserByEmail(user.getEmail()));
		if(userOpt.isPresent() || userOpt.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		uServe.registerUser(user);
		return ResponseEntity.status(200).body(uServe.getUserByEmail(user.getEmail()));
	}
	
	@PostMapping(value="/login/{username}")
	public ResponseEntity<User> checkPassword(@PathVariable(name="username") String username, @RequestBody LinkedHashMap<String, String> userMap){
		User testUser = uServe.getUserByUsername(username);
		Optional<User> corUser = Optional.ofNullable(testUser);
		
		if(!corUser.isPresent() || !corUser.get().getPassword().equals(userMap.get("password"))) 
			return ResponseEntity.badRequest().build();
		System.out.println("Success");
		return ResponseEntity.status(200).body(corUser.get());
	}

}
