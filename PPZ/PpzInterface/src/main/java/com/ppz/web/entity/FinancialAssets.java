package com.ppz.web.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ppz.web.utils.Exclude;

/**
 * Entity for Financial assets data
 */

@Entity
@Table(name = "FINANCIAL_ASSETS")
public class FinancialAssets {

	public static final Integer AVATAR_MALE = 1;

	public static final Integer AVATAR_FEMALE = 2;

	/**
	 * Financial asset ID
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	private Long financialAssetsId;

	/**
	 * Financial assets type
	 */
	private Integer type;

	/**
	 * Financial assets value
	 */
	private BigDecimal value;

	/**
	 * Financial assets monthly outcome
	 */
	private BigDecimal monthlyOutcome;

	/**
	 * Financial assets amount for last year
	 */
	private BigDecimal lastYearStoredAmount;

	/**
	 * Count of shares
	 */
	private Integer sharesCount;

	/**
	 * Count of bods
	 */
	private Integer bondsCount;

	/**
	 * Count of monetary funds
	 */
	private Integer monetaryFundsCount;

	private BigDecimal insuredSum;

	// TODO PHI: vazba na majetek (zastava, pojisteni)

	// TODO PHI: vazba na osobu (v pripade pojisteni)

	private Date endOfStage;

	/**
	 * Income from interest
	 */
	private BigDecimal interest;

	private Date endTime;

	/**
	 * Target amount
	 */
	private BigDecimal targetAmount;

	/**
	 * This entity exist in this round number (historical reason)
	 */
	private Long roundNo;

	/**
	 * Owner of financial assets
	 */
	@ManyToOne(optional = false)
	@Exclude
	private Avatar avatar;

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public Long getFinancialAssetsId() {
		return financialAssetsId;
	}

	public void setFinancialAssetsId(Long financialAssetsId) {
		this.financialAssetsId = financialAssetsId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getMonthlyOutcome() {
		return monthlyOutcome;
	}

	public void setMonthlyOutcome(BigDecimal monthlyOutcome) {
		this.monthlyOutcome = monthlyOutcome;
	}

	public BigDecimal getLastYearStoredAmount() {
		return lastYearStoredAmount;
	}

	public void setLastYearStoredAmount(BigDecimal lastYearStoredAmount) {
		this.lastYearStoredAmount = lastYearStoredAmount;
	}

	public Integer getSharesCount() {
		return sharesCount;
	}

	public void setSharesCount(Integer sharesCount) {
		this.sharesCount = sharesCount;
	}

	public Integer getBondsCount() {
		return bondsCount;
	}

	public void setBondsCount(Integer bondsCount) {
		this.bondsCount = bondsCount;
	}

	public Integer getMonetaryFundsCount() {
		return monetaryFundsCount;
	}

	public void setMonetaryFundsCount(Integer monetaryFundsCount) {
		this.monetaryFundsCount = monetaryFundsCount;
	}

	public BigDecimal getInsuredSum() {
		return insuredSum;
	}

	public void setInsuredSum(BigDecimal insuredSum) {
		this.insuredSum = insuredSum;
	}

	public Date getEndOfStage() {
		return endOfStage;
	}

	public void setEndOfStage(Date endOfStage) {
		this.endOfStage = endOfStage;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public BigDecimal getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(BigDecimal targetAmount) {
		this.targetAmount = targetAmount;
	}

	public Long getRoundNo() {
		return roundNo;
	}

	public void setRoundNo(Long roundNo) {
		this.roundNo = roundNo;
	}

	@Override
	public String toString() {
		return "FinancialAssets [financialAssetsId=" + financialAssetsId
				+ ", type=" + type + ", value=" + value + ", monthlyOutcome="
				+ monthlyOutcome + ", lastYearStoredAmount="
				+ lastYearStoredAmount + ", sharesCount=" + sharesCount
				+ ", bondsCount=" + bondsCount + ", monetaryFundsCount="
				+ monetaryFundsCount + ", insuredSum=" + insuredSum
				+ ", endOfStage=" + endOfStage + ", interest=" + interest
				+ ", endTime=" + endTime + ", targetAmount=" + targetAmount
				+ ", roundNo=" + roundNo + ", avatar=" + avatar + "]";
	}

}
