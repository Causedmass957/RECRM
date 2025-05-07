package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Memo;
import com.example.model.MemoGroup;
import com.example.model.User;

public interface MemoRepo extends JpaRepository<Memo, Integer>{
	
	public Memo findById(int memoId);
	public List<Memo> findByUser(User user);
	List<Memo> findByMemoGroup(MemoGroup group);
	
}
