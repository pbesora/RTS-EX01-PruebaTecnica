/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Party;

/**
 * @author pau_b
 *
 */
public interface IPartyService {

	public List<Party> listParties(); 
	
	public Party saveParty(Party party);
	
	public Party partyByID(int id);
	
	public Party updateParty(Party party);
	
	public void deleteParty(int id);
	
	public List<Party> listPartiesByGame(int game_id);
}
