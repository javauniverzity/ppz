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
 * @author Honza
 *
 */
public class AvatarUtils {

	static Logger logger = Logger.getLogger(AvatarUtils.class);

	// TODO odstranit a prevest na globalni locale
	private static Locale loc = new Locale("cs", "CZ", "");

	/**
	 * Nastaveni formatu meny
	 * 
	 * @param avatar
	 * @return upravena penezni hodnota
	 */
	public static String getFormattedCurrency(final BigDecimal number) {
		final NumberFormat nf = NumberFormat.getNumberInstance(loc);
		final DecimalFormat df = (DecimalFormat) nf;
		df.applyPattern("###,###.###");
		return df.format(number);
	}

	/**
	 * Nastaveni financi avatara
	 * 
	 * @param avatar
	 * @return neformatovane financni prijmy avatara
	 */
	public static BigDecimal getIncomes(final Avatar avatar) {
		BigDecimal incomes = new BigDecimal("0");

		final List<BigDecimal> incomeItem = new ArrayList<BigDecimal>();
		incomeItem.add(avatar.getIncome());
		incomeItem.add(avatar.getOtherIncome());

		for (final BigDecimal income : incomeItem) {
			if (income != null) {
				incomes = incomes.add(income);
			}
		}

		return incomes;
	}

	/**
	 * @param avatar
	 * @return formatovane financni prijmy avatara
	 */
	public static String getFormattedIncomes(final Avatar avatar) {
		return AvatarUtils.getFormattedCurrency(AvatarUtils.getIncomes(avatar));
	}

	/**
	 * Nastaveni vydaju avatara
	 * 
	 * @param avatar
	 * @return neformatovane vydaje avatara
	 */
	public static BigDecimal getOutcomes(final Avatar avatar) {
		BigDecimal outcomes = new BigDecimal("0");

		final List<BigDecimal> outcomeItem = new ArrayList<BigDecimal>();
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

		for (final BigDecimal outcome : outcomeItem) {
			if (outcome != null) {
				outcomes = outcomes.add(outcome);
			}
		}

		return outcomes;
	}

	/**
	 * @param avatar
	 * @return formatovane vydaje avatara
	 */
	public static String getFormattedOutcomes(final Avatar avatar) {
		return AvatarUtils.getFormattedCurrency(AvatarUtils.getOutcomes(avatar));
	}

	/**
	 * Nastaveni zjisteni rozdilu mezi prijmy a vydaji
	 * 
	 * @param avatar
	 * @return neformatovane prijmy a vydaje a jejich rozdil
	 */
	public static BigDecimal getDistinct(final Avatar avatar) {
		final BigDecimal income = AvatarUtils.getIncomes(avatar);
		final BigDecimal outcome = AvatarUtils.getOutcomes(avatar);
		BigDecimal distinct = new BigDecimal("0");

		distinct = income.subtract(outcome);
		return distinct;
	}

	/**
	 * @param avatar
	 * @return formatovane prijmy a vydaje a jejich rozdil
	 */
	public static String getFormattedDistinct(final Avatar avatar) {
		return AvatarUtils.getFormattedCurrency(AvatarUtils.getDistinct(avatar));
	}

}
