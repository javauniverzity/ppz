package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.Game;
import com.ppz.web.entity.GameCode;
import com.ppz.web.entity.GameEvent;

/**
 * Interface repository specifickych metod pro entitu Game
 * @author David
 */
public interface GameRepository extends GenericRepository<Game>{

	/**
	 * Dej Game podle kodu
	 * @param gameCode - kod pro hru
	 * 
	 * @return hra identifikovana podle kodu
	 */
	Game getGame(GameCode gameCode);

	/**
	 * Dej seznam vsech hernich udalosti
	 * @param Game - identifikace hry
	 * 
	 * @return seznam vsech hernich udalosti
	 */
	public List<GameEvent> getLAllGameEvenList(Game game);	
	
}