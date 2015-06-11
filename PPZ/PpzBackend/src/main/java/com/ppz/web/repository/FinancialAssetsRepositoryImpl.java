package com.ppz.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ppz.web.entity.Avatar;
import com.ppz.web.entity.FinancialAssets;

/**
 * Implementace repository FinancialAssets.
 *
 * @author Honza
 */
@Repository(value = "financialAssetsRepository")
public class FinancialAssetsRepositoryImpl extends AbstractRepository<FinancialAssets> implements FinancialAssetsRepository {

	/**
	 * Creates the financial assets.
	 */
	@Override
	public void createFinancialAssets(final FinancialAssets financialAssets) {
		create(financialAssets);
	}

	/**
	 * Update financial assets.
	 * 
	 * @return the financial assets
	 */
	@Override
	public FinancialAssets updateFinancialAssets(final FinancialAssets financialAssets) {
		update(financialAssets);
		return financialAssets;
	}

	/**
	 * Gets the financial assets by avatar.
	 *
	 * @return the financial assets by avatar
	 */
	@Override
	public List<FinancialAssets> getFinancialAssetsByAvatar(final Avatar avatar) {

		final Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("avatar", avatar);

		final List<FinancialAssets> results = loadByFilter(filter, FinancialAssets.class);
		if (results.size() != 0) {
			return results;
		} else {
			return null;
		}
	}

}
