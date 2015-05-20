package com.ppz.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Entity for PossibleEvent data
 * 
 * @author Petr Hirs
 * 
 */
@Entity
@Table(name = "POSSIBLE_EVENT")
public class PossibleEvent {

	public static final Integer POSSIBLE_EVENT_ROOT_DECISION_OTHERS = 1;
	public static final Integer POSSIBLE_EVENT_ROOT_DECISION_ASSETS = 2;
	public static final Integer POSSIBLE_EVENT_ROOT_DECISION_FAMILY = 3;
	public static final Integer POSSIBLE_EVENT_ROOT_DECISION_FINANCIL_PRODUCTS = 4;

	/**
	 * PossibleEvent ID
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	private Long possibleEventId;

	// TODO PHI: vazba na financni produkt z property (insuranceProtection),
	// ktery se aktivuje, v pripade ze tato udalost nastane

	/**
	 * Event name
	 */
	private String name;

	/**
	 * Flag if event is stopper
	 */
	private Boolean stopper;

	/**
	 * Flag if it's necessary to make some decision
	 */
	private Boolean needDecision;

	/**
	 * Value for determine root of decision, possible values:
	 * POSSIBLE_EVENT_ROOT_DECISION_OTHERS | POSSIBLE_EVENT_ROOT_DECISION_ASSETS
	 * | POSSIBLE_EVENT_ROOT_DECISION_FAMILY |
	 * POSSIBLE_EVENT_ROOT_DECISION_FINANCIL_PRODUCTS
	 * 
	 */
	private Integer rootDecision;

	/**
	 * Type of assets, possible values: NonFinancialAssets.TYPE_CAR |
	 * NonFinancialAssets.TYPE_REALTY
	 */
	private Integer assetsType;

	/**
	 * Type of decision, linked by rootDecision to concrete enum
	 * 
	 */
	private Integer decisionType;

	public Long getPossibleEventId() {
		return possibleEventId;
	}

	public void setPossibleEventId(Long possibleEventId) {
		this.possibleEventId = possibleEventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getStopper() {
		return stopper;
	}

	public void setStopper(Boolean stopper) {
		this.stopper = stopper;
	}

	public Boolean getNeedDecision() {
		return needDecision;
	}

	public void setNeedDecision(Boolean needDecision) {
		this.needDecision = needDecision;
	}

	public Integer getRootDecision() {
		return rootDecision;
	}

	public void setRootDecision(Integer rootDecision) {
		this.rootDecision = rootDecision;
	}

	public Integer getAssetsType() {
		return assetsType;
	}

	public void setAssetsType(Integer assetsType) {
		this.assetsType = assetsType;
	}

	public Integer getDecisionType() {
		return decisionType;
	}

	public void setDecisionType(Integer decisionType) {
		this.decisionType = decisionType;
	}

	@Override
	public String toString() {
		return "PossibleEvent [possibleEventId=" + possibleEventId + ", name=" + name + ", stopper=" + stopper + ", needDecision=" + needDecision
				+ ", rootDecision=" + rootDecision + ", assetsType=" + assetsType + ", decisionType=" + decisionType + "]";
	}

}
