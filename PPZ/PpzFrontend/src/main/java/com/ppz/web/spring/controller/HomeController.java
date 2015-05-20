package com.ppz.web.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Zobrazeni home stranky
 * 
 * @author Pavel Lukes
 *
 */

@Controller
@RequestMapping(HomeController.ACTION)
public class HomeController {

	public static final String ACTION = "home";
	public static final String REDIRECT = "redirect:" + ACTION + ".html";
	
	Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String get(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		return ACTION;
	}	


}