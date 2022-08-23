/**
 * 
 */
package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Party;

/**
 * @author pau_b
 *
 */
public interface IPartyDAO extends JpaRepository<Party, Integer>{
	
}
