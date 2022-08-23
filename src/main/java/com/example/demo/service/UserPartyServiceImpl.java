package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUserPartyDAO;
import com.example.demo.dto.UserParty;

@Service
public class UserPartyServiceImpl implements IUserPartyService{

	@Autowired
	IUserPartyDAO iUserPartyDAO;

	@Override
	public List<UserParty> listUsersParties() {
		return iUserPartyDAO.findAll();
	}

	@Override
	public UserParty saveUserParty(UserParty userParty) {
		return iUserPartyDAO.save(userParty);
	}

	@Override
	public UserParty userPartyByID(int id) {
		return iUserPartyDAO.findById(id).get();
	}

	@Override
	public UserParty updateUserParty(UserParty userParty) {
		return iUserPartyDAO.save(userParty);
	}

	@Override
	public void deleteUserParty(int id) {
		iUserPartyDAO.deleteById(id);
	}
	
}
