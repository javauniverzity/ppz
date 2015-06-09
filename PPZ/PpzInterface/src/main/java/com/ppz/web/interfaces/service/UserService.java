package com.ppz.web.interfaces.service;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ppz.web.entity.User;

/**
 * Functionality for User object.
 */

public interface UserService extends UserDetailsService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException;

	/**
	 * Load user by code.
	 *
	 * @return user
	 */
	public User loadUserByCode(String code);

	/**
	 * Create user.
	 */
	public void createUser(User user);

	/**
	 * Removes use
	 */
	public void removeUser(User user);

	/**
	 * Load user by id.
	 *
	 * @return user
	 */
	public User loadUserById(Long id);

	/**
	 * Update user.
	 *
	 * @return user
	 */
	public User updateUser(User user);

}
