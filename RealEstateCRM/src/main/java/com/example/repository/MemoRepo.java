package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Memo;

public interface MemoRepo extends JpaRepository<Memo, Integer>{
	
	public Memo findById(int memoId);
	
}
