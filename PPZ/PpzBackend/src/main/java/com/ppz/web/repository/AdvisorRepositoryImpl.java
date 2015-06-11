package com.ppz.web.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ppz.web.entity.Advisor;

/**
 * Implementace repository advisor.
 *
 * @author Honza
 */
@Repository(value = "advisorRepository")
public class AdvisorRepositoryImpl extends AbstractRepository<Advisor> implements AdvisorRepository {

	@Override
	public void createAdvisor(final Advisor advisor) {
		create(advisor);
	}

	@Override
	public List<Advisor> getAdvisorList() {
		return loadAll(Advisor.class);
	}

}
