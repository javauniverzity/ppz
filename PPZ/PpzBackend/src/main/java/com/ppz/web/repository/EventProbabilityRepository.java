package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.EventProbability;
import com.ppz.web.entity.PossibleEvent;

/**
 * REPOSITORY interface for EventProbability entity specific methods
 * 
 * 
 * 
 */
public interface EventProbabilityRepository extends GenericRepository<EventProbability> {

	/**
	 * Get list of all Event Probability for specific possible Event
	 * 
	 * @param possibleEvent - specific possibleEvent
	 * 
	 * @return list of Event Probabilities
	 */
	List<EventProbability> getEventProbabilityList(PossibleEvent possibleEvent);

}
