package com.ppz.web.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Index
 * 
 * @author Pavel Lukes
 *
 */

@Controller
@RequestMapping(IndexController.ACTION)
public class IndexController {
	
	public static final String ACTION = "index";
	public static final String REDIRECT = "redirect:" + ACTION + ".html";
	
	@RequestMapping(method = RequestMethod.GET)
	public String get() throws Exception {
		return ACTION;
	}
}
