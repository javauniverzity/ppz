package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.PossibleEvent;

/**
 * Interface repository specifickych metod pro entitu PossibleEvent
 * @author David 
 */
public interface PossibleEventRepository extends GenericRepository<PossibleEvent> { 
	
	/**
	 * Mozne udalosti specifikovane dle stromu rozhodovani
	 * 
	 * @param rootDecision - typ stromu rozhodovani
	 * @param decisionType - sub type stromu rozhodovani
	 * 
	 * @return mozne udalosti pro specifikovane stromove rozhodnuti
	 */
	List<PossibleEvent> getPossibleEventList(Integer rootDecision, Integer decisionType);
		
}