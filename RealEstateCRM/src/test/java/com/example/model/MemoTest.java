package com.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@SpringBootTest(classes = Memo.class)
class MemoTests {

	private int testMemoId = 123;
	private String testMemoTitle = "John Test";
	private String testMemoContent = "testEmail@test.com";
	private Memo testMemo = new Memo(testMemoId, testMemoTitle, testMemoContent);
	private int testMemoIdToUpdate = 321;
	private String testMemoTitleToUpdate = "John 2";
	private String testMemoContentToUpdate = "Test Content";
	
	@Test
	void testSetGetId() {	
		assertEquals(testMemoId, testMemo.getMemoId());
		testMemo.setMemoId(testMemoIdToUpdate);
		assertEquals(testMemoIdToUpdate, testMemo.getMemoId());
	}
	
	@Test
	void testSetGetTitle() {
		assertEquals(testMemoTitle, testMemo.getMemoTitle());
		testMemo.setMemoTitle(testMemoTitleToUpdate);
		assertEquals(testMemoTitleToUpdate, testMemo.getMemoTitle());
	}
	
	@Test
	void testSetGetContent() {
		assertEquals(testMemoContent, testMemo.getMemoContent());
		testMemo.setMemoTitle(testMemoContentToUpdate);
		assertEquals(testMemoContentToUpdate, testMemo.getMemoContent());
	}

}