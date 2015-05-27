package com.ppz.web.component;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ppz.web.entity.Avatar;
import com.ppz.web.entity.EventImpact;
import com.ppz.web.entity.EventProbability;
import com.ppz.web.entity.Game;
import com.ppz.web.entity.GameCode;
import com.ppz.web.entity.LinkedPerson;
import com.ppz.web.entity.PossibleEvent;
import com.ppz.web.interfaces.service.PpzService;

@Component
public class KomendiusComponent {

	private static Long actualTime = 0L;

	@Autowired
	private PpzService ppzService;

	public GameCode getNextGameEvent(GameCode gameCode) {

		if (gameCode != null && gameCode.getGame() != null && gameCode.getGame().getAvatar() != null) {

			// get all linked persons
			List<LinkedPerson> linkedPersonByAvatar = ppzService.getLinkedPersonByAvatar(gameCode.getGame().getAvatar(), actualTime);

			if (linkedPersonByAvatar != null) {
				for (LinkedPerson linkedPerson : linkedPersonByAvatar) {

					Boolean isPersonDead = Boolean.FALSE;

					List<PossibleEvent> possibleEventList = ppzService.getPossibleEventList(PossibleEvent.POSSIBLE_EVENT_ROOT_DECISION_FAMILY,
							linkedPerson.getType());

					if (possibleEventList != null) {
						for (PossibleEvent possibleEvent : possibleEventList) {

							System.out.println("WORKING WITH PE: " + possibleEvent);

							// get probabilities for each of possible event

							System.out.println("..getting probabilities");

							List<EventProbability> eventProbabilityList = ppzService.getEventProbabilityList(possibleEvent);

							if (eventProbabilityList != null) {
								for (EventProbability eventProbability : eventProbabilityList) {

									// we will compare AGEs
									if (PossibleEvent.POSSIBLE_EVENT_ROOT_DECISION_FAMILY.equals(possibleEvent.getRootDecision())) {

										// decide who ages
										//

										// for DOG
										if (LinkedPerson.PERSON_TYPE_DOG.equals(possibleEvent.getDecisionType())) {

											Boolean ageCheck = chceckAges(eventProbability.getAgeFrom(), eventProbability.getAgeTo(), linkedPerson.getAge());

											System.out.println("... check probability Age condition result: " + ageCheck);

											if (ageCheck) {
												Random random = new Random();
												double randomNumber = random.nextDouble();

												Boolean randomResult = (randomNumber < eventProbability.getProbability() ? Boolean.TRUE : Boolean.FALSE);

												System.out.println("... compute probability of event occurence result: " + randomResult);

												// if possible event occur we
												// compute impact
												if (randomResult) {

													System.out.println("... PossibleEvent impact compute");

													List<EventImpact> eventImpactListByPossibleEvent = ppzService
															.getEventImpactListByPossibleEvent(possibleEvent);

													if (eventImpactListByPossibleEvent != null) {
														for (EventImpact eventImpact : eventImpactListByPossibleEvent) {

															if (EventImpact.EVENT_IMPACT_TYPE_ENVIRONS_MINUS.equals(eventImpact.getType())) {

																System.out.println("... EventEnvironMinus Occur -> DEAD for person detected");

																isPersonDead = Boolean.TRUE;

															}

														}

													}

												}

											}

										}

									}

								}
							}

						}

					} // neexistuje zadna mozna udalost pro danou entitu a jeji
						// typ

					// for alive person do person older
					if (!isPersonDead) {

						System.out.println("... go with person to next round");

						LinkedPerson lpForNextRound = new LinkedPerson();
						lpForNextRound.setExpenses(linkedPerson.getExpenses());
						lpForNextRound.setType(linkedPerson.getType());
						lpForNextRound.setAvatar(linkedPerson.getAvatar());
						lpForNextRound.setName(linkedPerson.getName());

						// person is older
						lpForNextRound.setAge(linkedPerson.getAge() + 1);
						lpForNextRound.setRoundNo(actualTime + 1);

						ppzService.createLinkedPerson(lpForNextRound);

					}

				}
			}

//			Game updatedGame = ppzService.getGame(gameCode);
//			gameCode.setGame(updatedGame);

		}

		actualTime += 1;
		
		Game updatedGame = ppzService.getGame(gameCode);

		// set avatar older
		Avatar avatar = updatedGame.getAvatar();
		avatar.setAge(avatar.getAge() + 1);
		ppzService.updateAvatar(avatar);
		
		// increase round
		updatedGame.setRoundPlayed(actualTime);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(updatedGame.getActualDate());
		cal.add(Calendar.MONTH, 1);
		
		updatedGame.setActualDate(cal.getTime());
		
		ppzService.updateGame(updatedGame);

		gameCode.setGame(updatedGame);
		
		return gameCode;

	}

	private Boolean chceckAges(Integer eventFrom, Integer eventTo, Long objectAgeInMonths) {

		if (objectAgeInMonths == null) {
			return Boolean.FALSE;
		}

		Double objectAge = objectAgeInMonths / (double) 12;

		// if we have lower bound
		if (eventFrom != null) {
			if (objectAge < eventFrom) {
				return Boolean.FALSE;
			}
		}

		// if we have upper bound
		if (eventTo != null) {
			if (objectAge > eventTo) {
				return Boolean.FALSE;
			}
		}

		return Boolean.TRUE;
	}

}
