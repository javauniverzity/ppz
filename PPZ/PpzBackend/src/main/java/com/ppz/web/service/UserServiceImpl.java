package com.ppz.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppz.web.entity.User;
import com.ppz.web.interfaces.service.UserService;
import com.ppz.web.repository.UserRepository;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public User loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		return userRepository.loadUserByUsername(username);
	}

	@Override
	@Transactional(readOnly = true)
	public User loadUserByCode(String code) {
		return userRepository.loadUserByCode(code);
	}
	
	@Override
	public void createUser(User user) {
		userRepository.createUser(user);
	}

	@Override
	public void removeUser(User user) {
		userRepository.removeUser(user);
	}

	@Override
	@Transactional(readOnly = true)
	public User loadUserById(Long id) {
		return userRepository.loadUserById(id);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.updateUser(user);
	}

}
