package com.ppz.web.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ppz.web.utils.Exclude;

/**
 * Entity for Linked person data
 */

@Entity
@Table(name = "LINKED_PERSON")
public class LinkedPerson {

	public static final Integer PERSON_TYPE_WIFE = 1;
	public static final Integer PERSON_TYPE_HUSBAND = 2;
	public static final Integer PERSON_TYPE_CHILD = 3;
	public static final Integer PERSON_TYPE_DOG = 4;

	/**
	 * Linked person ID
	 */	
	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	private Long linkedPersonId;

	/**
	 * Age of linked persons in month
	 */
	private Long age;

	/**
	 * Type of linked person, possible values: PERSON_TYPE_WIFE,
	 * PERSON_TYPE_HUSBAND, PERSON_TYPE_CHILD, PERSON_TYPE_DOG
	 */
	private Integer type;

	/**
	 * Expenses for linked person
	 */
	private BigDecimal expenses;

	/**
	 * Name of linked person
	 */
	private String name;

	/**
	 * This entity exist in this round number (historical reason)
	 */
	private Long roundNo;

	/**
	 * Owner of linked person
	 */
	@ManyToOne(optional = false)
	@Exclude
	private Avatar avatar;

	public Long getLinkedPersonId() {
		return linkedPersonId;
	}

	public void setLinkedPersonId(Long linkedPersonId) {
		this.linkedPersonId = linkedPersonId;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigDecimal getExpenses() {
		return expenses;
	}

	public void setExpenses(BigDecimal expenses) {
		this.expenses = expenses;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public Long getRoundNo() {
		return roundNo;
	}

	public void setRoundNo(Long roundNo) {
		this.roundNo = roundNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LinkedPerson [linkedPersonId=" + linkedPersonId + ", age="
				+ age + ", type=" + type + ", expenses=" + expenses
				+ ", roundNo=" + roundNo + ", avatar=" + avatar + "]";
	}
}
