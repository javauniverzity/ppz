package com.ppz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppz.web.entity.Advisor;
import com.ppz.web.entity.Avatar;
import com.ppz.web.entity.EventImpact;
import com.ppz.web.entity.EventProbability;
import com.ppz.web.entity.FinancialAssets;
import com.ppz.web.entity.Game;
import com.ppz.web.entity.GameCode;
import com.ppz.web.entity.GameEvent;
import com.ppz.web.entity.LinkedPerson;
import com.ppz.web.entity.NonFinancialAssets;
import com.ppz.web.entity.PossibleEvent;
import com.ppz.web.interfaces.service.PpzService;
import com.ppz.web.repository.AdvisorRepository;
import com.ppz.web.repository.AvatarRepository;
import com.ppz.web.repository.EventImpactRepository;
import com.ppz.web.repository.EventProbabilityRepository;
import com.ppz.web.repository.FinancialAssetsRepository;
import com.ppz.web.repository.GameCodeRepository;
import com.ppz.web.repository.GameRepository;
import com.ppz.web.repository.LinkedPersonRepository;
import com.ppz.web.repository.NonFinancialAssetsRepository;
import com.ppz.web.repository.PossibleEventRepository;

@Service
@Transactional
public class PpzServiceImpl implements PpzService {

	@Autowired(required = true)
	private AvatarRepository avatarRepository;

	@Autowired(required = true)
	private GameRepository gameRepository;

	@Autowired(required = true)
	private AdvisorRepository advisorRepository;

	@Autowired(required = true)
	private GameCodeRepository gameCodeRepository;

	@Autowired(required = true)
	private FinancialAssetsRepository financialAssetsRepository;

	@Autowired(required = true)
	private NonFinancialAssetsRepository nonFinancialAssetsRepository;

	@Autowired(required = true)
	private LinkedPersonRepository linkedPersonRepository;

	@Autowired(required = true)
	private PossibleEventRepository possibleEventRepository;

	@Autowired(required = true)
	private EventProbabilityRepository eventProbabilityRepository;

	@Autowired(required = true)
	private EventImpactRepository eventImpactRepository;

	@Override
	@Transactional(readOnly = true)
	public Avatar getAvatar(Long avatarId) {
		return this.avatarRepository.loadById(Avatar.class, avatarId);
	}

	@Override
	@Transactional
	public void createAvatar(Avatar avatar) {
		this.avatarRepository.create(avatar);
	}

	@Override
	@Transactional
	public Avatar updateAvatar(Avatar avatar) {
		avatarRepository.update(avatar);
		return avatar;
	}

	@Override
	@Transactional(readOnly = true)
	public Game getGame(Long gameId) {
		return gameRepository.loadById(Game.class, gameId);
	}

