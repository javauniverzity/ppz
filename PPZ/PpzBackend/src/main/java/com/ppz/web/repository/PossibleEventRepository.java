package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.PossibleEvent;

/**
 * REPOSITORY interface for PossibleEvent entity specific methods
 * 
 * 
 * 
 */
public interface PossibleEventRepository extends GenericRepository<PossibleEvent> { 
	
	/**
	 * Possible events specified by root decision type
	 * 
	 * @param rootDecision - type of root decision
	 * @param decisionType - sub type of root decision
	 * 
	 * @return possible events for specified root decision
	 */
	List<PossibleEvent> getPossibleEventList(Integer rootDecision, Integer decisionType);
		
}