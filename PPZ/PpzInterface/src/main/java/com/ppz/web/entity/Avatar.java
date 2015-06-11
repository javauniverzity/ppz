package com.ppz.web.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * Entity for user Avatar data
 * 
 * @author Honza
 */

@Entity
@Table(name = "AVATAR")
public class Avatar {

	public static final Integer AVATAR_MALE = 1;

	public static final Integer AVATAR_FEMALE = 2;

	/**
	 * Avatar ID
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	private Long avatarId;

	/**
	 * Avatar name
	 */
	// @Size(max = 10, message = "validator.avatar.name.size")
	private String name;

	/**
	 * Avatar age
	 */
	private Long age;

	/**
	 * Avatar income
	 */
	private BigDecimal income;

	/**
	 * Avatar income from other business
	 */
	private BigDecimal otherIncome;

	/**
	 * Avatar costs for lease
	 */
	private BigDecimal leaseCosts;

	/**
	 * Avatar costs for energy
	 */
	private BigDecimal energyCosts;

	/**
	 * Avatar costs for food
	 */
	private BigDecimal foodCosts;

	/**
	 * Avatr costs for free time activity
	 */
	private BigDecimal freeTimeCosts;

	/**
	 * Avatar costs for traffic
	 */
	private BigDecimal trafficCosts;

	/**
	 * Avatar costs for clothes
	 */
	private BigDecimal clothesCosts;

	/**
	 * Avatar costs for vacation
	 */
	private BigDecimal vacationCosts;

	/**
	 * Avatar costs for phone
	 */
	private BigDecimal phoneCosts;

	/**
	 * Avatar costs for smoking
	 */
	private BigDecimal smokeCosts;

	/**
	 * Avatar other costs
	 */
	private BigDecimal otherCosts;

	/**
	 * Avatar alie or not?
	 */
	private Boolean alive;

	private Boolean template;

	/**
	 * Avatar type possible values:
	 * 
	 * AVATAR_MALE AVATAR_FEMALE
	 * 
	 */
	private Integer type;

	/**
	 * List of financial assets for Avatar
	 */
	@Transient
	private List<FinancialAssets> financialAssetsList;

	/**
	 * List of nonFinancial assets for Avatar
	 */
	@Transient
	private List<NonFinancialAssets> nonFinancialAssetsList;

	/**
	 * List of nonFinancial assets for Avatar
	 */
	@Transient
	private List<LinkedPerson> linkedPersonList;

	public Integer getType() {
		return type;
	}

	public void setType(final Integer type) {
		this.type = type;
	}

	public Long getAvatarId() {
		return avatarId;
	}

	public void setAvatarId(final Long avatarId) {
		this.avatarId = avatarId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(final Long age) {
		this.age = age;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(final BigDecimal income) {
		this.income = income;
	}

	public Boolean getAlive() {
		return alive;
	}

	public void setAlive(final Boolean alive) {
		this.alive = alive;
	}

	public BigDecimal getOtherIncome() {
		return otherIncome;
	}

	public void setOtherIncome(final BigDecimal otherIncome) {
		this.otherIncome = otherIncome;
	}

	public BigDecimal getLeaseCosts() {
		return leaseCosts;
	}

	public void setLeaseCosts(final BigDecimal leaseCosts) {
		this.leaseCosts = leaseCosts;
	}

	public BigDecimal getEnergyCosts() {
		return energyCosts;
	}

	public void setEnergyCosts(final BigDecimal energyCosts) {
		this.energyCosts = energyCosts;
	}

	public BigDecimal getFoodCosts() {
		return foodCosts;
	}

	public void setFoodCosts(final BigDecimal foodCosts) {
		this.foodCosts = foodCosts;
	}

	public BigDecimal getFreeTimeCosts() {
		return freeTimeCosts;
	}

	public void setFreeTimeCosts(final BigDecimal freeTimeCosts) {
		this.freeTimeCosts = freeTimeCosts;
	}

	public BigDecimal getTrafficCosts() {
		return trafficCosts;
	}

	public void setTrafficCosts(final BigDecimal trafficCosts) {
		this.trafficCosts = trafficCosts;
	}

	public BigDecimal getClothesCosts() {
		return clothesCosts;
	}

	public void setClothesCosts(final BigDecimal clothesCosts) {
		this.clothesCosts = clothesCosts;
	}

	public BigDecimal getVacationCosts() {
		return vacationCosts;
	}

	public void setVacationCosts(final BigDecimal vacationCosts) {
		this.vacationCosts = vacationCosts;
	}

	public BigDecimal getPhoneCosts() {
		return phoneCosts;
	}

	public void setPhoneCosts(final BigDecimal phoneCosts) {
		this.phoneCosts = phoneCosts;
	}

	public BigDecimal getSmokeCosts() {
		return smokeCosts;
	}

	public void setSmokeCosts(final BigDecimal smokeCosts) {
		this.smokeCosts = smokeCosts;
	}

	public BigDecimal getOtherCosts() {
		return otherCosts;
	}

	public void setOtherCosts(final BigDecimal therCosts) {
		this.otherCosts = therCosts;
	}

	public Boolean getTemplate() {
		return template;
	}

	public void setTemplate(final Boolean template) {
		this.template = template;
	}

	public List<FinancialAssets> getFinancialAssetsList() {
		return financialAssetsList;
	}

	public void setFinancialAssetsList(final List<FinancialAssets> financialAssetsList) {
		this.financialAssetsList = financialAssetsList;
	}

	public List<NonFinancialAssets> getNonFinancialAssetsList() {
		return nonFinancialAssetsList;
	}

	public void setNonFinancialAssetsList(final List<NonFinancialAssets> nonFinancialAssetsList) {
		this.nonFinancialAssetsList = nonFinancialAssetsList;
	}

	public List<LinkedPerson> getLinkedPersonList() {
		return linkedPersonList;
	}

	public void setLinkedPersonList(final List<LinkedPerson> linkedPersonList) {
		this.linkedPersonList = linkedPersonList;
	}

	@Override
	public String toString() {
		return "Avatar [avatarId=" + avatarId + ", name=" + name + ", age=" + age + ", income=" + income + ", otherIncome=" + otherIncome + ", leaseCosts=" + leaseCosts + ", energyCosts=" + energyCosts + ", foodCosts=" + foodCosts + ", freeTimeCosts=" + freeTimeCosts + ", trafficCosts=" + trafficCosts + ", clothesCosts=" + clothesCosts + ", vacationCosts=" + vacationCosts + ", phoneCosts="
				+ phoneCosts + ", smokeCosts=" + smokeCosts + ", otherCosts=" + otherCosts + ", alive=" + alive + ", template=" + template + ", type=" + type + "]";
	}

}
