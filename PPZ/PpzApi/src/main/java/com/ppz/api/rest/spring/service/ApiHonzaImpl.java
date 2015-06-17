package com.ppz.api.rest.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppz.api.rest.entity.GetUsersResponse;
import com.ppz.api.rest.spring.service.interfaces.ApiHonza;
import com.ppz.web.entity.User;
import com.ppz.web.interfaces.service.UserService;

/**
 * Implementace rozhraní ApiHonza.
 * 
 * @author Honza
 */
public class ApiHonzaImpl implements ApiHonza {

	/** The user service. */
	@Autowired
	private UserService userService;

	@Override
	public GetUsersResponse getUsers(final String username) {
		final User user = userService.loadUserByUsername(username);
		final GetUsersResponse r = new GetUsersResponse();
		r.setUsers(new ArrayList<String>());
		r.getUsers().add(user.getUsername());
		return r;
	}

}
