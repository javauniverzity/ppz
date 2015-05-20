package com.ppz.web.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class Enums {
	
	@Autowired
	static MessageSource messageSource;
	
	public static enum FinancialAssetsEnum {
		SAVINGS_ACCOUNT("enum.financialassets.1", 1),
		INVESTMENT_EQUITY_FUND("enum.financialassets.3", 3);
		
		 private int code;
		 private String name;

		 private FinancialAssetsEnum(String name, int code) {
			 this.name = name;
			 this.code = code;
		 }

		 public int getCode() {
		   return code;
		 }
		 public String getName() {
			 return messageSource.getMessage(name, null, LocaleContextHolder.getLocale());
		 }
	}
}
