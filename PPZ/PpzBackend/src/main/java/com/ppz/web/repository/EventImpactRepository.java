package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.EventImpact;
import com.ppz.web.entity.PossibleEvent;

/**
 * Interface repository specifickych metod pro entitu EventImpact
 * 
 * @author Honza
 */
public interface EventImpactRepository extends GenericRepository<EventImpact> {

	// nejsou zadne specialni metody v EventImpact

	List<EventImpact> getEventImpactListByPossibleEvent(PossibleEvent possibleEvent);

}
