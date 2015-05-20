package com.ppz.web.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ppz.web.entity.User;
import com.ppz.web.service.PpzService;
import com.ppz.web.service.UserService;
import com.ppz.web.utils.UserUtils;

/**
 * prihlaseni pomoci kodu
 * 
 * @author Pavel Lukes
 *
 */

@Controller
@RequestMapping(DemoController.ACTION)
public class DemoController {
	
	public static final String ACTION = "demo";
	public static final String REDIRECT = "redirect:" + ACTION + ".html";
	
	@Autowired
	UserService userService;
	
	@Autowired
	PpzService ppzService;
	
	Logger logger = Logger.getLogger(DemoController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String get(HttpServletRequest request, HttpServletResponse res, ModelMap model) throws Exception {
		User user = userService.loadUserByUsername(UserUtils.getCurrentUsername());
		if ("Demo".equals(user.getUsername())) {
			model.addAttribute("demo", Boolean.TRUE);
		}
		
		return ACTION;
	}


}