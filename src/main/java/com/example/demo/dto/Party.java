package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="parties")
public class Party {

	//Attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	
	@ManyToOne
    @JoinColumn(name="game_id")
    private Game game;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Message> message;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<UserParty> userParty;

	
	
	//Constructors
	
	public Party() {
	}

	/**
	 * @param id
	 * @param name
	 * @param game
	 */
	public Party(int id, String name, Game game) {
		this.id = id;
		this.name = name;
		this.game = game;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * @return the message
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Message")
	public List<Message> getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(List<Message> message) {
		this.message = message;
	}

	/**
	 * @return the userParty
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "UserParty")
	public List<UserParty> getUserParty() {
		return userParty;
	}

	/**
	 * @param userParty the userParty to set
	 */
	public void setUserParty(List<UserParty> userParty) {
		this.userParty = userParty;
	}

	
	
	
	@Override
	public String toString() {
		return "Party [id=" + id + ", name=" + name + ", game=" + game + "]";
	}
}