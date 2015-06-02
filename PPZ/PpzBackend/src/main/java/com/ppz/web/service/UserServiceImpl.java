package com.ppz.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppz.web.entity.User;
import com.ppz.web.interfaces.service.UserService;
import com.ppz.web.repository.UserRepository;

/**
 * Implementace sluzby uzivatel
 * @author David
 */
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Nacti uzivatele podle uzivatelskeho jmena
	 */
	@Override
	@Transactional(readOnly = true)
	public User loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		return userRepository.loadUserByUsername(username);
	}

	/**
	 * Nacti uzivatele dle kodu hry
	 */
	@Override
	@Transactional(readOnly = true)
	public User loadUserByCode(String code) {
		return userRepository.loadUserByCode(code);
	}
	
	/**
	 * Vytvor uzivatele
	 */
	@Override
	public void createUser(User user) {
		userRepository.createUser(user);
	}

	/**
	 * Odstran uzivatele
	 */
	@Override
	public void removeUser(User user) {
		userRepository.removeUser(user);
	}

	/**
	 * Nacti uzivatele dle Id
	 */
	@Override
	@Transactional(readOnly = true)
	public User loadUserById(Long id) {
		return userRepository.loadUserById(id);
	}

	/**
	 * Aktualizuj uzivatele
	 */
	@Override
	public User updateUser(User user) {
		return userRepository.updateUser(user);
	}

}
