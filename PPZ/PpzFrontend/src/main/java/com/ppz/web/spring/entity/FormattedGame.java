package com.ppz.web.spring.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ppz.web.entity.Game;

public class FormattedGame {
	Game game;
	String month = null;
	String year = null;
	
	public FormattedGame(Game game) {
		this.game = game;
		this.month = getMonth();
		this.year = getYear();
	}
	
	public String getMonth() {
		Date date = game.getActualDate();
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
		String result = sdf.format(date);
		result = result.substring(0,1).toUpperCase() + result.substring(1);
		return result;
	}
	
	public String getYear() {
		Date date = game.getActualDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(date);
	}
}
