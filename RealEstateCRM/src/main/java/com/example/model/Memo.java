package com.example.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import com.example.model.User;
@Entity
@Table(name="memos")

public class Memo {
	@Id
	@Column(name="memo_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memoId;	
		
	@Column(name="memo_title", nullable=false)
	private String memoTitle;
	
	@Column(name="memo_content", nullable=false)
	private String memoContent;
	
	@JsonBackReference(value="user-reference")
	@ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinColumn(name="user_fk")
	private User user;
	
	public Memo() {
		super();
	}
	
	public Memo(int memoId, String memoTitle, String memoContent) {
		super();
		this.memoId = memoId;
		this.memoTitle = memoTitle;
		this.memoContent = memoContent;
	}	
	
	public Memo(int memoId, String memoTitle, String memoContent, User user) {
		super();
		this.memoId = memoId;
		this.memoTitle = memoTitle;
		this.memoContent = memoContent;
		this.user = user;
	}

	public Memo(String memoTitle, String memoContent, User user) {
		super();
		this.memoTitle = memoTitle;
		this.memoContent = memoContent;
		this.user = user;
	}

	public int getMemoId() {
		return memoId;
	}

	public void setMemoId(int memoId) {
		this.memoId = memoId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMemoTitle() {
		return memoTitle;
	}
	
	public String getMemoContent() {
		return memoContent;
	}
	
	public void setMemoTitle(String memoTitle) {
		this.memoTitle = memoTitle;
	}
	
	public void setMemoContent(String memoContent) {
		this.memoContent = memoContent;
	}

}
