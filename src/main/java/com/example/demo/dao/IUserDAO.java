/**
 * 
 */
package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.User;

/**
 * @author pau_b
 *
 */
public interface IUserDAO extends JpaRepository<User, Integer>{
	
}
