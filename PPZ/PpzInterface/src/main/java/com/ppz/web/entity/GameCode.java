package com.ppz.web.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

/**
 * Entity for Game Code data
 */

@Entity
@Table(name = "GAME_CODE", uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
@NamedQueries({ @NamedQuery(name = "GameCode.findAll", query = "SELECT g FROM GameCode g"),
		@NamedQuery(name = "GameCode.findByGameCodeId", query = "SELECT g FROM GameCode g WHERE g.gameCodeId = :gameCodeId") })
public class GameCode {
	
	/**
	 * Name of key for save code to aplication session
	 */
	public static final String GAME_CODE = "GAME_CODE";

	/**
	 * Game code ID
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	private Long gameCodeId;

	/**
	 * Game code value
	 */
	private String code;

	/**
	 * Date of game code creation
	 */
	private Date created;

	/**
	 * Date of last played game with this game code
	 */
	private Date latestPlayedGameDate;

	/**
	 * Count of playable games with this game code
	 */
	private Long availableGamesCount;

	/**
	 * Count of already played game with this game code
	 */
	private Long alreadyPlayedGamesCount;

	/**
	 * Owner of game code
	 */
	@ManyToOne(optional = false)
	private Advisor advisor;

	/**
	 * User that use this game code
	 */
	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	private User user;

	/**
	 * Specific Game holds this game code
	 */
	@OneToOne(cascade = CascadeType.ALL, optional = true)
	private Game game;

	public Long getGameCodeId() {
		return gameCodeId;
	}

	public void setGameCodeId(Long gameCodeId) {
		this.gameCodeId = gameCodeId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLatestPlayedGameDate() {
		return latestPlayedGameDate;
	}

	public void setLatestPlayedGameDate(Date latestPlayedGameDate) {
		this.latestPlayedGameDate = latestPlayedGameDate;
	}

	public Long getAvailableGamesCount() {
		return availableGamesCount;
	}

	public void setAvailableGamesCount(Long availableGamesCount) {
		this.availableGamesCount = availableGamesCount;
	}

	public Long getAlreadyPlayedGamesCount() {
		return alreadyPlayedGamesCount;
	}

	public void setAlreadyPlayedGamesCount(Long alreadyPlayedGamesCount) {
		this.alreadyPlayedGamesCount = alreadyPlayedGamesCount;
	}

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public String toString() {
		return "GameCode [gameCodeId=" + gameCodeId + ", code=" + code + ", created=" + created + ", latestPlayedGameDate=" + latestPlayedGameDate
				+ ", availableGamesCount=" + availableGamesCount + ", alreadyPlayedGamesCount=" + alreadyPlayedGamesCount + ", advisor=" + advisor + ", user="
				+ user + ", game=" + game + "]";
	}

}