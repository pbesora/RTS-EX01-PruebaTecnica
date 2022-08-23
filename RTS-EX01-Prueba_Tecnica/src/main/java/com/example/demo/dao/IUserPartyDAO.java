/**
 * 
 */
package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.UserParty;

/**
 * @author pau_b
 *
 */
public interface IUserPartyDAO extends JpaRepository<UserParty, Integer>{
	
}
