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
 * Prihlaseni pomoci kodu.
 *
 * @author Honza
 */

@Controller
@RequestMapping(SelectAvatarController.ACTION)
public class SelectAvatarController {

	/** Konstanta ACTION. */
	public static final String ACTION = "selectavatar";

	/** Konstanta REDIRECT. */
	public static final String REDIRECT = "redirect:" + ACTION + ".html";

	/** The user service. */
	@Autowired
	UserService userService;

	/** The ppz service. */
	@Autowired
	PpzService ppzService;

	/** The logger. */
	Logger logger = Logger.getLogger(SelectAvatarController.class);

	/**
	 * Nastaveni metody get.
	 *
	 * @param request
	 *            zadost
	 * @param res
	 *            odpoved servletu
	 * @param model
	 *            model
	 * @return the string
	 * @throws Exception
	 *             vyjimka
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(final HttpServletRequest request, final HttpServletResponse res, final ModelMap model) throws Exception {
		return ACTION;
	}

	/**
	 * Nastaveni metody Post.
	 *
	 * @param request
	 *            zadost
	 * @param res
	 *            odpoved servletu
	 * @param model
	 *            model
	 * @param avatar
	 *            avatar
	 * @return the string
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String post(final HttpServletRequest request, final HttpServletResponse res, final ModelMap model, @RequestParam final String avatar) throws Exception {
		return DemoController.REDIRECT;
	}

}