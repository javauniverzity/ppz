package com.ppz.web.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * Entity for Game data
 */

@Entity
@Table(name = "GAME")
@NamedQueries({ @NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g"),
		@NamedQuery(name = "Game.findByGameId", query = "SELECT g FROM Game g WHERE g.gameId = :gameId") })
public class Game {

	public static final Integer GAME_STATUS_IN_PLAY = 1;
	public static final Integer GAME_STATUS_FINISHED = 2;

	/**
	 * Game ID
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	private Long gameId;

	/**
	 * Game name
	 */
	private String name;

	/**
	 * Date of game last play
	 */
	private Date lastPlayDate;

	/**
	 * Game status GAME_STATUS_IN_PLAY | GAME_STATUS_FINISHED
	 */
	private Integer status;

	/**
	 * Counter of played game rounds till now
	 */
	private Long roundPlayed;

	/**
	 * Actual date from game
	 */
	private Date actualDate;

	/**
	 * Avatar selected for this game
	 */
	@OneToOne(cascade = CascadeType.ALL, optional = true)
	private Avatar avatar;

	/**
	 * List of occur game events
	 */
	@Transient
	private List<GameEvent> gameEventList;
	
	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastPlayDate() {
		return lastPlayDate;
	}

	public void setLastPlayDate(Date lastPlayDate) {
		this.lastPlayDate = lastPlayDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getRoundPlayed() {
		return roundPlayed;
	}

	public void setRoundPlayed(Long roundPlayed) {
		this.roundPlayed = roundPlayed;
	}

	public Date getActualDate() {
		return actualDate;
	}

	public void setActualDate(Date actualDate) {
		this.actualDate = actualDate;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public List<GameEvent> getGameEventList() {
		return gameEventList;
	}

	public void setGameEventList(List<GameEvent> gameEventList) {
		this.gameEventList = gameEventList;
	}

	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", name=" + name + ", lastPlayDate=" + lastPlayDate + ", status=" + status + ", roundPlayed=" + roundPlayed
				+ ", actualDate=" + actualDate + ", avatar=" + avatar + "]";
	}

}
