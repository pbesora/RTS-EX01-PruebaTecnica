/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Message;

/**
 * @author pau_b
 *
 */
public interface IMessageService {

	public List<Message> listMessages();
	
	public Message saveMessage(Message message);
	
	public Message messageByID(int id);
	
	public Message updateMessage(Message message);
	
	public void deleteMessage(int id);
	
	public List<Message> listMessagesByParty(int party_id);
}
