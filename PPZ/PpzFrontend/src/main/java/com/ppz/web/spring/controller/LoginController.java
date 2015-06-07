package com.ppz.web.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Stranka s prihlasenim - login.
 *
 * @author David
 */

@Controller
@RequestMapping(LoginController.ACTION)
public class LoginController {
	
	/** Konstanta ACTION. */
	public static final String ACTION = "login";
	
	/** Konstanta REDIRECT. */
	public static final String REDIRECT = "redirect:" + ACTION + ".html";
	
	/**
	 * Metoda Get.
	 *
	 * @return the string
	 * @throws Exception vyjimka
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get() throws Exception {
		return ACTION;
	}
}
