package com.ppz.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ppz.web.entity.Game;
import com.ppz.web.entity.GameEvent;

@Repository(value = "gameEventRepository")
public class GameEventRepositoryImpl extends AbstractRepository<GameEvent> implements GameEventRepository {

	@Override
	public List<GameEvent> getGameEventListByGame(Game game, Long round) {

		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("occurredDate", round);
		filter.put("game", game);
		List<GameEvent> results = loadByFilter(filter, GameEvent.class);
		if (results.size() != 0) {
			return (List<GameEvent>) results;
		} else {
			return null;
		}
	}

}
