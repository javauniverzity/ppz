package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.Avatar;
import com.ppz.web.entity.NonFinancialAssets;

/**
 * Repository pro objekt entity NonFinancialassets.
 *
 * @author Honza
 */
public interface NonFinancialAssetsRepository extends GenericRepository<NonFinancialAssets> {

	/**
	 * Creates the non financial assets.
	 */
	public void createNonFinancialAssets(NonFinancialAssets nonFinancialAssets);

	/**
	 * Update non financial assets.
	 *
	 * @return the non financial assets
	 */
	public NonFinancialAssets updateNonFinancialAssets(NonFinancialAssets nonFinancialAssets);

	/**
	 * Gets the non financial assets list by avatar.
	 *
	 * @return the non financial assets list by avatar
	 */
	public List<NonFinancialAssets> getNonFinancialAssetsListByAvatar(Avatar avatar);

}
