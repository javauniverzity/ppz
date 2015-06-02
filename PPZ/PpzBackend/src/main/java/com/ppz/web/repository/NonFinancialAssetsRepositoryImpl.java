package com.ppz.web.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ppz.web.entity.Avatar;
import com.ppz.web.entity.NonFinancialAssets;

/**
 * Implementace repository NonFinancialAssets (nefinanci aktiva)
 * @author pc
 *
 */
@Repository(value = "nonFinancialAssetsRepository")
public class NonFinancialAssetsRepositoryImpl extends AbstractRepository<NonFinancialAssets> implements NonFinancialAssetsRepository {

	/**
	 * Dej seznam vsech nefinancich aktiv podle avataru
	 */
	@Override
	public List<NonFinancialAssets> getNonFinancialAssetsListByAvatar(Avatar avatar) {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<NonFinancialAssets> crit = criteriaBuilder.createQuery(NonFinancialAssets.class);
		final Root<NonFinancialAssets> from = crit.from(NonFinancialAssets.class);
		crit.select(from).where(criteriaBuilder.equal(from.get("avatar"),avatar));
		
		List<NonFinancialAssets> results = entityManager.createQuery(crit).getResultList();

		if (results.size() != 0) {
			return results;
		} else {
			return null;
		}
	}
	
	/**
	 * Vytvor nove aktivum
	 */
	@Override
	public void createNonFinancialAssets(NonFinancialAssets nonFinancialAssets) {
		create(nonFinancialAssets);
	}

	/**
	 * Smaz aktivum
	 */
	@Override
	public NonFinancialAssets updateNonFinancialAssets(NonFinancialAssets nonFinancialAssets) {
		update(nonFinancialAssets);
		return nonFinancialAssets;
	}

}
