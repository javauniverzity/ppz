package com.ppz.web.service;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ppz.web.entity.User;

public interface UserService extends UserDetailsService {

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException;

	public User loadUserByCode(String code);

	public void createUser(User user);

	public void removeUser(User user);

	public User loadUserById(Long id);

	public User updateUser(User user);

}
