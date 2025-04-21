package com.example.model;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.example.model.User;
@Entity
@Table(name="memos")

public class Memo {
	@Id
	@Column(name="memo_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memoId;
	
	// TODO Should be User.userId
	@Column(name="memo_created_by", nullable=false)
	private int memoCreatedBy;
	
	// TODO Should be a Contact.contactId
	@Column(name="memo_created_for", nullable=false)
	private int memoCreatedFor;
	
	
	@Column(name="memo_title", nullable=false)
	private String memoTitle;
	
	@Column(name="memo_content", nullable=false)
	private String memoContent;
	
	public Memo(int memoCreatedBy, int memoCreatedFor, String memoTitle, String memoContent) {
		super();
		this.memoCreatedBy = memoCreatedBy;
		this.memoCreatedFor = memoCreatedFor;
		this.memoTitle = memoTitle;
		this.memoContent = memoContent;
	}
	public int getMemoCreatedBy() {
		return memoCreatedBy;
	}

	public int getMemoCreatedFor() {
		return memoCreatedFor;
	}


	public String getMemoTitle() {
		return memoTitle;
	}
	
	public String getMemoContent() {
		return memoContent;
	}

	public void setMemoCreatedBy(int memoCreatedBy) {
		this.memoCreatedBy = memoCreatedBy;
	}
	
	public void setMemoCreatedFor(int memoCreatedFor) {
		this.memoCreatedFor = memoCreatedFor;
	}
	
	public void setMemoTitle(String memoTitle) {
		this.memoTitle = memoTitle;
	}
	
	public void setMemoContent(String memoContent) {
		this.memoContent = memoContent;
	}

}
