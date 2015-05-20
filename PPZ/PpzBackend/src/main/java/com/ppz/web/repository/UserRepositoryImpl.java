package com.ppz.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.ppz.web.entity.GameCode;
import com.ppz.web.entity.User;

@Repository(value = "userRepository")
public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

	@Autowired
	private GameCodeRepository gameCodeRepository;

	/**
	 * vytvoreni uzivatele
	 */
	public void createUser(User user) {
		create(user);
	}

	/**
	 * odstraneni uzivatele podle uzivatelskeho jmena
	 */
	public void removeUser(User user) {
		delete(user);
	}

	/**
	 * vrati uzivatele podle id, jedinecneho identifikatoru
	 */
	public User loadUserById(Long id) {
		return loadById(User.class, id);
	}

	/**
	 * ulozeni zmen uzivatele
	 */
	public User updateUser(User user) {
		update(user);
		return user;
	}

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		if (username == null || "".equals(username)) {
			return null;
		}
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("username", username);
		List<User> results = loadByFilter(filter, User.class);
		if (results.size() != 0) {
			return (User) results.get(0);
		} else {
			return null;
		}
	}

	@Override
	public User loadUserByCode(String code) throws UsernameNotFoundException, DataAccessException {
		if (code == null || "".equals(code)) {
			return null;
		}

		// get gameCode with wanted code
		GameCode gameCode = gameCodeRepository.getGameCode(code);

		if (gameCode != null && gameCode.getUser() != null) {
			return gameCode.getUser();
		}

		return null;
	}

}
