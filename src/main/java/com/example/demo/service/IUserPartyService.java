/**
 * 
 */
package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.UserParty;

/**
 * @author pau_b
 *
 */
public interface IUserPartyService {
	
	public List<UserParty> listUsersParties();
	
	public UserParty saveUserParty(UserParty userParty);
	
	public UserParty userPartyByID(int id);
	
	public UserParty updateUserParty(UserParty userParty);
	
	public void deleteUserParty(int id);
}
