package com.ppz.web.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ppz.web.entity.Avatar;
import com.ppz.web.entity.Game;
import com.ppz.web.entity.GameCode;
import com.ppz.web.entity.GameEvent;

/**
 * Implementace repository entity Game
 * @author pc
 */
@Repository(value = "gameRepository")
public class GameRepositoryImpl extends AbstractRepository<Game> implements GameRepository {

	@Autowired
	private FinancialAssetsRepository faRepository;

	@Autowired
	private NonFinancialAssetsRepository nonFaRepository;

	@Autowired
	private LinkedPersonRepository lpRepository;

	@Autowired
	private GameEventRepository geRepository;

	/**
	 * Vyhledavani hry podle herniho kodu
	 */
	@Override
	public Game getGame(GameCode gameCodeToFind) {

		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<GameCode> crit = criteriaBuilder.createQuery(GameCode.class);
		final Root<GameCode> from = crit.from(GameCode.class);
		crit.select(from).where(criteriaBuilder.equal(from.get("code"), gameCodeToFind.getCode()));

		List<GameCode> results = entityManager.createQuery(crit).setFirstResult(0).setMaxResults(1).getResultList();
		if (results.size() != 0) {
			GameCode gameCode = (GameCode) results.get(0);

			if (gameCode.getGame() != null) {

				Long actualRound = gameCode.getGame().getRoundPlayed();

				// dej zbytek spojenych docasnych seznamu

				Avatar gameAvatar = gameCode.getGame().getAvatar();

				// docasna financni aktiva
				gameCode.getGame().getAvatar().setFinancialAssetsList(faRepository.getFinancialAssetsByAvatar(gameAvatar));

				// docasna nefinancni aktiva
				gameCode.getGame().getAvatar().setNonFinancialAssetsList(nonFaRepository.getNonFinancialAssetsListByAvatar(gameAvatar));

				// seznam spojenych docasnych avataru
				gameCode.getGame().getAvatar().setLinkedPersonList(lpRepository.getLinkedPersonListByAvatar(gameAvatar, actualRound));

				// docasne herni udalosti
				gameCode.getGame().setGameEventList((geRepository.getGameEventListByGame(gameCode.getGame(), actualRound)));

			}

			return gameCode.getGame();
		} else {
			return null;
		}
	}

	/** 
	 * Dej seznam vsech hernich udalosti
	 */
	@Override
	public List<GameEvent> getLAllGameEvenList(Game game) {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<GameEvent> crit = criteriaBuilder.createQuery(GameEvent.class);
		final Root<GameEvent> from = crit.from(GameEvent.class);
		crit.select(from).where(criteriaBuilder.equal(from.get("game"), game));

		List<GameEvent> results = entityManager.createQuery(crit).getResultList();

		if (results.size() != 0) {
			return (List<GameEvent>) results;
		} else {
			return null;
		}
	}

}
