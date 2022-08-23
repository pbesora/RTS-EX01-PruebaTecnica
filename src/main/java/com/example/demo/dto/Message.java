package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="messages")
public class Message {

	//Attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "content")
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	private Date sent_time;
	
	@ManyToOne
    @JoinColumn(name="user_id")
    private User user;
	
	@ManyToOne
    @JoinColumn(name="party_id")
    private Party party;

	
	//Constructors
	
	public Message() {
	}


	/**
	 * @param id
	 * @param content
	 * @param sent_time
	 * @param user
	 * @param party
	 */
	public Message(int id, String content, Date sent_time, User user, Party party) {
		this.id = id;
		this.content = content;
		this.sent_time = sent_time;
		this.user = user;
		this.party = party;
	}

	
	//GETTERS and SETTERS

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}


	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}


	/**
	 * @return the sent_time
	 */
	public Date getSent_time() {
		return sent_time;
	}


	/**
	 * @param sent_time the sent_time to set
	 */
	public void setSent_time(Date sent_time) {
		this.sent_time = sent_time;
	}


	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}


	/**
	 * @return the party
	 */
	public Party getParty() {
		return party;
	}


	/**
	 * @param party the party to set
	 */
	public void setParty(Party party) {
		this.party = party;
	}


	
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", sent_time=" + sent_time + ", user=" + user + ", party="
				+ party + "]";
	}
	
}