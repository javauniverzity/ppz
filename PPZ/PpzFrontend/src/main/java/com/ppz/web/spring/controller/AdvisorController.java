package com.ppz.web.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ppz.web.interfaces.service.PpzService;
import com.ppz.web.interfaces.service.UserService;

/**
 * Stranka pro poradce, vytvareni kodu her.
 *
 * @author David
 */

@Controller
@RequestMapping(AdvisorController.ACTION)
public class AdvisorController {

	/** Konstanta ACTION. */
	public static final String ACTION = "advisor";
	
	/** Konstanta REDIRECT. */
	public static final String REDIRECT = "redirect:" + ACTION + ".html";

	/** The user service. */
	@Autowired
	UserService userService;

	/** The ppz service. */
	@Autowired
	PpzService ppzService;

	/** The logger. */
	Logger logger = Logger.getLogger(AdvisorController.class);

	/**
	 * Nastaveni metody Get.
	 *
	 * @param request zadost
	 * @param res reakce servletu
	 * @param model model
	 * @return the string
	 * @throws Exception vyjimka
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(HttpServletRequest request, HttpServletResponse res, ModelMap model) throws Exception {
		// TODO stranka by mela mit moznost vytvaret herni kody, ke kazdemu se pak jeste vytvori uzivatel, ktery se kodem prihlasi
		
		return ACTION;
	}

}