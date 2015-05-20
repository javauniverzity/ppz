package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.Game;
import com.ppz.web.entity.GameEvent;

/**
 * REPOSITORY interface for GameEvent entity specific methods
 * 
 * @author Petr Hirs
 * 
 */
public interface GameEventRepository extends GenericRepository<GameEvent> {

	List<GameEvent> getGameEventListByGame(Game game, Long round);
	
}