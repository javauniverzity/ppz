package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.GameCode;

/**
 * REPOSITORY interface for object for entity GameCode
 * 
 * @author Petr Hirs
 * 
 */
public interface GameCodeRepository {

	/**
	 * Create and save GameCode entity
	 * @param gameCode - object to persist
	 */
	void createGameCode(GameCode gameCode);
	
	/**
	 * Update GameCode entity
	 * @param gameCode - object to persist
	 */
	void updateGameCode(GameCode gameCode);
	
	/**
	 * Get list of all gamesCodes
	 * @return list of all Games
	 */
	List<GameCode> getGameCodeList();
	
	/**
	 * Get gameCode by game id
	 * @param gamecodeId - gameCode identification
	 * @return gameCode identified by id
	 */
	GameCode getGameCode(Long gameId);

	/**
	 * Get gameCode by gameCode value
	 * @param gameCode - gameCode value
	 * @return gameCode identified by gameCode
	 */
	GameCode getGameCode(String gameCode);
	
}