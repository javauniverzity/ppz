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
import com.ppz.web.interfaces.service.PpzService;
import com.ppz.web.spring.controller.PpzController;
import com.ppz.web.utils.WebUtils;

/**
 * The Class AvatarSetupController.
 * 
 * @author Honza
 */
@Controller
@RequestMapping(AvatarSetupController.ACTION)
@SessionAttributes(types = Avatar.class, value = "avatar")
public class AvatarSetupController {

	/** The Constant ACTION. */
	public static final String ACTION = "avatarSetup";

	/** The Constant REDIRECT. */
	public static final String REDIRECT = "redirect:" + ACTION + ".html";

	/** The ppz service. */
	@Autowired
	PpzService ppzService;

	/**
	 * Zobrazeni stranky pro nastaveni avatara.
	 *
	 * @param model
	 *            the model
	 * @param request
	 *            the request
	 * @return the string
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(final ModelMap model, final HttpServletRequest request) {

		Avatar avatar = null;

		final GameCode gameCode = WebUtils.getGameCode(request);
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
	 * new avatar.
	 *
	 * @param avatar
	 *            the avatar
	 * @param result
	 *            the result
	 * @param model
	 *            the model
	 * @param request
	 *            the request
	 * @return the string
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String addSubmit(@ModelAttribute final Avatar avatar, final BindingResult result, final ModelMap model, final HttpServletRequest request) {
		if (result.hasErrors()) {
			model.addAttribute("avatar", avatar);
			return ACTION;
		}

		// vezmeme ze session gameCode
		final GameCode gameCode = WebUtils.getGameCode(request);
		// pomoci gameCode najdeme hru
		final Game game = gameCode.getGame();
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