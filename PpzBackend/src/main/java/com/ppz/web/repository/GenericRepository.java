package com.ppz.web.repository;

import java.util.List;

public interface GenericRepository<T> {

//	public Class<T> getType();
	
	//
	// Define basic CRUD operations
	//

	/**
	 * Create and save object
	 * 
	 * @param o - object to persist
	 */
	public void create(T o);

	/**
	 * Get object specified by id
	 * 
	 * @param id
	 * 
	 * @return object specified by id
	 */
	public T loadById(final Class<T> clazz, Long id);

	/**
	 * Update changed entity
	 * 
	 * @param o - object with changes to persist
	 */
	public void update(T o);

	/**
	 * Delete entity
	 * 
	 * @param o - object to delete
	 */
	public void delete(T o);

	//
	// Additional operations
	//
	/**
	 * Gel list of all entities 
	 * 
	 * @return list of entities
	 */
	public List<T> loadAll(final Class<T> clazz);

}