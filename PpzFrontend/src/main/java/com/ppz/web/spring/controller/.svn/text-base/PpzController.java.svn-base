package com.ppz.web.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ppz.web.entity.FinancialAssets;
import com.ppz.web.entity.Game;
import com.ppz.web.entity.GameCode;
import com.ppz.web.entity.LinkedPerson;
import com.ppz.web.service.PpzService;
import com.ppz.web.service.UserService;
import com.ppz.web.spring.entity.FormattedAvatar;
import com.ppz.web.spring.entity.FormattedGame;
import com.ppz.web.utils.WebUtils;

/**
 * Stranka PPZ
 * 
 * @author Pavel Lukes
 *
 */

@Controller
@RequestMapping(PpzController.ACTION)
public class PpzController {
	
	public static final String ACTION = "ppz";
	public static final String REDIRECT = "redirect:" + ACTION + ".html";
	
	@Autowired
	UserService userService;
	
	@Autowired
	PpzService ppzService;
	
	Logger logger = Logger.getLogger(PpzController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String get(HttpServletRequest request, HttpServletResponse res, ModelMap model) throws Exception {
		GameCode gameCode = WebUtils.getGameCode(request);
		if (gameCode != null) {

			Game game = gameCode.getGame();
			model.addAttribute("avatar", game.getAvatar());
			
			// avatar s naformatovanymi polozkami
			FormattedGame fGame = new FormattedGame(game);
			model.addAttribute("game", fGame);

			// avatar s naformatovanymi polozkami
			FormattedAvatar fAvatar = new FormattedAvatar(game.getAvatar());
			model.addAttribute("fAvatar", fAvatar);

			Long round = gameCode.getGame().getRoundPlayed();
			List<LinkedPerson> linkedPersons = ppzService.getLinkedPersonByAvatar(gameCode.getGame().getAvatar(), round);
			if (linkedPersons != null) {
				model.addAttribute("family", linkedPersons);
			}

			List<FinancialAssets> financialAssets = ppzService.getFinancialAssetsByAvatar(game.getAvatar());
			model.addAttribute("products", financialAssets);
		}		
		// TODO vyresit stav kdy gamecode nebo game ci avatar neexistuje
		
		
		return ACTION;
	}

}