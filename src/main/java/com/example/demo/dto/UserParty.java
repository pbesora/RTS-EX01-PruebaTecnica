package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="users_parties")
public class UserParty {

	//Attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "admin")
	private boolean admin;
	
	@ManyToOne
    @JoinColumn(name="user_id")
    private User user;
	
	@ManyToOne
    @JoinColumn(name="party_id")
    private Party party;

	
	
	//Constructors
	
	public UserParty() {
	}

	/**
	 * @param id
	 * @param admin
	 * @param user
	 * @param party
	 */
	public UserParty(int id, boolean admin, User user, Party party) {
		this.id = id;
		this.admin = admin;
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
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
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
		return "UserParty [id=" + id + ", admin=" + admin + ", user=" + user + ", party=" + party + "]";
	}

	
	
}