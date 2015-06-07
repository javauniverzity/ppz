package com.ppz.web.spring.entity;

import com.ppz.web.entity.Avatar;
import com.ppz.web.utils.AvatarUtils;

/**
 * Nastavi parametry avatara
 * @author David
 *
 */
public class FormattedAvatar {

	Avatar avatar;
	String incomes = "";
	String outcomes = "";
	
	public FormattedAvatar(Avatar avatar) {
		this.avatar = avatar;
		this.incomes = AvatarUtils.getFormattedIncomes(avatar);
		this.outcomes = AvatarUtils.getFormattedOutcomes(avatar);
	}

	/**
	 * Dej prijmy
	 *
	 * @return prijmy
	 */
	public String getIncome() {
		if (avatar == null) {
			return "0";
		}
		return AvatarUtils.getFormattedIncomes(avatar);
	}
	
	/**
	 * Dej vydaje
	 * 
	 * @return vydaje
	 */
	public String getOutcome() {
		if (avatar == null) {
			return "0";
		}
		return AvatarUtils.getFormattedOutcomes(avatar);
	}

	/**
	 * Dej rozdil mezi prijmy a vydaji
	 * @return rozdil
	 */
	public String getDistinct() {
		if (avatar == null || avatar.getIncome() == null) {
			return "0";
		}
		return AvatarUtils.getFormattedDistinct(avatar);
	}
}