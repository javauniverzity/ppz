package com.ppz.api.rest.entity;

import com.ppz.web.entity.User;

/**
 * Komponenta, ktera nastavuje chovani entity uzivatel.
 *
 * @author Honza
 */
public class GetUserResponseHonza {

	private User user;

	/**
	 * Dej usera.
	 *
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Nastav usera.
	 */
	public void setUser(final User user) {
		this.user = user;
	}

}
