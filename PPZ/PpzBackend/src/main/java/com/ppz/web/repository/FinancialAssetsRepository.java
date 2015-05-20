package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.Avatar;
import com.ppz.web.entity.FinancialAssets;

/**
 * REPOSITORY object for entity FinancialAssets.
 * 
 * 
 * 
 */
public interface FinancialAssetsRepository extends GenericRepository<FinancialAssets> {

	public void createFinancialAssets(FinancialAssets financialAssets);

	public FinancialAssets updateFinancialAssets(FinancialAssets financialAssets);

	public List<FinancialAssets> getFinancialAssetsByAvatar(Avatar avatar);

}
