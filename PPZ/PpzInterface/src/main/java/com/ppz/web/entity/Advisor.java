package com.ppz.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Entity for Financial Advisor data
 * 
 * @author Honza
 */

@Entity
@Table(name = "ADVISOR")
public class Advisor {

	/**
	 * Advisor ID
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	private Long advisorId;

	/**
	 * Advisor name
	 */
	private String name;

	/**
	 * Advisor surname
	 */
	private String surname;

	/**
	 * Advisor street address
	 */
	private String street;

	/**
	 * Advisor city address name
	 */
	private String city;

	/**
	 * Advisor post address
	 */
	private String post;

	/**
	 * Advisor street number
	 */
	private String streetNo;

	/**
	 * Advisor email address
	 */
	private String email;

	public Long getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(final Long advisorId) {
		this.advisorId = advisorId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getPost() {
		return post;
	}

	public void setPost(final String post) {
		this.post = post;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(final String streetNo) {
		this.streetNo = streetNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Advisor [advisorId=" + advisorId + ", name=" + name + ", surname=" + surname + ", street=" + street + ", city=" + city + ", post=" + post + ", streetNo=" + streetNo + ", email=" + email + "]";
	}

}