package com.ppz.web.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ppz.web.entity.User;

/**
 * Objekt repository pro prisutp do databaze
 * 
 * @author David
 * 
 */
public interface UserRepository {
	
	/**
	 * Vytvor uzivatele
	 * @param user
	 */
	public void createUser(User user);
	
	/**
	 * Odstran uzivatele
	 * @param user
	 */
	public void removeUser(User user);
	
	/**
	 * Nacti uzivatele podle Id
	 * @param id
	 */
	public User loadUserById(Long id);
	
	/**
	 * Aktualizuj uzivatele
	 * @param user
	 */
	public User updateUser(User user);
	
	/**
	 * Nacti uzivatele podle uzivatelskeho jmena
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 * @throws DataAccessException
	 */
	public User loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException;

	/**
	 * Nacti uzivatele podle kodu
	 * @param code
	 */
	public User loadUserByCode(String code);
	
}
