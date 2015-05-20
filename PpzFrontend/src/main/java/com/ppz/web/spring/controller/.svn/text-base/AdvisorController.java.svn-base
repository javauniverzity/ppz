package com.ppz.web.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ppz.web.service.PpzService;
import com.ppz.web.service.UserService;

/**
 * Stranka pro poradce, vytvareni kodu her
 * 
 * @author Pavel Lukes
 * 
 */

@Controller
@RequestMapping(AdvisorController.ACTION)
public class AdvisorController {

	public static final String ACTION = "advisor";
	public static final String REDIRECT = "redirect:" + ACTION + ".html";

	@Autowired
	UserService userService;

	@Autowired
	PpzService ppzService;

	Logger logger = Logger.getLogger(AdvisorController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String get(HttpServletRequest request, HttpServletResponse res, ModelMap model) throws Exception {
		// TODO stranka by mela mit moznost vytvaret herni kody, ke kazdemu se pak jeste vytvori uzivatel, ktery se kodem prihlasi
		
		return ACTION;
	}

}