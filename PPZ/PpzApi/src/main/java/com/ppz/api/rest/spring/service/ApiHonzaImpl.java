package com.ppz.api.rest.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppz.api.rest.entity.GetUserResponseHonza;
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
	public GetUserResponseHonza getUser(final String username) {
		final User user = userService.loadUserByUsername(username);
		final GetUserResponseHonza r = new GetUserResponseHonza();
		r.setUser(user);
		return r;
	}

}
