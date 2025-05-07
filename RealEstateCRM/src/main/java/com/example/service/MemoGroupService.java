package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Memo;
import com.example.model.MemoGroup;
import com.example.model.User;
import com.example.repository.MemoGroupRepo;
import com.example.repository.MemoRepo;

@Service
public class MemoGroupService {
	
	@Autowired
    private MemoGroupRepo memoGroupRepository;
	
	@Autowired
	private MemoRepo mRepo;

    public List<MemoGroup> getAllGroupsByUser(User user) {
        return memoGroupRepository.findByUser(user);
    }

    public MemoGroup getGroupById(Long id) {
        return memoGroupRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not found"));
    }

    public MemoGroup saveGroup(MemoGroup memoGroup) {
        return memoGroupRepository.save(memoGroup);
    }

    public void deleteGroup(Long id) {
        memoGroupRepository.deleteById(id);
    }     

    public MemoGroup addMemoToGroup(Long groupId, Memo memo) {
        MemoGroup group = memoGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Memo group not found"));
        
        Memo existingMemo = mRepo.findById(memo.getMemoId()).get();

        existingMemo.setMemoGroup(group);
        mRepo.save(existingMemo);

        // Optionally: save group (especially if you updated any group fields)
        return memoGroupRepository.save(group);
    }
}
