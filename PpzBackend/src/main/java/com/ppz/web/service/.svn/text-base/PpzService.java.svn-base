package com.ppz.web.service;

import java.util.List;

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

/**
 * PPZ service - main functionality from repositories
 * 
 * @author Petr Hirs
 *
 */
public interface PpzService {

	/**********************
	 * AVATARs
	 **********************/
	Avatar getAvatar(Long id);
	
	void createAvatar(Avatar avatar);

	Avatar updateAvatar(Avatar avatar);

	/**********************
	 * ADVISORs
	 **********************/
	void createAdvisor(Advisor advisor);
	
	List<Advisor> getAdvisorList();
	
	/**********************
	 * GAMEs
	 **********************/

	void createGame(Game game);
	
	void updateGame(Game game);
	
	Game getGame(Long gameId);

	Game getGame(GameCode gameCode);
	
	List<Game> getGameList();

	List<GameEvent> getLAllGameEvenList(Game game);	

	/**********************
	 * GAME CODEs
	 **********************/
	GameCode getGameCode(Long gameCodeId);
	
	List<GameCode> getGameCodeList();
	
	void createGameCode(GameCode gameCode);
	
	void updateGameCode(GameCode gameCode);
	
	GameCode getGameCode(String gameCode);

	/**********************
	 * FINANCIAL ASSETS
	 **********************/
	
	FinancialAssets getFinancialAssets(Long financialAssetsId);
	
	List<FinancialAssets> getFinancialAssetsByAvatar(Avatar avatar);

	void createFinancialAssets(FinancialAssets financialAssets);

	FinancialAssets updateFinancialAssets(FinancialAssets financialAssets);
	
	void deleteFinancialAssets(FinancialAssets financialAssets);

	/**********************
	 * NON FINANCIAL ASSETS
	 **********************/
	List<NonFinancialAssets> getNonFinancialAssetsByAvatar(Avatar avatar);

	void createNonFinancialAssets(NonFinancialAssets nonFinancialAssets);

	NonFinancialAssets updateNonFinancialAssets(NonFinancialAssets nonFinancialAssets);

	/**********************
	 * LINKED PERSONs
	 **********************/
	List<LinkedPerson> getLinkedPersonByAvatar(Avatar avatar, Long round);

	void createLinkedPerson(LinkedPerson linkedPerson);

	LinkedPerson updateLinkedPerson(LinkedPerson linkedPerson);
	
	void deleteLinkedPerson(LinkedPerson linkedPerson);
	
	LinkedPerson getLinkedPerson(Long linkedPersonId);
	
	/**********************
	 * POSSIBLE EVENTs
	 **********************/
	void createPossibleEvent(PossibleEvent possibleEvent);

	PossibleEvent updatePossibleEvent(PossibleEvent possibleEvent);
	
	PossibleEvent getPossibleEvent(Long possibleEventId);
	
	List<PossibleEvent> getPossibleEventList();

	List<PossibleEvent> getPossibleEventList(Integer rootDecision, Integer decisionType);
	
	/**********************
	 * EVENT PROBABILITies
	 **********************/
	void createEventProbability(EventProbability eventProbability);

	EventProbability updateEventProbability(EventProbability eventProbability);
	
	List<EventProbability> getEventProbabilityList(PossibleEvent possibleEvent);

	/**********************
	 * EVENT IMPACTs
	 **********************/
	void createEventImpact(EventImpact eventImpact);

	EventImpact updateEventImpact(EventImpact eventImpact);
	
	List<EventImpact> getEventImpactList();
	
	List<EventImpact> getEventImpactListByPossibleEvent(PossibleEvent possibleEvent);
}
