package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class MemoGroup {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable=false)
	private String groupName;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

	@JsonManagedReference
    @OneToMany(mappedBy = "memoGroup", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<Memo> memos;

	public MemoGroup(String groupName, User user) {
		super();
		this.groupName = groupName;
		this.user = user;
	}

	public MemoGroup(String groupName, User user, List<Memo> memos) {
		super();
		this.groupName = groupName;
		this.user = user;
		this.memos = memos;
	}

	public MemoGroup(Long id, String groupName, User user, List<Memo> memos) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.user = user;
		this.memos = memos;
	}

	public MemoGroup(String groupName) {
		super();
		this.groupName = groupName;
	}

	public MemoGroup() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Memo> getMemos() {
		return memos;
	}

	public void setMemos(List<Memo> memos) {
		this.memos = memos;
	}   
	
	public String returnTitle() {
		return this.groupName;
	}
	
	@Override
	public String toString() {
		return this.groupName;
	}

}
