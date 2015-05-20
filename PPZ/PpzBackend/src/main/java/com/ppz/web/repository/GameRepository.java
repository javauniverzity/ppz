package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.Game;
import com.ppz.web.entity.GameCode;
import com.ppz.web.entity.GameEvent;

/**
 * REPOSITORY interface for Game entity specific methods
 * 
 * 
 * 
 */
public interface GameRepository extends GenericRepository<Game>{

	/**
	 * Get game by game code
	 * @param gameCode - code for game
	 * 
	 * @return game identified by game code
	 */
	Game getGame(GameCode gameCode);

	/**
	 * Get list of all game events
	 * @param Game - game identification
	 * 
	 * @return list of all game events
	 */
	public List<GameEvent> getLAllGameEvenList(Game game);	
	
}