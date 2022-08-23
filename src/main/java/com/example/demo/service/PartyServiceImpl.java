package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPartyDAO;
import com.example.demo.dto.Party;

@Service
public class PartyServiceImpl implements IPartyService{

	@Autowired
	IPartyDAO iPartyDAO;
	
	@Override
	public List<Party> listParties() {
		return iPartyDAO.findAll();
	}

	@Override
	public Party saveParty(Party party) {
		return iPartyDAO.save(party);
	}

	@Override
	public Party partyByID(int id) {
		return iPartyDAO.findById(id).get();
	}

	@Override
	public Party updateParty(Party party) {
		return iPartyDAO.save(party);
	}

	@Override
	public void deleteParty(int id) {
		iPartyDAO.deleteById(id);
		
	}

	@Override
	public List<Party> listPartiesByGame(int game_id) {
		return iPartyDAO.findByGame(game_id);
	}

}