	@Override
	public Game getGame(GameCode gameCode) {
		return this.gameRepository.getGame(gameCode);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Game> getGameList() {
		return this.gameRepository.loadAll(Game.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GameEvent> getLAllGameEvenList(Game game) {
		return this.gameRepository.getLAllGameEvenList(game);
	}

	@Override
	@Transactional
	public void createGame(Game game) {
		this.gameRepository.create(game);
	}

	@Override
	@Transactional
	public void updateGame(Game game) {
		this.gameRepository.update(game);
	}

	@Override
	@Transactional
	public void createAdvisor(Advisor advisor) {
		this.advisorRepository.createAdvisor(advisor);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Advisor> getAdvisorList() {
		return this.advisorRepository.getAdvisorList();
	}

	@Override
	@Transactional(readOnly = true)
	public GameCode getGameCode(Long gameCodeId) {
		return this.gameCodeRepository.getGameCode(gameCodeId);
	}

	@Override
	@Transactional(readOnly = true)
	public GameCode getGameCode(String gameCode) {
		return this.gameCodeRepository.getGameCode(gameCode);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GameCode> getGameCodeList() {
		return this.gameCodeRepository.getGameCodeList();
	}

	@Override
	@Transactional
	public void createGameCode(GameCode gameCode) {
		this.gameCodeRepository.createGameCode(gameCode);
	}

	@Override
	@Transactional
	public void updateGameCode(GameCode gameCode) {
		this.gameCodeRepository.updateGameCode(gameCode);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FinancialAssets> getFinancialAssetsByAvatar(Avatar avatar) {
		return this.financialAssetsRepository.getFinancialAssetsByAvatar(avatar);
	}

	@Override
	@Transactional
	public void createFinancialAssets(FinancialAssets financialAssets) {
		this.financialAssetsRepository.createFinancialAssets(financialAssets);
	}

	@Override
	@Transactional
	public FinancialAssets updateFinancialAssets(FinancialAssets financialAssets) {
		return this.financialAssetsRepository.updateFinancialAssets(financialAssets);
	}

	@Override
	@Transactional(readOnly = true)
	public FinancialAssets getFinancialAssets(Long financialAssetsId) {
		return this.financialAssetsRepository.loadById(FinancialAssets.class, financialAssetsId);
	}

	@Override
	@Transactional
	public void deleteFinancialAssets(FinancialAssets financialAssets) {
		this.financialAssetsRepository.delete(financialAssets);
	}

	@Override
	@Transactional(readOnly = true)
	public List<NonFinancialAssets> getNonFinancialAssetsByAvatar(Avatar avatar) {
		return this.nonFinancialAssetsRepository.getNonFinancialAssetsListByAvatar(avatar);
	}

	@Override
	@Transactional
	public void createNonFinancialAssets(NonFinancialAssets nonFinancialAssets) {
		this.nonFinancialAssetsRepository.createNonFinancialAssets(nonFinancialAssets);
	}

	@Override
	@Transactional
	public NonFinancialAssets updateNonFinancialAssets(NonFinancialAssets nonFinancialAssets) {
		return this.nonFinancialAssetsRepository.updateNonFinancialAssets(nonFinancialAssets);
	}

	@Override
	@Transactional(readOnly = true)
	public List<LinkedPerson> getLinkedPersonByAvatar(Avatar avatar, Long round) {
		return this.linkedPersonRepository.getLinkedPersonListByAvatar(avatar, round);
	}

	@Override
	@Transactional
	public void deleteLinkedPerson(LinkedPerson linkedPerson) {
		this.linkedPersonRepository.delete(linkedPerson);
	}

	@Override
	@Transactional(readOnly = true)
	public LinkedPerson getLinkedPerson(Long linkedPersonId) {
		return this.linkedPersonRepository.loadById(LinkedPerson.class, linkedPersonId);
	}

	@Override
	@Transactional
	public void createLinkedPerson(LinkedPerson linkedPerson) {
		this.linkedPersonRepository.create(linkedPerson);
	}

	@Override
	@Transactional
	public LinkedPerson updateLinkedPerson(LinkedPerson linkedPerson) {
		this.linkedPersonRepository.update(linkedPerson);
		return linkedPerson;
	}

	@Override
	@Transactional
	public void createPossibleEvent(PossibleEvent possibleEvent) {
		this.possibleEventRepository.create(possibleEvent);
	}

	@Override
	@Transactional
	public PossibleEvent updatePossibleEvent(PossibleEvent possibleEvent) {
		this.possibleEventRepository.update(possibleEvent);
		return possibleEvent;
	}

	@Override
	@Transactional(readOnly = true)
	public PossibleEvent getPossibleEvent(Long possibleEventId) {
		return this.possibleEventRepository.loadById(PossibleEvent.class, possibleEventId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PossibleEvent> getPossibleEventList() {
		return this.possibleEventRepository.loadAll(PossibleEvent.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PossibleEvent> getPossibleEventList(Integer rootDecision, Integer decisionType) {
		return this.possibleEventRepository.getPossibleEventList(rootDecision, decisionType);
	}
	
	@Override
	@Transactional
	public void createEventProbability(EventProbability eventProbability) {
		this.eventProbabilityRepository.create(eventProbability);
	}

	@Override
	@Transactional
	public EventProbability updateEventProbability(EventProbability eventProbability) {
		this.eventProbabilityRepository.update(eventProbability);
		return eventProbability;
	}

	@Override
	@Transactional(readOnly = true)
	public List<EventProbability> getEventProbabilityList(PossibleEvent possibleEvent) {
		return this.eventProbabilityRepository.getEventProbabilityList(possibleEvent);
	}

	@Override
	@Transactional
	public void createEventImpact(EventImpact eventImpact) {
		this.eventImpactRepository.create(eventImpact);
	}

	@Override
	@Transactional
	public EventImpact updateEventImpact(EventImpact eventImpact) {
		 this.eventImpactRepository.update(eventImpact);
		 return eventImpact;
	}

	@Override
	@Transactional(readOnly = true)
	public List<EventImpact> getEventImpactList() {
		return this.eventImpactRepository.loadAll(EventImpact.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EventImpact> getEventImpactListByPossibleEvent(PossibleEvent possibleEvent) {
		return this.eventImpactRepository.getEventImpactListByPossibleEvent(possibleEvent);
	}

}