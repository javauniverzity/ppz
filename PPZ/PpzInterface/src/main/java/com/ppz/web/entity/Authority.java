package com.ppz.web.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * Entity for Authority data
 */

public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = 1174595566773972040L;

	/**
	 * Authority ID
	 */
	private Long id;

	/**
	 * Authority name
	 */
	private String name;

	/**
	 * Authority description
	 */
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	@Override
	public String getAuthority() {
		return getName();
	}

	@Override
	public String toString() {
		return "Authority [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}

}
