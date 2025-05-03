package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Memo;
import com.example.repository.MemoRepo;

@Service
public class MemoService {
	
	private MemoRepo mRepo;
	private UserService uServe = new UserService();

	public MemoService() {
		super();
	}

	@Autowired
	public MemoService(MemoRepo mRepo) {
		super();
		this.mRepo = mRepo;
	}
	
	public Memo getMemoById(int memoId) {
		return mRepo.findById(memoId);
	}
	
	public String getMemoTitle(Memo tmpMemo) {
		return tmpMemo.getMemoTitle();
	}
	
	public String getMemoContent(Memo memo) {
		return memo.getMemoContent();
	}
	
	public void saveMemo(Memo memo) {
		mRepo.save(memo);
	}
	
	public List<Memo> getMemosByUserUserName(String username) {
		return mRepo.findByUser(uServe.getUserByUsername(username));
	}
}
