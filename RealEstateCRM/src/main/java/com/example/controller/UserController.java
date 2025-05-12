package com.example.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;
import com.example.utils.JwtUtil;

@ComponentScan(basePackages = {
	    "com.technicalkeeda"
	})
@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/user")
public class UserController {
	
	private UserService uServe;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtil jwtUtil;
		
	public UserController() {
		super();
	}

	@Autowired
	public UserController(UserService uServe, PasswordEncoder pEncoder, JwtUtil jUtil) {
		super();
		this.uServe = uServe;
		this.passwordEncoder = pEncoder;
		this.jwtUtil = jUtil;
	}
	
	@GetMapping("/init")
	public ResponseEntity<String> insertMockUserData() {
		//System.out.println("endpoint reached");
		
		User mockUser = new User("DustyDaClown", "Passw0rd", "Realtor", "arnbristerdjr@gmail.com");
		
		uServe.registerUser(mockUser);
		
		return ResponseEntity.status(201).body("Success");
	}	
	
	@PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        uServe.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
	    String username = loginData.get("username");
	    String password = loginData.get("password");

	    try {
	        Authentication authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(username, password)
	        );

	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        String jwt = jwtUtil.generateToken(authentication);

	        Map<String, String> response = new HashMap<>();
	        response.put("token", jwt);

	        return ResponseEntity.ok(response);
	    } catch (AuthenticationException ex) {
	        return ResponseEntity.status(401).body("Invalid credentials");
	    }
	}



}
