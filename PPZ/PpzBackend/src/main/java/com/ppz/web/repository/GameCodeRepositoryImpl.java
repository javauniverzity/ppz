package com.ppz.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ppz.web.component.GameCodeComponent;
import com.ppz.web.entity.GameCode;

/**
 * Implementace repository objektu GameCode
 * @author David
 *
 */
@Repository(value = "gameCodeRepository")
public class GameCodeRepositoryImpl extends AbstractRepository<GameCode>
		implements GameCodeRepository {

	@Autowired
	private GameCodeComponent gameCodeComponent;

	@Override
	public void createGameCode(GameCode gameCode) {

		if (gameCode != null) {

			// pro pripad, ze je kod nula, vytvorime novy
			if (gameCode.getCode() == null) {
				String newUniqueCode = gameCodeComponent
						.generateUniqueGameCode();
				gameCode.setCode(newUniqueCode);
			}

			create(gameCode);
		}

	}

	@Override
	public void updateGameCode(GameCode gameCode) {
		update(gameCode);
	}

	@Override
	public List<GameCode> getGameCodeList() {
		return loadAll(GameCode.class);
	}

	@Override
	public GameCode getGameCode(Long gameCodeId) {
		return loadById(GameCode.class, gameCodeId);
	}
	/**
	 * Dej retezec GameCode
	 */
	@Override
	public GameCode getGameCode(String gameCode) {
		if (gameCode == null || "".equals(gameCode)) {
			return null;
		}
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("code", gameCode);
		List<GameCode> results = loadByFilter(filter, GameCode.class);
		if (results.size() != 0) {
			return (GameCode) results.get(0);
		} else {
			return null;
		}
	}

}
