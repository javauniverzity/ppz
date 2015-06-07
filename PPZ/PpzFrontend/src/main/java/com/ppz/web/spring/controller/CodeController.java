package com.ppz.web.spring.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ppz.web.entity.Game;
import com.ppz.web.entity.GameCode;
import com.ppz.web.entity.User;
import com.ppz.web.interfaces.service.PpzService;
import com.ppz.web.interfaces.service.UserService;
import com.ppz.web.utils.WebUtils;

/**
 * prihlaseni pomoci kodu.
 *
 * @author David
 */

@Controller
@RequestMapping(CodeController.ACTION)
public class CodeController {
	
	/** Konstanta ACTION. */
	public static final String ACTION = "code";
	
	/** Konstanta REDIRECT. */
	public static final String REDIRECT = "redirect:" + ACTION + ".html";
	
	/** The user service. */
	@Autowired
	UserService userService;
	
	/** The ppz service. */
	@Autowired
	PpzService ppzService;
	
	/** The logger. */
	Logger logger = Logger.getLogger(CodeController.class);

	/**
	 *  
	 * zobrazeni stranky pro prihlaseni pomoci kodu .
	 *
	 * @param request zadost
	 * @param res odpoved servletu
	 * @param model model
	 * @return the string
	 * @throws Exception vyjimka
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(HttpServletRequest request, HttpServletResponse res, ModelMap model) throws Exception {
		return ACTION;
	}

	/**
	 *  
	 * prihlaseni uzivatele pomoci kodu hry.
	 *
	 * @param request zadost
	 * @param res odpoved servletu
	 * @param model model
	 * @param code kod
	 * @return the string
	 * @throws Exception vyjimka
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String post(HttpServletRequest request, HttpServletResponse res, ModelMap model, @RequestParam String code) throws Exception {
		
		GameCode gameCode = ppzService.getGameCode(code);
		if (gameCode == null) {
			WebUtils.setGameCode(request, null);
			return CodeController.REDIRECT;
		}

		
		User user = gameCode.getUser();
		// pokud uzivatel nebyl nalezen, vratime ho na login
		if (user == null) {
			WebUtils.setGameCode(request, null);
			return CodeController.REDIRECT;
		}

		// ulozime gamecode do session a prihlasime uzivatele
		WebUtils.setGameCode(request, gameCode);
        WebUtils.setUser(user);
		// pokud hra neexistuje, zalozime ji
		if (gameCode.getGame() == null) {
			Game game = new Game();
			game.setStatus(Game.GAME_STATUS_IN_PLAY);
			game.setActualDate(new Date());
			ppzService.createGame(game);
			gameCode.setGame(game);
			ppzService.updateGameCode(gameCode);
			
			// pokud zakladame novou hru, uzivatele navedeme na nastaveni avatara
			//return AvatarSetupController.REDIRECT;
			return SelectAvatarController.REDIRECT;
		}
		
		// pokud pokracuje v hrani hry, jde rovnou do ppz
		//return PpzController.REDIRECT;
		return SelectAvatarController.REDIRECT;
	
	}
	
	/**
	 * Autentifikace uzivatele podle uzivatelskeho jmena
	 *
	 * @param username uzivatelske jmeno
	 */
	public void authenticationUserByUsername(String username) {
	
	}

}