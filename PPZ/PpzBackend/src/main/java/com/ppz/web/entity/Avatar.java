package com.ppz.web.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "AVATAR")
public class Avatar {

	public static final Integer AVATAR_MALE = 1;

	public static final Integer AVATAR_FEMALE = 2;

	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	private Long avatarId;

//	@Size(max = 10, message = "validator.avatar.name.size")
	private String name;

	private Long age;

	private BigDecimal income;

	private BigDecimal otherIncome;

	private BigDecimal leaseCosts;

	private BigDecimal energyCosts;

	private BigDecimal foodCosts;

	private BigDecimal freeTimeCosts;

	private BigDecimal trafficCosts;

	private BigDecimal clothesCosts;

	private BigDecimal vacationCosts;

	private BigDecimal phoneCosts;

	private BigDecimal smokeCosts;

	private BigDecimal otherCosts;

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

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getAvatarId() {
		return avatarId;
	}

	public void setAvatarId(Long avatarId) {
		this.avatarId = avatarId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public Boolean getAlive() {
		return alive;
	}

	public void setAlive(Boolean alive) {
		this.alive = alive;
	}

	public BigDecimal getOtherIncome() {
		return otherIncome;
	}

	public void setOtherIncome(BigDecimal otherIncome) {
		this.otherIncome = otherIncome;
	}

	public BigDecimal getLeaseCosts() {
		return leaseCosts;
	}

	public void setLeaseCosts(BigDecimal leaseCosts) {
		this.leaseCosts = leaseCosts;
	}

	public BigDecimal getEnergyCosts() {
		return energyCosts;
	}

	public void setEnergyCosts(BigDecimal energyCosts) {
		this.energyCosts = energyCosts;
	}

	public BigDecimal getFoodCosts() {
		return foodCosts;
	}

	public void setFoodCosts(BigDecimal foodCosts) {
		this.foodCosts = foodCosts;
	}

	public BigDecimal getFreeTimeCosts() {
		return freeTimeCosts;
	}

	public void setFreeTimeCosts(BigDecimal freeTimeCosts) {
		this.freeTimeCosts = freeTimeCosts;
	}

	public BigDecimal getTrafficCosts() {
		return trafficCosts;
	}

	public void setTrafficCosts(BigDecimal trafficCosts) {
		this.trafficCosts = trafficCosts;
	}

	public BigDecimal getClothesCosts() {
		return clothesCosts;
	}

	public void setClothesCosts(BigDecimal clothesCosts) {
		this.clothesCosts = clothesCosts;
	}

	public BigDecimal getVacationCosts() {
		return vacationCosts;
	}

	public void setVacationCosts(BigDecimal vacationCosts) {
		this.vacationCosts = vacationCosts;
	}

	public BigDecimal getPhoneCosts() {
		return phoneCosts;
	}

	public void setPhoneCosts(BigDecimal phoneCosts) {
		this.phoneCosts = phoneCosts;
	}

	public BigDecimal getSmokeCosts() {
		return smokeCosts;
	}

	public void setSmokeCosts(BigDecimal smokeCosts) {
		this.smokeCosts = smokeCosts;
	}

	public BigDecimal getOtherCosts() {
		return otherCosts;
	}

	public void setOtherCosts(BigDecimal therCosts) {
		this.otherCosts = therCosts;
	}

	public Boolean getTemplate() {
		return template;
	}

	public void setTemplate(Boolean template) {
		this.template = template;
	}

	public List<FinancialAssets> getFinancialAssetsList() {
		return financialAssetsList;
	}

	public void setFinancialAssetsList(List<FinancialAssets> financialAssetsList) {
		this.financialAssetsList = financialAssetsList;
	}

	public List<NonFinancialAssets> getNonFinancialAssetsList() {
		return nonFinancialAssetsList;
	}

	public void setNonFinancialAssetsList(List<NonFinancialAssets> nonFinancialAssetsList) {
		this.nonFinancialAssetsList = nonFinancialAssetsList;
	}

	public List<LinkedPerson> getLinkedPersonList() {
		return linkedPersonList;
	}

	public void setLinkedPersonList(List<LinkedPerson> linkedPersonList) {
		this.linkedPersonList = linkedPersonList;
	}

	@Override
	public String toString() {
		return "Avatar [avatarId=" + avatarId + ", name=" + name + ", age=" + age + ", income=" + income + ", otherIncome=" + otherIncome + ", leaseCosts="
				+ leaseCosts + ", energyCosts=" + energyCosts + ", foodCosts=" + foodCosts + ", freeTimeCosts=" + freeTimeCosts + ", trafficCosts="
				+ trafficCosts + ", clothesCosts=" + clothesCosts + ", vacationCosts=" + vacationCosts + ", phoneCosts=" + phoneCosts + ", smokeCosts="
				+ smokeCosts + ", otherCosts=" + otherCosts + ", alive=" + alive + ", template=" + template + ", type=" + type + "]";
	}

}
