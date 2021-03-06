package com.ppz.web.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Entity for NonFinancial assets
 */	

@Entity
@Table(name = "NON_FINANCIAL_ASSETS")
public class NonFinancialAssets {

	/**
	 * Assets type to number identifier
	 */	
	public static final Integer TYPE_CAR = 1;
	public static final Integer TYPE_REALTY = 2;

	/**
	 * Assets subtype to number identifier
	 */	
	public static final Integer SUBTYPE_CAR_LOWER_CLASS = 1;
	public static final Integer SUBTYPE_CAR_UPPER_CLASS = 2;
	public static final Integer SUBTYPE_CAR_SPORT = 3;
	public static final Integer SUBTYPE_CAR_LIMO = 4;

	public static final Integer SUBTYPE_REALTY_SMALL = 1;
	public static final Integer SUBTYPE_REALTY_MIDDLE = 2;
	public static final Integer SUBTYPE_REALTY_LUXURY = 3;
	public static final Integer SUBTYPE_REALTY_FAMILY_HOUSE = 4;
	public static final Integer SUBTYPE_REALTY_BIG_HOUSE = 5;

	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	private Long nonFinancialAssetsId;

	/**
	 * Asset name
	 */	
	private String name;

	/**
	 * Asset type
	 */	
	private Integer type;

	/**
	 * Asset subtype
	 */	
	private Integer subType;

	/**
	 * Regular monthly income from asset
	 */	
	private BigDecimal regularlyMonthlyIncome;

	/**
	 * Regular monthly expenses for asset
	 */	
	private BigDecimal regularlyMonthlyExpenses;

	/**
	 * Last try to sold
	 */	
	private Date lastTryToSold;

	/**
	 * Last try to rent
	 */	
	private Date lastTryToRent;

	/**
	 * Date of origin
	 */	
	private Date originDate;

	/**
	 * This entity exist in this round number (historical reason)  
	 */
	private Long roundNo;
	
	/**
	 * Owner of non financial asset
	 */
	@ManyToOne(optional = false)
	private Avatar avatar;

	public Long getNonFinancialAssetsId() {
		return nonFinancialAssetsId;
	}

	public void setNonFinancialAssetsId(Long nonFinancialAssetsId) {
		this.nonFinancialAssetsId = nonFinancialAssetsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSubType() {
		return subType;
	}

	public void setSubType(Integer subType) {
		this.subType = subType;
	}

	public BigDecimal getRegularlyMonthlyIncome() {
		return regularlyMonthlyIncome;
	}

	public void setRegularlyMonthlyIncome(BigDecimal regularlyMonthlyIncome) {
		this.regularlyMonthlyIncome = regularlyMonthlyIncome;
	}

	public BigDecimal getRegularlyMonthlyExpenses() {
		return regularlyMonthlyExpenses;
	}

	public void setRegularlyMonthlyExpenses(BigDecimal regularlyMonthlyExpenses) {
		this.regularlyMonthlyExpenses = regularlyMonthlyExpenses;
	}

	public Date getLastTryToSold() {
		return lastTryToSold;
	}

	public void setLastTryToSold(Date lastTryToSold) {
		this.lastTryToSold = lastTryToSold;
	}

	public Date getLastTryToRent() {
		return lastTryToRent;
	}

	public void setLastTryToRent(Date lastTryToRent) {
		this.lastTryToRent = lastTryToRent;
	}

	public Date getOriginDate() {
		return originDate;
	}

	public void setOriginDate(Date originDate) {
		this.originDate = originDate;
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

	@Override
	public String toString() {
		return "NonFinancialAssets [nonFinancialAssetsId=" + nonFinancialAssetsId + ", name=" + name + ", type=" + type + ", subType=" + subType
				+ ", regularlyMonthlyIncome=" + regularlyMonthlyIncome + ", regularlyMonthlyExpenses=" + regularlyMonthlyExpenses + ", lastTryToSold="
				+ lastTryToSold + ", lastTryToRent=" + lastTryToRent + ", originDate=" + originDate + ", roundNo=" + roundNo + ", avatar=" + avatar + "]";
	}

}
