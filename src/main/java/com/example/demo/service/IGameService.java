/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Game;

/**
 * @author pau_b
 *
 */
public interface IGameService {
	public List<Game> listGames();
	
	public Game gameByID(int id);
	
	public void deleteGame(int id);

	public Game gameByName(String name);
}
