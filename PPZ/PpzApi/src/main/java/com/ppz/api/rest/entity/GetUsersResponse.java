package com.ppz.api.rest.entity;

import java.util.List;

/**
 * Komponenta, ktera nastavuje chovani entity uzivatel
 * @author David
 *
 */
public class GetUsersResponse {

	private List<String> users;

	/**
	 * Dej uzivatele
	 * @return
	 */
	public List<String> getUsers() {
		return users;
	}

	/**
	 * Nastav uzivatele
	 * @param users
	 */
	public void setUsers(List<String> users) {
		this.users = users;
	}
	
	
	
}
