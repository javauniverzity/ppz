package com.ppz.web.spring.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ppz.web.entity.Game;

/**
 * Trida FormattedGame, ktera nastavi formatovou hru
 */
public class FormattedGame {
	
	/** Hra. */
	Game game;
	
	/** Vynulovani mesice. */
	String month = null;
	
	/** Vynulovani roku. */
	String year = null;
	
	/**
	 * Instance nove naformatovane hry.
	 *
	 * @param game hra
	 */
	public FormattedGame(Game game) {
		this.game = game;
		this.month = getMonth();
		this.year = getYear();
	}
	
	/**
	 * Nastaveni mesice.
	 *
	 * @return mesic
	 */
	public String getMonth() {
		Date date = game.getActualDate();
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
		String result = sdf.format(date);
		result = result.substring(0,1).toUpperCase() + result.substring(1);
		return result;
	}
	
	/**
	 * Nastaveni roku.
	 *
	 * @return rok
	 */
	public String getYear() {
		Date date = game.getActualDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(date);
	}
}
