package com.ppz.web.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;

import com.ppz.web.entity.Avatar;

/**
 * Pomocna trida pro avatara
 * 
 * @author Jan Machacek
 *
 */
public class AvatarUtils {
	
	static Logger logger = Logger.getLogger(AvatarUtils.class);
	
	// TODO odstranit a prevest na globalni locale
	private static Locale loc = new Locale("cs", "CZ", "");
	
	/**
	 * @param avatar
	 * @return formatted currency value
	 */
	public static String getFormattedCurrency(BigDecimal number) {
		NumberFormat nf = NumberFormat.getNumberInstance(loc);
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("###,###.###");
		return df.format(number);
	}
	
	/**
	 * @param avatar
	 * @return unformatted avatar income sum
	 */
	public static BigDecimal getIncomes(Avatar avatar) {
		BigDecimal incomes = new BigDecimal("0");
		
		List<BigDecimal> incomeItem = new ArrayList<BigDecimal>();
		incomeItem.add(avatar.getIncome());
		incomeItem.add(avatar.getOtherIncome());
		
		for (BigDecimal income : incomeItem) {
			if(income != null) {
				incomes = incomes.add(income);
			}
		}
		
		return incomes;
	}
	
	/**
	 * @param avatar
	 * @return formatted avatar incomes sum
	 */
	public static String getFormattedIncomes(Avatar avatar) {
		return AvatarUtils.getFormattedCurrency(AvatarUtils.getIncomes(avatar));
	}
	
	/**
	 * @param avatar
	 * @return unformatted avatar outcome sum
	 */
	public static BigDecimal getOutcomes(Avatar avatar) {
		BigDecimal outcomes = new BigDecimal("0");
		
		List<BigDecimal> outcomeItem = new ArrayList<BigDecimal>();
		outcomeItem.add(avatar.getLeaseCosts());
		outcomeItem.add(avatar.getEnergyCosts());
		outcomeItem.add(avatar.getFoodCosts());
		outcomeItem.add(avatar.getFreeTimeCosts());
		outcomeItem.add(avatar.getTrafficCosts());
		outcomeItem.add(avatar.getClothesCosts());
		outcomeItem.add(avatar.getVacationCosts());
		outcomeItem.add(avatar.getPhoneCosts());
		outcomeItem.add(avatar.getSmokeCosts());
		outcomeItem.add(avatar.getOtherCosts());
		
		for (BigDecimal outcome : outcomeItem) {
			if(outcome != null) {
				outcomes = outcomes.add(outcome);
			}
		}

		return outcomes;
	}
	
	/**
	 * @param avatar
	 * @return formatted avatar outcomes sum
	 */
	public static String getFormattedOutcomes(Avatar avatar) {
		return AvatarUtils.getFormattedCurrency(AvatarUtils.getOutcomes(avatar));
	}
	
	/**
	 * @param avatar
	 * @return unformatted incomes and outcomes distinct
	 */
	public static BigDecimal getDistinct(Avatar avatar) {
		BigDecimal income = AvatarUtils.getIncomes(avatar);
		BigDecimal outcome = AvatarUtils.getOutcomes(avatar);
		BigDecimal distinct = new BigDecimal("0");
		
		distinct = income.subtract(outcome);
		return distinct;
	}
	
	/**
	 * @param avatar
	 * @return formatted incomes and outcomes distinct
	 */
	public static String getFormattedDistinct(Avatar avatar) {
		return AvatarUtils.getFormattedCurrency(AvatarUtils.getDistinct(avatar));
	}

}
