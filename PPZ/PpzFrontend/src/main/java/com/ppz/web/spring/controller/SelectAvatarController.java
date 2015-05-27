package com.ppz.web.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ppz.web.interfaces.service.PpzService;
import com.ppz.web.interfaces.service.UserService;

/**
 * prihlaseni pomoci kodu
 * 
 * @author Pavel Lukes
 *
 */

@Controller
@RequestMapping(SelectAvatarController.ACTION)
public class SelectAvatarController {
	
	public static final String ACTION = "selectavatar";
	public static final String REDIRECT = "redirect:" + ACTION + ".html";
	
	@Autowired
	UserService userService;
	
	@Autowired
	PpzService ppzService;
	
	Logger logger = Logger.getLogger(SelectAvatarController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String get(HttpServletRequest request, HttpServletResponse res, ModelMap model) throws Exception {
		return ACTION;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String post(HttpServletRequest request, HttpServletResponse res, ModelMap model, @RequestParam String avatar) throws Exception {
		return DemoController.REDIRECT;
	}

}