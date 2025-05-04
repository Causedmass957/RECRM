package com.example.model;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Contact.class)
class ContactTests {
	private int testContactId = 123;
	private String testContactName = "John Test";
	private String testContactEmail = "testEmail@test.com";
	private LocalDate testContactDOB = LocalDate.of(2020, 5, 4);
	private String testContactPhone = "727-555-1212";
	
	private User testUser = new User(12, "Joey User", "password1", "Seller", "JoeyU@test.com");
	private Contact testContact = new Contact(testContactId, testContactName, testContactEmail, testContactDOB, testContactPhone,testUser);
	private int testContactIdToUpdate = 321;
	private String testContactNameToUpdate = "Jim Test";
	private String testContactEmailToUpdate = "testEmail@yahoo.com";
	private LocalDate testContactDOBToUpdate = testContactDOB.withYear(2020);
	private String testContactPhoneToUpdate = "813-555-1212";
	
	
	
	
	@Test
	void testSetGetName() {	
		assertEquals(testContactName, testContact.getContactName());
		testContact.setContactName(testContactNameToUpdate);
		assertEquals(testContactNameToUpdate, testContact.getContactName());
	}
	
	@Test
	void testSetGetEmail() {
		assertEquals(testContactEmail, testContact.getContactEmail());
		testContact.setContactEmail(testContactEmailToUpdate);
		assertEquals(testContactEmailToUpdate, testContact.getContactEmail());
	}
	
	@Test
	void testSetGetDOB() {
		assertEquals(testContactDOB, testContact.getContactDOB());
		testContact.setContactDOB(testContactDOBToUpdate);
		assertEquals(testContactDOBToUpdate, testContact.getContactDOB());
	}
	
	@Test
	void testSetGetPhone() {
		assertEquals(testContactPhone, testContact.getContactPhone());
		testContact.setContactPhone(testContactPhoneToUpdate);
		assertEquals(testContactPhoneToUpdate, testContact.getContactPhone());
	}
	
	@Test
	void testSetGetContactId() {
		assertEquals(testContactId, testContact.getContactId());
		testContact.setContactId(testContactIdToUpdate);
		assertEquals(testContactIdToUpdate, testContact.getContactId());
	}
	
	@Test
	void testToStringContact() {
		String contactString = "Contact [contactId=123, contactName=John Test, email=testEmail@test.com, dob=" + testContactDOBToUpdate + ", contactPhone=727-555-1212]";
		assertEquals(contactString, testContact.toString());
	}

}
