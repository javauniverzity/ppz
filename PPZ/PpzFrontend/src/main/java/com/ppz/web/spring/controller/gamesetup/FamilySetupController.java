package com.ppz.web.spring.controller.gamesetup;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ppz.web.entity.Avatar;
import com.ppz.web.entity.GameCode;
import com.ppz.web.entity.LinkedPerson;
import com.ppz.web.interfaces.service.PpzService;
import com.ppz.web.utils.WebUtils;

/**
 * Controller stránek pro správu rodiny.
 * @author Marek
 */
@Controller
@SessionAttributes(value="linkedPerson")
public class FamilySetupController {

	/** url pro editaci rodiny */
	public static final String ACTION = "familySetup";
	
	/** url pro pøidání èlena rodiny */
	public static final String ACTION_ADD = "familySetupAdd";
	
	/** url pro odtranìní èlena rodiny. */
	public static final String ACTION_REMOVE = "familySetupRemove";
	
	/** url pro pøesmìrování. */
	public static final String REDIRECT = "redirect:" + ACTION + ".html";
	
	/** The ppz service. */
	@Autowired
	PpzService ppzService;

	/**
	 * Zobrazeni stranky pro spravu clenu rodiny.
	 *
	 */
	@RequestMapping(value = ACTION, method = RequestMethod.GET)
	public String get(ModelMap model, HttpServletRequest request) {
		
		Avatar avatar = null;
		
		GameCode gameCode = WebUtils.getGameCode(request);
		if (gameCode != null) {
			if (gameCode.getGame() != null && gameCode.getGame().getAvatar() != null) {
				avatar = gameCode.getGame().getAvatar();
				model.addAttribute("avatar", avatar);
			}			
		}
		
		Long round = gameCode.getGame().getRoundPlayed();
		List<LinkedPerson> linkedPersons = ppzService.getLinkedPersonByAvatar(gameCode.getGame().getAvatar(), round);
		
		if (linkedPersons != null && gameCode != null) {
			model.addAttribute("family", linkedPersons);
		}	
		
		model.addAttribute("linkedPerson", "");
		
		return ACTION;
	}
	
	/**
	 * Priprava pro zalozeni noveho avatara, ten se vrati do obrazovky k vyplneni hodnot uzivatelem.
	 *
	 */
	@RequestMapping(value = ACTION_ADD, method = RequestMethod.GET)
	public String add(ModelMap model, HttpServletRequest request) {
		GameCode gameCode = WebUtils.getGameCode(request);

		Long round = gameCode.getGame().getRoundPlayed();
		List<LinkedPerson> linkedPersons = ppzService.getLinkedPersonByAvatar(gameCode.getGame().getAvatar(), round);
		LinkedPerson linkedPerson = null;
		if (linkedPersons != null) { 
			for (LinkedPerson person : linkedPersons) {
				if (LinkedPerson.PERSON_TYPE_DOG.equals(person.getType())) {
					linkedPerson = person;	
				}
			}
		}
		if (linkedPerson == null) {
			linkedPerson = new LinkedPerson();
			linkedPerson.setAvatar(gameCode.getGame().getAvatar());
		}
		model.addAttribute("linkedPerson", linkedPerson);
		
		return ACTION;
	}

	/**
	 * Uložení nového èlena rodiny
	 *
	 */
	@RequestMapping(value = ACTION_ADD, method = RequestMethod.POST)
	public String addSubmit(@ModelAttribute  LinkedPerson person, BindingResult result, ModelMap model, HttpServletRequest request) {
//        if (result.hasErrors()) {
//        	model.addAttribute("avatar", avatar);
//        	return ACTION;
//        }
		
		// TODO Tady se bude vytvaret typ podle toho co prijde. Pro demo se ale vytvari jen pes
		if (person.getType() == null) {
			person.setType(LinkedPerson.PERSON_TYPE_DOG);
		}
		if (person.getAge() == null) {
			person.setAge(0L);
		} 
		
		GameCode gameCode = WebUtils.getGameCode(request);
		
		person.setRoundNo(gameCode.getGame().getRoundPlayed());
        ppzService.createLinkedPerson(person);
		return REDIRECT;
	}

	/**
	 * Smazání èlena rodiny.
	 *
	 */
	@RequestMapping(value = ACTION_REMOVE, method = RequestMethod.GET)
	public String remove(@RequestParam(value = "id") Long id, HttpServletRequest request) {
		LinkedPerson lp = ppzService.getLinkedPerson(id);
		GameCode gameCode = WebUtils.getGameCode(request);
		if (lp.getAvatar().getAvatarId().equals(gameCode.getGame().getAvatar().getAvatarId())) {
			ppzService.deleteLinkedPerson(lp);
		}
		return REDIRECT;
	}
	
	/**
	 * Editace èlena rodiny.
	 *
	 */
	public String edit(String id, String name) {
		LinkedPerson lp = ppzService.getLinkedPerson(Long.parseLong(id));
		lp.setName(name);
		ppzService.updateLinkedPerson(lp);
		return id;
	}
}