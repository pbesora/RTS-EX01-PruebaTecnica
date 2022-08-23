package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;
import com.example.demo.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		
		return userServiceImpl.saveUser(user);
	}
	
	
	@GetMapping("/users/{id}")
	public User userByID(@PathVariable(name="id") int id) {
		
		User user_byid= new User();
		
		user_byid = userServiceImpl.userByID(id);
		
		System.out.println("User by ID: " + user_byid);
		
		return user_byid;
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(name="id")int id, @RequestBody User user) {
		
		User selected_user= new User();
		User updated_user= new User();
		
		selected_user = userServiceImpl.userByID(id);
		
		selected_user.setName(user.getName());
		
		updated_user = userServiceImpl.updateUser(selected_user);
		
		System.out.println("Updated user: "+ updated_user);
		
		return updated_user;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable(name="id")int id) {
		userServiceImpl.deleteUser(id);
	}
}
