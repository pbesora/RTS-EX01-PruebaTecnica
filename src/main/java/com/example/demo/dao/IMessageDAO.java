/**
 * 
 */
package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Message;

/**
 * @author pau_b
 *
 */
public interface IMessageDAO extends JpaRepository<Message, Integer>{
	
}
