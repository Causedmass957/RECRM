package com.example.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="contact")
public class Contact {
	
	@Id
	@Column(name="contact_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long contactId;
	
	@Column(name="name", nullable=false)
	private String contactName;
	
	@Column(name="email", unique=true,  nullable=false)
	private String email;
	
	@Column(name="dob")
	private LocalDate dob;
	
	@Column(name="phone")
	private String contactPhone;
	
	@JsonBackReference(value="user-reference")
	@ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinColumn(name="user_fk")
	private User user;
		
	public Contact(String contactName, String email, LocalDate dob, String contactPhone, User user) {
		super();
		this.contactName = contactName;
		this.email = email;
		this.dob = dob;
		this.contactPhone = contactPhone;
		this.user = user;
	}

	public Contact(long contactId, String contactName, String email, LocalDate dob, String contactPhone, User user) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.email = email;
		this.dob = dob;
		this.contactPhone = contactPhone;
		this.user = user;
	}

	public Contact(String contactName, String email, LocalDate dob, String contactPhone) {
		super();
		this.contactName = contactName;
		this.email = email;
		this.dob = dob;
		this.contactPhone = contactPhone;
	}

	public Contact(long contactId, String contactName, String email, LocalDate dob, String contactPhone) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.email = email;
		this.dob = dob;
		this.contactPhone = contactPhone;
	}

	public Contact() {
		super();
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return email;
	}

	public void setContactEmail(String email) {
		this.email = email;
	}

	public LocalDate getContactDOB() {
		return dob;
	}

	public void setContactDOB(LocalDate dob) {
		this.dob = dob;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", email=" + email
				+ ", dob=" + dob + ", contactPhone=" + contactPhone + "]";
	}
	
	
	

}
