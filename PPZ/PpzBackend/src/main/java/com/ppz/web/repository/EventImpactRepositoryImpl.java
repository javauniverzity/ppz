package com.ppz.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ppz.web.entity.EventImpact;
import com.ppz.web.entity.PossibleEvent;

/**
 * Implementace repository EventImpact
 * @author David
 *
 */
@Repository(value = "eventImpactRepository")
public class EventImpactRepositoryImpl extends AbstractRepository<EventImpact> implements EventImpactRepository {

	/**
	 *Vezme list udalosti a podle pravdepodobnosti urcitou vybere 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EventImpact> getEventImpactListByPossibleEvent(PossibleEvent possibleEvent) {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("possibleEvent", possibleEvent);
		@SuppressWarnings("rawtypes")
		List results = loadByFilter(filter, EventImpact.class);
		if (results.size() != 0) {
			return (List<EventImpact>) results;
		} else {
			return null;
		}
	}
}
