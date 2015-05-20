package com.ppz.web.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public abstract class AbstractRepository<T> implements GenericRepository<T> {

	Logger logger = Logger.getLogger(AbstractRepository.class);

	@PersistenceContext
	protected EntityManager entityManager;

	@Transactional(readOnly = false)
	public void create(final T o) {
		logger.info("persist " + o);
		entityManager.persist(o);
	}

	@Transactional(readOnly = false)
	public void delete(final T o) {
		logger.info("remove " + o);
		entityManager.remove(o);
	}

	@Transactional(readOnly = false)
	public void update(final T o) {
		logger.info("update " + o);
		// openSession().update(o);
		entityManager.merge(o);
	}

	public List<T> findByCriteria(final CriteriaQuery<T> crit) {
		logger.info("findByCriteria " + crit);
		return entityManager.createQuery(crit).getResultList();
	}

	public List<T> findByCriteria(final CriteriaQuery<T> crit, final int min, final int max) {
		logger.info("findByCriteria " + crit + " min:" + min + " max:" + max);
		return entityManager.createQuery(crit).setFirstResult(min).setMaxResults(max).getResultList();

	}

	public List<T> loadAll(final Class<T> clazz) {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<T> crit = criteriaBuilder.createQuery(clazz);
		final Root<T> from = crit.from(clazz);
		crit.select(from);
		final List<T> results = findByCriteria(crit);
		return results;
	}

	public T loadById(final Class<T> clazz, Long id) {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("id", id);
		List<T> result =  loadByFilter(filter, null, null, clazz);
		if (result.size() == 1) {
			return result.get(0);
		}
		return null;
	}

	public List<T> loadByFilter(final Map<String, Object> filter, final Class<T> clazz) {
		return loadByFilter(filter, null, null, clazz);
	}

	public List<T> loadByFilter(final Map<String, Object> filterEq,	final Map<String, Object> filterGt,	final Map<String, Object> filterLt, final Class<T> clazz) {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<T> crit = criteriaBuilder.createQuery(clazz);
		final Root<T> from = crit.from(clazz);
		crit.select(from);
		final List<Predicate> predicate = new ArrayList<Predicate>();

		if (filterEq != null) {
			for (final Entry<String, Object> e : filterEq.entrySet()) {
				predicate.add(criteriaBuilder.equal(from.get(e.getKey()),e.getValue()));
			}
		}
		if (filterGt != null) {
			for (final Entry<String, Object> e : filterGt.entrySet()) {
				predicate.add(criteriaBuilder.gt(from.<Number> get(e.getKey()),	(Number) e.getValue()));
			}
		}
		if (filterLt != null) {
			for (final Entry<String, Object> e : filterLt.entrySet()) {
				predicate.add(criteriaBuilder.lt(from.<Number> get(e.getKey()),	(Number) e.getValue()));
			}
		}
		if (predicate.size() > 0) {
			crit.where(predicate.toArray(new Predicate[0]));
		}
		final List<T> results = findByCriteria(crit);
		return results;
	}


}
