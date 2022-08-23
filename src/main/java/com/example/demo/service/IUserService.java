/**
 * 
 */
package com.example.demo.service;

import com.example.demo.dto.User;

/**
 * @author pau_b
 *
 */
public interface IUserService {
	
	public User saveUser(User user);
	
	public User userByID(int id);
	
	public User updateUser(User user);
	
	public void deleteUser(int id);
}
