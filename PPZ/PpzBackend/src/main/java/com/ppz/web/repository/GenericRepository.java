package com.ppz.web.repository;

import java.util.List;

/**
 * Generic repository definuje zakladni CRUD operace
 * @author David
 */
public interface GenericRepository<T> {

//	public Class<T> getType();
	

	/**
	 * Vytvori a ulozi objekt
	 * 
	 * @param o - objekt do persist
	 */
	public void create(T o);

	/**
	 * Dej objekt podle Id
	 * 
	 * @return objekt podle Id
	 */
	public T loadById(final Class<T> clazz, Long id);

	/**
	 * Aktualizuje zmeny entity
	 * 
	 * @param o - zmeneny objekt do persist
	 */
	public void update(T o);

	/**
	 * Smaze entitu
	 * 
	 * @param o - objekt do delete
	 */
	public void delete(T o);

	//
	// Dodatecne operace
	//
	/**
	 * Dej seznam vsech entit
	 * 
	 * @return seznam entit
	 */
	public List<T> loadAll(final Class<T> clazz);

}