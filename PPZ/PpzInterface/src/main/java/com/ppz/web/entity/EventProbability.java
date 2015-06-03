package com.ppz.web.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Entity for EventProbability data
 */

@Entity
@Table(name = "EVENT_PROBABILITY")
public class EventProbability {

	/**
	 * EventProbability ID
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	private Long eventProbabilityId;

	/**
	 * Is possible to occur this event for persons or assets older than this
	 * value.
	 */
	private Integer ageFrom;

	/**
	 * Is possible to occur this event for persons or assets younger than this
	 * value.
	 */
	private Integer ageTo;

	/**
	 * Is possible to occur this event for assets or financial assets with price
	 * higher than this value.
	 */
	private BigDecimal valueFrom;

	/**
	 * Is possible to occur this event for assets or financial assets with price
	 * lower than this value.
	 */
	private BigDecimal valueTo;

	/**
	 * Probability to occur linked possible event
	 */
	private Double probability;

	/**
	 * Probability of concrete possible event
	 */
	@ManyToOne(optional = false)
	private PossibleEvent possibleEvent;

	public Long getEventProbabilityId() {
		return eventProbabilityId;
	}

	public void setEventProbabilityId(Long eventProbabilityId) {
		this.eventProbabilityId = eventProbabilityId;
	}

	public Integer getAgeFrom() {
		return ageFrom;
	}

	public void setAgeFrom(Integer ageFrom) {
		this.ageFrom = ageFrom;
	}

	public Integer getAgeTo() {
		return ageTo;
	}

	public void setAgeTo(Integer ageTo) {
		this.ageTo = ageTo;
	}

	public BigDecimal getValueFrom() {
		return valueFrom;
	}

	public void setValueFrom(BigDecimal valueFrom) {
		this.valueFrom = valueFrom;
	}

	public BigDecimal getValueTo() {
		return valueTo;
	}

	public void setValueTo(BigDecimal valueTo) {
		this.valueTo = valueTo;
	}

	public PossibleEvent getPossibleEvent() {
		return possibleEvent;
	}

	public void setPossibleEvent(PossibleEvent possibleEvent) {
		this.possibleEvent = possibleEvent;
	}

	public Double getProbability() {
		return probability;
	}

	public void setProbability(Double probability) {
		this.probability = probability;
	}

	@Override
	public String toString() {
		return "EventProbability [eventProbabilityId=" + eventProbabilityId
				+ ", ageFrom=" + ageFrom + ", ageTo=" + ageTo + ", valueFrom="
				+ valueFrom + ", valueTo=" + valueTo + ", probability="
				+ probability + ", possibleEvent=" + possibleEvent + "]";
	}

}
