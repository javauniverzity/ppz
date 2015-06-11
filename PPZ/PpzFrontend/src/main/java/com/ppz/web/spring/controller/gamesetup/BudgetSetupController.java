package com.ppz.web.spring.controller.gamesetup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ppz.web.spring.controller.AdminController;

/**
 * The Class BudgetSetupController.
 * 
 * @autor Honza
 */
@Controller
@RequestMapping(AdminController.ACTION)
public class BudgetSetupController {

	/** The Constant ACTION. */
	public static final String ACTION = "propertySetup";

	/** The Constant REDIRECT. */
	public static final String REDIRECT = "redirect:" + ACTION + ".html";

}