/**
 * 
 */
package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Game;

/**
 * @author pau_b
 *
 */
public interface IGameDAO extends JpaRepository<Game, Integer>{
	
}
