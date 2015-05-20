package com.ppz.web.spring.controller.gamesetup;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ppz.web.entity.Avatar;
import com.ppz.web.entity.Game;
import com.ppz.web.entity.GameCode;
import com.ppz.web.service.PpzService;
import com.ppz.web.spring.controller.PpzController;
import com.ppz.web.utils.WebUtils;

@Controller
@RequestMapping(AvatarSetupController.ACTION)
@SessionAttributes(types = Avatar.class, value = "avatar")
public class AvatarSetupController {

	public static final String ACTION = "avatarSetup";
	public static final String REDIRECT = "redirect:" + ACTION + ".html";
	
	@Autowired
	PpzService ppzService;

	/**
	 * Zobrazeni stranky pro nastaveni avatara
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(ModelMap model, HttpServletRequest request) {
		
		Avatar avatar = null;
		
		GameCode gameCode = WebUtils.getGameCode(request);
		if (gameCode != null) {
			if (gameCode.getGame() != null && gameCode.getGame().getAvatar() != null) {
				avatar = gameCode.getGame().getAvatar();
			}
			
		}

		if (avatar == null) {
			avatar = new Avatar();
		}
		
		model.addAttribute("avatar", avatar);
		
		return ACTION;
	}


	/**
	 * Ulození nového avatara
	 * 
	 * @param avatar
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String addSubmit(@ModelAttribute Avatar avatar, BindingResult result, ModelMap model, HttpServletRequest request) {
        if (result.hasErrors()) {
        	model.addAttribute("avatar", avatar);
        	return ACTION;
        }
        
    	// vezmeme ze session gameCode
        GameCode gameCode = WebUtils.getGameCode(request);
    	// pomoci gameCode najdeme hru
    	Game game = gameCode.getGame();
    	// priradime avatara ke hre
    	game.setAvatar(avatar);
    	if (avatar.getAvatarId() == null) {
    		ppzService.createAvatar(avatar);
    	} else {
    		ppzService.updateAvatar(avatar);
    	}
        ppzService.updateGame(game);
		return PpzController.REDIRECT;
	}

}