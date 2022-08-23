package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IGameDAO;
import com.example.demo.dto.Game;

@Service
public class GameServiceImpl implements IGameService{

	@Autowired
	IGameDAO iGameDAO;
	
	@Override
	public List<Game> listGames() {
		return iGameDAO.findAll();
	}

	@Override
	public Game gameByID(int id) {
		return iGameDAO.findById(id).get();
	}

	@Override
	public void deleteGame(int id) {
		iGameDAO.deleteById(id);
	}

	@Override
	public Game gameByName(String name) {
		return iGameDAO.findByName(name);
	}

}
