package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.Game;
import com.ppz.web.entity.GameEvent;

/**
 * Interface repository specifickych metod pro entitu GameEvent
 * @author David
 */
public interface GameEventRepository extends GenericRepository<GameEvent> {

	List<GameEvent> getGameEventListByGame(Game game, Long round);
	
}