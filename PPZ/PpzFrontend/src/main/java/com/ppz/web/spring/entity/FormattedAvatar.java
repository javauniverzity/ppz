package com.ppz.web.spring.entity;

import com.ppz.web.entity.Avatar;
import com.ppz.web.utils.AvatarUtils;

public class FormattedAvatar {

	Avatar avatar;
	String incomes = "";
	String outcomes = "";
	
	public FormattedAvatar(Avatar avatar) {
		this.avatar = avatar;
		this.incomes = AvatarUtils.getFormattedIncomes(avatar);
		this.outcomes = AvatarUtils.getFormattedOutcomes(avatar);
	}

	public String getIncome() {
		if (avatar == null) {
			return "0";
		}
		return AvatarUtils.getFormattedIncomes(avatar);
	}
	
	public String getOutcome() {
		if (avatar == null) {
			return "0";
		}
		return AvatarUtils.getFormattedOutcomes(avatar);
	}

	public String getDistinct() {
		if (avatar == null || avatar.getIncome() == null) {
			return "0";
		}
		return AvatarUtils.getFormattedDistinct(avatar);
	}

	
}
