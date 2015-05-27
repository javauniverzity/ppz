package com.ppz.api.rest.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppz.api.rest.spring.service.interfaces.Api;
import com.ppz.api.rest.spring.service.interfaces.GetUsersResponse;
import com.ppz.web.entity.User;
import com.ppz.web.service.UserService;

public class ApiImpl implements Api{

	@Autowired
	private UserService userService;

	@Override
	public GetUsersResponse getUsers() {
		User user = userService.loadUserByUsername("admin");
		GetUsersResponse r = new GetUsersResponse();
		r.setUsers(new ArrayList<String>());
		r.getUsers().add(user.getUsername());
		return r;
	}

}
