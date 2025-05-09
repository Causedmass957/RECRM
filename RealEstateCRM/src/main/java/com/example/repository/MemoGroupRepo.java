package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.MemoGroup;
import com.example.model.User;

public interface MemoGroupRepo extends JpaRepository<MemoGroup, Long> {
	MemoGroup findById(int id);
    List<MemoGroup> findByUser(User user);
}

