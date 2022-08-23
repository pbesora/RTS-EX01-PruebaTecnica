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

import com.example.demo.dto.Message;
import com.example.demo.service.MessageServiceImpl;

@RestController
@RequestMapping("/api")
public class MessageController {
	
	@Autowired
	MessageServiceImpl messageServiceImpl;
	
	@GetMapping("/messages")
	public List<Message> listMessages(){
		return messageServiceImpl.listMessages();
	}
	
	
	@GetMapping("/messages/party/{party_id}")
	public List<Message> listMessageParty(@PathVariable(name="party_id") int party_id) {
	    return messageServiceImpl.listMessagesByParty(party_id);
	}
	
	
	@PostMapping("/messages")
	public Message saveMessage(@RequestBody Message message) {
		
		return messageServiceImpl.saveMessage(message);
	}
	
	
	@GetMapping("/messages/{id}")
	public Message messageByID(@PathVariable(name="id") int id) {
		
		Message message_byid= new Message();
		
		message_byid = messageServiceImpl.messageByID(id);
		
		System.out.println("Message by ID: " + message_byid);
		
		return message_byid;
	}
	
	@PutMapping("/messages/{id}")
	public Message updateMessage(@PathVariable(name="id")int id, @RequestBody Message message) {
		
		Message selected_message= new Message();
		Message updated_message= new Message();
		
		selected_message = messageServiceImpl.messageByID(id);
		
		selected_message.setContent(message.getContent());
		selected_message.setUser(message.getUser());
		selected_message.setParty(message.getParty());
		updated_message = messageServiceImpl.updateMessage(selected_message);
		
		System.out.println("Updated message: "+ updated_message);
		
		return updated_message;
	}
	
	@DeleteMapping("/messages/{id}")
	public void deleteMessage(@PathVariable(name="id")int id) {
		messageServiceImpl.deleteMessage(id);
	}
}
