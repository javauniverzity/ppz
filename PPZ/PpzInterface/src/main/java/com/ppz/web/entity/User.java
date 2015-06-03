package com.ppz.web.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Data used for user authentication and authorization.
 */

@Entity
@Table(name = "USER")
public class User implements Serializable, UserDetails {

	private static final long serialVersionUID = -2863717915101241380L;

	/**
	 * radny uzivatel
	 */
	public static final String ROLE_USER = "ROLE_USER";

	/**
	 * administrator
	 */
	public static final String ROLE_ADMIN = "ROLE_ADMIN";

	/**
	 * poradce
	 */
	public static final String ROLE_ADVISOR = "ROLE_ADVISOR";

	/**
	 * uzivatel cekajici na aktivaci uctu
	 */
	public static final String ROLE_WAITING = "ROLE_WAITING";

	/**
	 * jedinecny identifikator
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	private Long id;

	/**
	 * uzivatelske role
	 */
	private String roles;

	/**
	 * uzivatelske jmeno
	 */
	private String username;

	/**
	 * heslo uzivatele
	 */
	private String password;

	/**
	 * role uzivatele
	 */
	@Transient
	private Set<Authority> authorities;

	/**
	 * preferovana lokalizace
	 */
	private String locale;

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Collection<Authority> getAuthorities() {
		if (authorities == null) {
			return new HashSet<Authority>();
		}
		return authorities;
	}

	public void setAuthorities(final Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", roles=" + roles + ", username=" + username
				+ ", password=" + password + ", locale=" + locale + "]";
	}

}
