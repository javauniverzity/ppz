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
import com.ppz.web.interfaces.service.UserService;
import com.ppz.web.utils.UserUtils;

/**
 * Stranka Editace ?zatim nekonkretni.
 *
 * @author David
 */

@Controller
@RequestMapping(EditController.ACTION)
public class EditController {
	
	/** Konstanta ACTION. */
	public static final String ACTION = "edit";
	
	/** Konstanta REDIRECT. */
	public static final String REDIRECT = "redirect:" + ACTION + ".html";
	
	/** The user service. */
	@Autowired
	UserService userService;
	
	/** The logger. */
	Logger logger = Logger.getLogger(EditController.class);

	/**
	 * Nastaveni metody Get
	 *
	 * @param request zadost
	 * @param res odpoved servletu
	 * @param model model
	 * @return the string
	 * @throws Exception vyjimka
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(HttpServletRequest request, HttpServletResponse res, ModelMap model) throws Exception {
		User user = userService.loadUserByUsername(UserUtils.getCurrentUsername());
		model.addAttribute("user", user);
		return ACTION;
	}

}