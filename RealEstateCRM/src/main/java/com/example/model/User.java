package com.example.model;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="role", nullable=false)
	private String role = "USER";
	
	@Column(name="email", unique=true, nullable=false)
	private String email;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy= "user")
	@Column(nullable=true)
	private List<Contact> contactList;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy= "user")
	@Column(nullable=true)
	private List<Memo> memoList;
	
	public User() {
		
	}
		
	public User(long id, String username, String password, String role, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
	}

	public User(long id, String username, String password, String role, String email, List<Contact> contactList) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
		this.contactList = contactList;
	}



	public User(String username, String password, String role, String email, List<Contact> contactList) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
		this.contactList = contactList;
	}



	public User(String username, String password, String role, String email) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
	}

	public long getUserId() {
		return id;
	}

	public void setUserId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "user info here";
	}
	
	
}
