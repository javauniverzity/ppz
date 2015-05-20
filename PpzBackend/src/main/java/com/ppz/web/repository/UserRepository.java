package com.ppz.web.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ppz.web.entity.User;

/**
 * REPOSITORY object for accession the database.
 * 
 * @author Pavel Lukes
 * 
 */
public interface UserRepository {
	
	public void createUser(User user);
	
	public void removeUser(User user);
	
	public User loadUserById(Long id);
	
	public User updateUser(User user);
	
	public User loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException;

	public User loadUserByCode(String code);
	
}
