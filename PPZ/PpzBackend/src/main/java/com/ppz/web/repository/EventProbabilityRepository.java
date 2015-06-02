package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.EventProbability;
import com.ppz.web.entity.PossibleEvent;

/**
 * Interface repository specifickych metod pro entitu EventProbability
 * @author David 
 */
public interface EventProbabilityRepository extends GenericRepository<EventProbability> {

	/**
	 * Dej seznam vsech EventProbability pro specifickou moznost udalosti
	 */
	List<EventProbability> getEventProbabilityList(PossibleEvent possibleEvent);

}
