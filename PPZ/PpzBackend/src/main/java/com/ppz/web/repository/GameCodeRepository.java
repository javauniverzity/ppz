package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.GameCode;

/**
 * Interface repository pro entitu objektu GameCode
 * @author David
 */
public interface GameCodeRepository {

	/**
	 * Vytvori a ulozi entitu GameCode
	 * @param gameCode - objekt do persist
	 */
	void createGameCode(GameCode gameCode);
	
	/**
	 * Aktualizuje entitu GameCode
	 * @param gameCode - objekt do persist
	 */
	void updateGameCode(GameCode gameCode);
	
	/**
	 * Dej seznam vsech GameCodu
	 */
	List<GameCode> getGameCodeList();
	
	/**
	 * Dej GameCode podle Id
	 */
	GameCode getGameCode(Long gameId);

	/**
	 * Dej GameCode podle hodnoty
	 */
	GameCode getGameCode(String gameCode);
	
}