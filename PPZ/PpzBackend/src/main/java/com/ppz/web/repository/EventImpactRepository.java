package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.EventImpact;
import com.ppz.web.entity.PossibleEvent;

/**
 * REPOSITORY interface for EventImpact entity specific methods
 * 
 * 
 * 
 */
public interface EventImpactRepository extends GenericRepository<EventImpact> {

	// no Event Impact specific methods
	
	List<EventImpact> getEventImpactListByPossibleEvent(PossibleEvent possibleEvent);

}