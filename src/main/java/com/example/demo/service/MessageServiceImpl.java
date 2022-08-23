package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMessageDAO;
import com.example.demo.dto.Message;

@Service
public class MessageServiceImpl implements IMessageService{

	@Autowired
	IMessageDAO iMessageDAO;
	
	@Override
	public List<Message> listMessages() {
		return iMessageDAO.findAll();
	}

	@Override
	public Message saveMessage(Message message) {
		return iMessageDAO.save(message);
	}

	@Override
	public Message messageByID(int id) {
		return iMessageDAO.findById(id).get();
	}

	@Override
	public Message updateMessage(Message message) {
		return iMessageDAO.save(message);
	}

	@Override
	public void deleteMessage(int id) {
		iMessageDAO.deleteById(id);
	}

	@Override
	public List<Message> listMessagesByParty(int party_id) {
		return iMessageDAO.findByParty(party_id);
	}

}
