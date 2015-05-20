package com.ppz.web.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Hlavni stranka, ktera resi kam za jake situace uzivatele presmerovat
 * 
 * @author Pavel Lukes
 *
 */

@Controller
@RequestMapping(WebController.ACTION)
public class WebController {
	
	public static final String ACTION = "web";
	public static final String REDIRECT = "redirect:" + ACTION + ".html";
	
	Logger logger = Logger.getLogger("logwebfile");

	@RequestMapping(method = RequestMethod.GET)
	public String get(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("WebController: get");
		String result = PpzController.REDIRECT;
		return result;
	}
}
