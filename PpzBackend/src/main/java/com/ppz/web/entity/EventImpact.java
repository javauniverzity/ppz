package com.ppz.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Entity for EventImpact data
 * 
 * @author Petr Hirs
 * 
 */
@Entity
@Table(name = "EVENT_IMPACT")
public class EventImpact {

	public static final Integer EVENT_IMPACT_TYPE_NONE = 1;
	public static final Integer EVENT_IMPACT_TYPE_CHANGE_MONEY = 2;
	public static final Integer EVENT_IMPACT_TYPE_CHANGE_INCOME = 3;
	public static final Integer EVENT_IMPACT_TYPE_CHANGE_EXPENSES = 4;
	public static final Integer EVENT_IMPACT_TYPE_ENVIRONS_MINUS = 5;
	public static final Integer EVENT_IMPACT_TYPE_ENVIRONS_PLUS = 6;
	public static final Integer EVENT_IMPACT_TYPE_ASSETS_MINUS = 7;

	/**
	 * EventImpact ID
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	private Long eventImpactId;

	/**
	 * Event impact type, possible values: EVENT_IMPACT_TYPE_*
	 */
	private Integer type;

	/**
	 * For money is amount of change, for family member is ID of family member
	 * type;
	 */
	private Long impactSize;

	/**
	 * Flag if this event impact is insured.
	 */
	private Boolean insuredImpact;

	/**
	 * Link to possible event
	 */
	@ManyToOne(optional = false)
	private PossibleEvent possibleEvent;

	public Long getEventImpactId() {
		return eventImpactId;
	}

	public void setEventImpactId(Long eventImpactId) {
		this.eventImpactId = eventImpactId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getImpactSize() {
		return impactSize;
	}

	public void setImpactSize(Long impactSize) {
		this.impactSize = impactSize;
	}

	public Boolean getInsuredImpact() {
		return insuredImpact;
	}

	public void setInsuredImpact(Boolean insuredImpact) {
		this.insuredImpact = insuredImpact;
	}

	public PossibleEvent getPossibleEvent() {
		return possibleEvent;
	}

	public void setPossibleEvent(PossibleEvent possibleEvent) {
		this.possibleEvent = possibleEvent;
	}

	@Override
	public String toString() {
		return "EventImpact [eventImpactId=" + eventImpactId + ", type=" + type + ", impactSize=" + impactSize + ", insuredImpact=" + insuredImpact
				+ ", possibleEvent=" + possibleEvent + "]";
	}

}
