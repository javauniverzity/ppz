package com.ppz.api.rest.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppz.api.rest.entity.GetUsersResponse;
import com.ppz.api.rest.spring.service.interfaces.Api;
import com.ppz.web.entity.User;
import com.ppz.web.interfaces.service.UserService;

/**
 * Implementace rozhrani Api
 * @author David
 *
 */
public class ApiImpl implements Api{

	@Autowired
	private UserService userService;

	/**
	 * Nastaveni komunikace na dotaz dej uzivatele
	 */
	@Override
	public GetUsersResponse getUsers() {
		User user = userService.loadUserByUsername("admin");
		GetUsersResponse r = new GetUsersResponse();
		r.setUsers(new ArrayList<String>());
		r.getUsers().add(user.getUsername());
		return r;
	}

}
