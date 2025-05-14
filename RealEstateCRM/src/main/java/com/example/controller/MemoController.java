package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Contact;
import com.example.model.Memo;
import com.example.model.MemoGroup;
import com.example.model.User;
import com.example.service.MemoGroupService;
import com.example.service.MemoService;
import com.example.service.UserService;


@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/memo")
@EnableWebSecurity
@EnableMethodSecurity
public class MemoController {
	
	UserService uServe;
	MemoService mServe;
	MemoGroupService mgServe;
	
	@Autowired
	public MemoController(UserService uServe, MemoService mServe, MemoGroupService mgServe) {
		super();
		this.uServe = uServe;
		this.mServe = mServe;
		this.mgServe = mgServe;
	}
	
	@GetMapping(value="/init")
	public ResponseEntity<String> initiateMockMemoData() {
		User testUser = uServe.getUserByUsername("DustyDaClown");
		Memo testMemo = new Memo("Test Title", "This memo has content. I have no idea what the maximum character count is, but we haven't reached it yet", testUser);
		mServe.saveMemo(testMemo);
		return ResponseEntity.status(201).body("Success");
	}
	
	//get single contact by unique id
	@GetMapping(value="/{id}")
	public ResponseEntity<Memo> getMemo(@PathVariable(name="id") int memoId) {
		return ResponseEntity.status(201).body(mServe.getMemoById(memoId));
	}
	
	//get all contacts joined by user
	@GetMapping(value="/all/")
	public ResponseEntity<List<Memo>> getAllMemos(Authentication authentication) {
		String username = authentication.getName();
		List<Memo> memoList = mServe.getMemosByUserUserName(uServe.getUserByUsername(username));
		return ResponseEntity.status(201).body(memoList);		
	}
	
	@GetMapping(value="/nogroup")
	public ResponseEntity<List<Memo>> getAllMemosNoGroup(Authentication authentication) {
		String username = authentication.getName();
		List<Memo> memoList = mServe.getMemosByUserUserName(uServe.getUserByUsername(username));
		List<Memo> newList = new ArrayList();
		for(Memo m : memoList) {
			if(m.getMemoGroup() == null)
				newList.add(m);
			System.out.println(m);
		}
		
		return ResponseEntity.status(201).body(newList);		
	}
	
	@GetMapping(value="/group/{id}")
	public ResponseEntity<List<Memo>> getMemosInGroup(@PathVariable(name="id") int id) {
		List<Memo> groupList = mServe.getMemosInGroup(id);
		return ResponseEntity.status(201).body(groupList);
		
	}
	
	//add new contact to specified user via username
		/*JSON format
	    "memoTitle": "Christina O'Neal",
	    "memoContent": "1968-11-09"
	    */
	@PostMapping(value="/new")
	public ResponseEntity<String> addNewMemo(@RequestBody Memo memo, Authentication authentication) {
		//System.out.println(memo);
		String username = authentication.getName();
		User memoOwner = uServe.getUserByUsername(username);
		Optional<Memo> memoOpt = Optional.ofNullable(memo);
		memoOpt.get().setUser(memoOwner);
		if(!memoOpt.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		mServe.saveMemo(memo);
		return ResponseEntity.status(202).body("Success");
	}
	
	@PutMapping(value = "/edit/memo/{id}")
	public ResponseEntity<String> editMemo(@PathVariable(name = "id") int memoId,
	                                       @RequestBody Memo memo,
	                                       Authentication authentication) {
	    // Fetch the existing memo
	    Memo existingMemo = mServe.getMemoById(memoId);
	    if (existingMemo == null) {
	        return ResponseEntity.badRequest().body("Memo not found");
	    }

	    // Fetch the user based on the username
	    String username = authentication.getName();
	    User user = uServe.getUserByUsername(username);
	    if (user == null) {
	        return ResponseEntity.badRequest().body("User not found");
	    }

	    // Update all fields
	    existingMemo.setMemoTitle(memo.getMemoTitle());
	    existingMemo.setMemoContent(memo.getMemoContent());
	    existingMemo.setUser(user); // Update the user

	    // Handle memo group change
	    if (memo.getMemoGroup().getId() == 0) {
	        existingMemo.setMemoGroup(null);
	    } else {
	        MemoGroup group = mgServe.getGroupById(memo.getMemoGroup().getId());
	        if (group == null) {
	            return ResponseEntity.badRequest().body("MemoGroup not found");
	        }
	        existingMemo.setMemoGroup(group);
	    }

	    // Save the updated memo
	    mServe.saveMemo(existingMemo);

	    return ResponseEntity.status(201).body("Success");
	}




	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteMemo(@PathVariable(name="id") int memoId) {
		Memo memoDel = mServe.getMemoById(memoId);
		//System.out.println(memoDel.toString());
		mServe.removeMemo(memoDel);
		System.out.println("memo deleted");
		return ResponseEntity.status(201).body("Success");
	}

}
