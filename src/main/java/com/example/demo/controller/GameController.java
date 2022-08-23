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

import com.example.demo.dto.Game;
import com.example.demo.service.GameServiceImpl;

@RestController
@RequestMapping("/api")
public class GameController {
	
	@Autowired
	GameServiceImpl gameServiceImpl;
	
	@GetMapping("/games")
	public List<Game> listGames(){
		return gameServiceImpl.listGames();
	}
	
	
	@GetMapping("/games/name/{name}")
	public Game listGameName(@PathVariable(name="name") String name) {
	    return gameServiceImpl.gameByName(name);
	}
	
	
	@PostMapping("/games")
	public Game saveGame(@RequestBody Game game) {
		
		return gameServiceImpl.saveGame(game);
	}
	
	
	@GetMapping("/games/{id}")
	public Game gameByID(@PathVariable(name="id") int id) {
		
		Game game_byid= new Game();
		
		game_byid = gameServiceImpl.gameByID(id);
		
		System.out.println("Game by ID: " + game_byid);
		
		return game_byid;
	}
	
	@PutMapping("/games/{id}")
	public Game updateGame(@PathVariable(name="id")int id, @RequestBody Game game) {
		
		Game selected_game= new Game();
		Game updated_game= new Game();
		
		selected_game = gameServiceImpl.gameByID(id);
		
		selected_game.setName(game.getName());
		
		updated_game = gameServiceImpl.updateGame(selected_game);
		
		System.out.println("Updated game: "+ updated_game);
		
		return updated_game;
	}
	
	@DeleteMapping("/games/{id}")
	public void deleteGame(@PathVariable(name="id")int id) {
		gameServiceImpl.deleteGame(id);
	}
}
	