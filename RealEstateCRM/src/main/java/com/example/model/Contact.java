package com.example.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="contact")
public class Contact {
	
	@Id
	@Column(name="contact_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contactId;
	
	@Column(name="name", nullable=false)
	private String contactName;
	
	@Column(name="email", unique=true,  nullable=false)
	private String contactEmail;
	
	@Column(name="dob")
	private LocalDate dob;
	
	@Column(name="phone")
	private String contactPhone;

	public Contact(String contactName, String contactEmail, LocalDate dob, String contactPhone) {
		super();
		this.contactName = contactName;
		this.contactEmail = contactEmail;
		this.dob = dob;
		this.contactPhone = contactPhone;
	}

	public Contact(int contactId, String contactName, String contactEmail, LocalDate dob, String contactPhone) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactEmail = contactEmail;
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
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactEmail=" + contactEmail
				+ ", dob=" + dob + ", contactPhone=" + contactPhone + "]";
	}
	
	
	

}
