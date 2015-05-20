package com.ppz.web.spring.controller.gamesetup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ppz.web.spring.controller.AdminController;

@Controller
@RequestMapping(AdminController.ACTION)
public class PropertySetupController {

	public static final String ACTION = "budgetSetup";
	public static final String REDIRECT = "redirect:" + ACTION + ".html";

}