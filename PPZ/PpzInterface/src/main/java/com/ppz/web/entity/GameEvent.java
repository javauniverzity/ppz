package com.ppz.web.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ppz.web.utils.Exclude;

/**
 * Entity for GameEvent data
 */

@Entity
@Table(name = "GAME_EVENT")
public class GameEvent {

	public static final Integer EVENT_STATUS_WAITING_FOR_READING = 1;
	public static final Integer EVENT_STATUS_WAITING_FOR_SOLVING = 2;
	public static final Integer EVENT_STATUS_SOLVED = 3;

	/**
	 * GameEvent ID
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	private Long gameEventId;

	/**
	 * Occurred date of event
	 */
	private Long occurredDate;

	/**
	 * Event state, possible values: EVENT_STATUS_WAITING_FOR_READING |
	 * EVENT_STATUS_WAITING_FOR_SOLVING | EVENT_STATUS_SOLVED
	 */
	private Integer status;

	/**
	 * Player's decision 
	 */
	private Integer decided;

	/**
	 * Link to game where this event occur
	 */
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@Exclude
	private Game game;

	/**
	 * This event is one from possible events
	 */
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private PossibleEvent possibleEvent;

	public Long getGameEventId() {
		return gameEventId;
	}

	public void setGameEventId(Long gameEventId) {
		this.gameEventId = gameEventId;
	}

	public Long getOccurredDate() {
		return occurredDate;
	}

	public void setOccurredDate(Long occuredDate) {
		this.occurredDate = occuredDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDecided() {
		return decided;
	}

	public void setDecided(Integer decided) {
		this.decided = decided;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public PossibleEvent getPossibleEvent() {
		return possibleEvent;
	}

	public void setPossibleEvent(PossibleEvent possibleEvent) {
		this.possibleEvent = possibleEvent;
	}

	@Override
	public String toString() {
		return "GameEvent [gameEventId=" + gameEventId + ", occurredDate=" + occurredDate + ", status=" + status + ", decided=" + decided + ", game=" + game
				+ ", possibleEvent=" + possibleEvent + "]";
	}

}
