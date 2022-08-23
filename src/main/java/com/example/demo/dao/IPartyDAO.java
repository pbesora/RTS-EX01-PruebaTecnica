/**
 * 
 */
package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Party;

/**
 * @author pau_b
 *
 */
public interface IPartyDAO extends JpaRepository<Party, Integer>{
	public List<Party> findByGame(int game_id);
}
