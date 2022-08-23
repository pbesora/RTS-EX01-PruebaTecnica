package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserParty;
import com.example.demo.service.UserPartyServiceImpl;

@RestController
@RequestMapping("/api")
public class UserPartyController {
	
	@Autowired
	UserPartyServiceImpl userPartyServiceImpl;
	
	@GetMapping("/usersParties")
	public List<UserParty> listUsersParties(){
		return userPartyServiceImpl.listUsersParties();
	}
	
	
	@PostMapping("/usersParties")
	public UserParty saveUserParty(@RequestBody UserParty userParty) {
		
		return userPartyServiceImpl.saveUserParty(userParty);
	}
	
	
	@GetMapping("/usersParties/{id}")
	public UserParty userPartyByID(@PathVariable(name="id") int id) {
		
		UserParty userParty_byid= new UserParty();
		
		userParty_byid = userPartyServiceImpl.userPartyByID(id);
		
		System.out.println("UserParty by ID: " + userParty_byid);
		
		return userParty_byid;
	}
	
	@PutMapping("/usersParties/{id}")
	public UserParty updateUserParty(@PathVariable(name="id")int id, @RequestBody UserParty userParty) {
		
		UserParty selected_userParty= new UserParty();
		UserParty updated_userParty= new UserParty();
		
		selected_userParty = userPartyServiceImpl.userPartyByID(id);
		
		selected_userParty.setAdmin(userParty.isAdmin());
		selected_userParty.setUser(userParty.getUser());
		selected_userParty.setParty(userParty.getParty());
		updated_userParty = userPartyServiceImpl.updateUserParty(selected_userParty);
		
		System.out.println("Updated userParty: "+ updated_userParty);
		
		return updated_userParty;
	}
	
	@DeleteMapping("/usersParties/{id}")
	public void deleteUserParty(@PathVariable(name="id")int id) {
		userPartyServiceImpl.deleteUserParty(id);
	}
}
