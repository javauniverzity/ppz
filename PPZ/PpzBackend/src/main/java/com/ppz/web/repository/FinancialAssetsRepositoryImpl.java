package com.ppz.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ppz.web.entity.Avatar;
import com.ppz.web.entity.FinancialAssets;

/**
 * Implementace repository FinancialAssets
 * @author David
 *
 */
@Repository(value = "financialAssetsRepository")
public class FinancialAssetsRepositoryImpl extends AbstractRepository<FinancialAssets> implements FinancialAssetsRepository {

	/**
	 * Vytvori FinancialAssets
	 */
	@Override
	public void createFinancialAssets(FinancialAssets financialAssets) {
		create(financialAssets);
	}
	
	/**
	 * Aktualizuje FinancialAssets
	 */
	@Override
	public FinancialAssets updateFinancialAssets(FinancialAssets financialAssets) {
		update(financialAssets);
		return financialAssets;
	}

	/**
	 * Da seznam FinancialAssests podle Avataru
	 */
	@Override
	public List<FinancialAssets> getFinancialAssetsByAvatar(Avatar avatar) {

		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("avatar", avatar);
		
		List<FinancialAssets> results = loadByFilter(filter, FinancialAssets.class);
		if (results.size() != 0) {
			return  results;
		} else {
			return null;
		}
	}


}
