package com.ppz.web.spring.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ppz.web.component.GameCodeComponent;
import com.ppz.web.entity.Advisor;
import com.ppz.web.entity.EventImpact;
import com.ppz.web.entity.EventProbability;
import com.ppz.web.entity.GameCode;
import com.ppz.web.entity.LinkedPerson;
import com.ppz.web.entity.PossibleEvent;
import com.ppz.web.entity.User;
import com.ppz.web.interfaces.service.PpzService;
import com.ppz.web.interfaces.service.UserService;
import com.ppz.web.utils.UserUtils;

/**
 * Vytvoreni uvodnich objektu do DB.
 *
 * @author David
 */

@Controller
public class AdminController {

	/** Konstanta ACTION. */
	public static final String ACTION = "admin";
	
	/** Konstanta ACTION_ADD_ADVISOR. */
	public static final String ACTION_ADD_ADVISOR = "adminAddAdvisor";
	
	/** Konstanta REDIRECT. */
	public static final String REDIRECT = "redirect:" + ACTION + ".html";

	/** The user service. */
	@Autowired
	UserService userService;

	/** The ppz service. */
	@Autowired
	PpzService ppzService;
	
	/** The game code component. */
	@Autowired
	GameCodeComponent gameCodeComponent;

	/** The logger. */
	Logger logger = Logger.getLogger(AdminController.class);

	/**
	 * Nastaveni komunikace kontroleru pomoci metody get
	 *
	 * @param request the request
	 * @param res the res
	 * @param model the model
	 * @return the string
	 * @throws Exception the exception
	 */
	@RequestMapping(value = AdminController.ACTION, method = RequestMethod.GET)
	public String get(HttpServletRequest request, HttpServletResponse res, ModelMap model) throws Exception {

		if (userService.loadUserByUsername("Admin") == null) {
			// admin
			User user = new User();
			user.setUsername("Admin");
			user.setPassword(UserUtils.getMd5Password(user, "admin"));
			user.setRoles(User.ROLE_ADMIN);
			userService.createUser(user);

		}		

		boolean eventsExist = false;
		List<PossibleEvent> events = ppzService.getPossibleEventList();
		if (events != null) {
			for (PossibleEvent event: events) {
				if ("Úmrtí psa".equals(event.getName())) {
					eventsExist = true;
					break;
				}
			}
		}
		if (!eventsExist) {
			PossibleEvent po = new PossibleEvent();
			//po.setPossibleEventId(possibleEventId);
			po.setRootDecision(PossibleEvent.POSSIBLE_EVENT_ROOT_DECISION_FAMILY);
			po.setDecisionType(LinkedPerson.PERSON_TYPE_DOG);
			po.setAssetsType(null);
			po.setName("Úmrtí psa");
			po.setNeedDecision(Boolean.FALSE);
			po.setStopper(Boolean.FALSE);
			ppzService.createPossibleEvent(po);
			
//			// vytvor vybranou pravdepodobnostni udalost
//			
			po = ppzService.getPossibleEvent(po.getPossibleEventId());
			
			EventProbability ep = null;
			ep = createEventProbability(0, 1, null, null, Double.valueOf(0.0001), po);
			ppzService.createEventProbability(ep);
			ep = createEventProbability(1, 2, null, null, Double.valueOf(0.0005), po);
			ppzService.createEventProbability(ep);
			ep = createEventProbability(2, 3, null, null, Double.valueOf(0.001), po);
			ppzService.createEventProbability(ep);
			ep = createEventProbability(3, null, null, null, Double.valueOf(0.2), po);
			ppzService.createEventProbability(ep);
			
			// vytvoreni dopadu udalossti
			
			po = ppzService.getPossibleEvent(po.getPossibleEventId());
			
			EventImpact ei = null;
			ei = createEventImpact(EventImpact.EVENT_IMPACT_TYPE_ENVIRONS_MINUS, 4L, Boolean.FALSE, po);
			ppzService.createEventImpact(ei);
			ei = createEventImpact(EventImpact.EVENT_IMPACT_TYPE_CHANGE_EXPENSES, 500L, Boolean.TRUE, po);
			ppzService.createEventImpact(ei);
		}
		
		List<GameCode> gameCodes = ppzService.getGameCodeList();
		
		model.addAttribute("gameCodes", gameCodes);
		
		List<Advisor> advisors = ppzService.getAdvisorList();
		model.addAttribute("advisors", advisors);
		
		return ACTION;
	}

