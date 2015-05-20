package com.ppz.web.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Stranka s prihlasenim
 * 
 * @author Pavel Lukes
 *
 */

@Controller
@RequestMapping(LoginController.ACTION)
public class LoginController {
	
	public static final String ACTION = "login";
	public static final String REDIRECT = "redirect:" + ACTION + ".html";
	
	@RequestMapping(method = RequestMethod.GET)
	public String get() throws Exception {
		return ACTION;
	}
}
