package com.ppz.web.spring.controller.gamesetup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ppz.web.spring.controller.AdminController;

/**
 * The Class FinancialProductsSetupController.
 * 
 * @author Honza
 */
@Controller
@RequestMapping(AdminController.ACTION)
public class FinancialProductsSetupController {

	/** The Constant ACTION. */
	public static final String ACTION = "financialProductsSetup";

	/** The Constant REDIRECT. */
	public static final String REDIRECT = "redirect:" + ACTION + ".html";

}