	/**
	 * Nastaveni komunikace kontroleru pomoci metody Post.
	 *
	 * @param username uzivatelske jmeno
	 * @param advisorId Id poradce
	 * @return retezec
	 */
	@RequestMapping(value = AdminController.ACTION, method = RequestMethod.POST)
	public String post(@RequestParam("username") String username, @RequestParam("advisorId")String advisorId) {
		List<Advisor> advisors = ppzService.getAdvisorList();
		// TODO predelat na nacitani advisora podle ID
		for (Advisor advisor : advisors) {
			if (String.valueOf(advisor.getAdvisorId()).equals(advisorId)) {
				User user = new User();
				user.setUsername(username);
				user.setRoles(User.ROLE_USER);
				user.setPassword(UserUtils.getMd5Password(user, "password"));
				
				GameCode gameCode = new GameCode();
				gameCode.setAdvisor(advisor);
				gameCode.setAlreadyPlayedGamesCount(0L);
				gameCode.setAvailableGamesCount(300L);
				gameCode.setCreated(new Date());
				gameCode.setCode(gameCodeComponent.generateUniqueGameCode());
				gameCode.setLatestPlayedGameDate(new Date());
				
				gameCode.setUser(user);
				ppzService.createGameCode(gameCode);
				break;
			}
		}
		return REDIRECT;

	}
	
	/**
	 * Pridani poradce pomoci metody post
	 *
	 * @param name jmeno
	 * @return the string
	 */
	@RequestMapping(value = AdminController.ACTION_ADD_ADVISOR, method = RequestMethod.POST)
	public String postAddAdvisor(@RequestParam("name") String name) {
		Advisor advisor = new Advisor();
		advisor.setName(name);
		ppzService.createAdvisor(advisor);
		
		return REDIRECT;
	}
	
	/**
	 * Vytvoreni pravdepodobnosti udalosti.
	 *
	 * @param ageFrom od roku
	 * @param ageTo do roku
	 * @param valueFrom hodnota od
	 * @param valueTo hodnota do
	 * @param probability pravdepobnost
	 * @param po pravdepodobna udalost
	 * @return pravdepobona udalot
	 */
	private EventProbability createEventProbability(Integer ageFrom, Integer ageTo, BigDecimal valueFrom, BigDecimal valueTo, Double probability, PossibleEvent po) {
		EventProbability ep = new EventProbability();
		ep.setAgeFrom(ageFrom);
		ep.setAgeTo(ageTo);
		ep.setPossibleEvent(po);
		ep.setValueFrom(valueFrom);
		ep.setValueTo(valueTo);
		ep.setProbability(probability);
		return ep;
	}

	/**
	 * Vytvoreni dopadu udalosti
	 *
	 * @param impactType druh dopadu
	 * @param impactSize velikost dopadu
	 * @param insuredImpact pojisteny dopad
	 * @param po pravdepodobna udalost
	 * @return dopad udalosti
	 */
	private EventImpact createEventImpact(Integer impactType, Long impactSize, Boolean insuredImpact, PossibleEvent po) {
		EventImpact ei = new EventImpact();
		ei.setType(impactType);
		ei.setImpactSize(impactSize);
		ei.setInsuredImpact(insuredImpact);
		ei.setPossibleEvent(po);
		
		return ei;
	}	
	
}