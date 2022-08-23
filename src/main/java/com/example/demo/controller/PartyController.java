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

import com.example.demo.dto.Party;
import com.example.demo.service.PartyServiceImpl;

@RestController
@RequestMapping("/api")
public class PartyController {
	
	@Autowired
	PartyServiceImpl partyServiceImpl;
	
	
	@PostMapping("/parties")
	public Party saveParty(@RequestBody Party party) {
		
		return partyServiceImpl.saveParty(party);
	}
	
	@GetMapping("/parties/game/{party_id}")
	public List<Party> listGameName(@PathVariable(name="party_id") int party_id) {
	    return partyServiceImpl.listPartiesByGame(party_id);
	}
	
	@GetMapping("/parties/{id}")
	public Party partyByID(@PathVariable(name="id") int id) {
		
		Party party_byid= new Party();
		
		party_byid = partyServiceImpl.partyByID(id);
		
		System.out.println("Party by ID: " + party_byid);
		
		return party_byid;
	}
	
	@PutMapping("/parties/{id}")
	public Party updateParty(@PathVariable(name="id")int id, @RequestBody Party party) {
		
		Party selected_party= new Party();
		Party updated_party= new Party();
		
		selected_party = partyServiceImpl.partyByID(id);
		
		selected_party.setName(party.getName());
		selected_party.setGame(party.getGame());
		
		updated_party = partyServiceImpl.updateParty(selected_party);
		
		System.out.println("Updated party: "+ updated_party);
		
		return updated_party;
	}
	
	@DeleteMapping("/parties/{id}")
	public void deleteParty(@PathVariable(name="id")int id) {
		partyServiceImpl.deleteParty(id);
	}
}
