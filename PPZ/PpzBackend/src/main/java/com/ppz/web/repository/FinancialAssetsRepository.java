package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.Avatar;
import com.ppz.web.entity.FinancialAssets;

/**
 * Repository pro entitu objektu FinancialAssets.
 *
 * @author Honnza
 */
public interface FinancialAssetsRepository extends GenericRepository<FinancialAssets> {

	/**
	 * Creates the financial assets.
	 */
	public void createFinancialAssets(FinancialAssets financialAssets);

	/**
	 * Update financial assets.
	 * 
	 * @return the financial assets
	 */
	public FinancialAssets updateFinancialAssets(FinancialAssets financialAssets);

	/**
	 * Gets the financial assets by avatar.
	 *
	 * @return the financial assets by avatar
	 */
	public List<FinancialAssets> getFinancialAssetsByAvatar(Avatar avatar);

}
