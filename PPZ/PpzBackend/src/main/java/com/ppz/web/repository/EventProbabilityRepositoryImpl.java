package com.ppz.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ppz.web.entity.EventProbability;
import com.ppz.web.entity.PossibleEvent;

/**
 * Implementace repository EventProbability
 * @author David
 *
 */
@Repository(value = "eventProbabilityRepository")
public class EventProbabilityRepositoryImpl extends AbstractRepository<EventProbability> implements EventProbabilityRepository {

	/**
	 * Vem seznam pravdepodobnosti udalosti a vyber moznou udalost
	 */
	@Override
	public List<EventProbability> getEventProbabilityList(PossibleEvent possibleEvent) {

		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("possibleEvent", possibleEvent);
		
		List<EventProbability> results = loadByFilter(filter, EventProbability.class);
		if (results.size() != 0) {
			return results;
		} else {
			return null;
		}		
	}

}
