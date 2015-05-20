package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.Advisor;

/**
 * REPOSITORY interface for object for entity Advisor
 * 
 * @author Petr Hirs
 * 
 */
public interface AdvisorRepository  {

	/**
	 * Create and save Advisor entity
	 * @param advisor - object to persist
	 */
	void createAdvisor(Advisor advisor);

	/**
	 * Get list of all advisors
	 */
	List<Advisor> getAdvisorList();
	
}