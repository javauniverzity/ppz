package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.Advisor;

/**
 * REPOSITORY interface pro objekt entity advisor
 * 
 * @author Honza
 */
public interface AdvisorRepository {

	/**
	 * Vytvori a ulozi entitu advisor
	 * 
	 * @param poradce
	 *            - objekt do persist
	 */
	void createAdvisor(Advisor advisor);

	/**
	 * Dej seznam vsech advisoru
	 */
	List<Advisor> getAdvisorList();

}