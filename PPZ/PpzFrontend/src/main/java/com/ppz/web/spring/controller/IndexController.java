package com.ppz.web.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Index.
 *
 * @author David
 */

@Controller
@RequestMapping(IndexController.ACTION)
public class IndexController {
	
	/** Konstanta ACTION. */
	public static final String ACTION = "index";
	
	/** Konstanta REDIRECT. */
	public static final String REDIRECT = "redirect:" + ACTION + ".html";
	
	/**
	 * Metoda Get
	 *
	 * @return the string
	 * @throws Exception vyjimka
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get() throws Exception {
		return ACTION;
	}
}
