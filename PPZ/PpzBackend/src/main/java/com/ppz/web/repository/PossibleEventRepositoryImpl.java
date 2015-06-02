package com.ppz.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ppz.web.entity.PossibleEvent;

/**
 * Implementace repository pro entitu PossibleEvent
 * @author David
 *
 */
@Repository(value = "possibleEventRepository")
public class PossibleEventRepositoryImpl extends AbstractRepository<PossibleEvent> implements PossibleEventRepository {

	public Class<PossibleEvent> getType() {
		return PossibleEvent.class;
	}

	/**
	 * Dej seznam moznych udalosti
	 */
	@Override
	public List<PossibleEvent> getPossibleEventList(Integer rootDecision, Integer decisionType) {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("rootDecision", rootDecision);
		filter.put("decisionType", decisionType);
		List<PossibleEvent> results = loadByFilter(filter, PossibleEvent.class);
		if (results.size() != 0) {
			return (List<PossibleEvent>) results;
		} else {
			return null;
		}
	}

}
