package com.ppz.web.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Zobrazeni home stranky.
 *
 * @author David
 */

@Controller
@RequestMapping(HomeController.ACTION)
public class HomeController {

	/** Konstanta ACTION. */
	public static final String ACTION = "home";
	
	/** Konstanta REDIRECT. */
	public static final String REDIRECT = "redirect:" + ACTION + ".html";
	
	/** The logger. */
	Logger logger = Logger.getLogger(HomeController.class);

	/**
	 * Gets the.
	 *
	 * @param request zadost
	 * @param response odpoved servletu
	 * @param model model
	 * @return the string
	 * @throws Exception vyjimka
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		return ACTION;
	}	
}