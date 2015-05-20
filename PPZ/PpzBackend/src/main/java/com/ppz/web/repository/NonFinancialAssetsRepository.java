package com.ppz.web.repository;

import java.util.List;

import com.ppz.web.entity.Avatar;
import com.ppz.web.entity.NonFinancialAssets;

/**
 * REPOSITORY object for entity NonFinancialAssets.
 * 
 * 
 * 
 */
public interface NonFinancialAssetsRepository extends GenericRepository<NonFinancialAssets> {

	public void createNonFinancialAssets(NonFinancialAssets nonFinancialAssets);

	public NonFinancialAssets updateNonFinancialAssets(NonFinancialAssets nonFinancialAssets);

	public List<NonFinancialAssets> getNonFinancialAssetsListByAvatar(Avatar avatar);

}