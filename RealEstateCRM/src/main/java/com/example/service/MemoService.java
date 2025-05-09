package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Memo;
import com.example.model.MemoGroup;
import com.example.model.User;
import com.example.repository.MemoGroupRepo;
import com.example.repository.MemoRepo;
import com.example.repository.UserRepo;

@Service
public class MemoService {
	
	private MemoRepo mRepo;
	private MemoGroupRepo mgRepo;

	public MemoService() {
		super();
	}

	@Autowired
	public MemoService(MemoRepo mRepo, MemoGroupRepo mgRepo) {
		super();
		this.mRepo = mRepo;
		this.mgRepo = mgRepo;
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
	
	public List<Memo> getMemosByUserUserName(User user) {
		return mRepo.findByUser(user);
	}
	
	public List<Memo> getMemosInGroup(int mgId) {
		MemoGroup memoGroup = mgRepo.findById(mgId);
		return mRepo.findByMemoGroup(memoGroup);
	}	
	
	public void removeMemo(Memo memo) {
		mRepo.delete(memo);
	}
	
	public void removeMemoFromGroup(Memo memo) {
		Memo newMemo = mRepo.findById(memo.getMemoId()).get();
		newMemo.setMemoGroup(null);
		mRepo.save(newMemo);
	}
	
	public void changeMemoGroup(Memo memo, MemoGroup memoGroup) {
		if (memo.getMemoId() == null) {
		    throw new IllegalArgumentException("Memo ID cannot be null");
		}
		Memo newMemo = mRepo.findById(memo.getMemoId()).get();
		newMemo.setMemoGroup(memoGroup);
		mRepo.save(newMemo);
	}
}
