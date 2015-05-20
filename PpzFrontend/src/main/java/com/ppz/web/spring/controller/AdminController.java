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
import com.ppz.web.service.PpzService;
import com.ppz.web.service.UserService;
import com.ppz.web.utils.UserUtils;

/**
 * Vytvoreni uvodnich objektu do DB
 * 
 * @author Pavel Lukes
 * 
 */

@Controller
public class AdminController {

	public static final String ACTION = "admin";
	public static final String ACTION_ADD_ADVISOR = "adminAddAdvisor";
	public static final String REDIRECT = "redirect:" + ACTION + ".html";

	@Autowired
	UserService userService;

	@Autowired
	PpzService ppzService;
	
	@Autowired
	GameCodeComponent gameCodeComponent;

	Logger logger = Logger.getLogger(AdminController.class);

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
			
//			// create some event probabilities
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
			
			// create event impacts
			
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
	
	@RequestMapping(value = AdminController.ACTION_ADD_ADVISOR, method = RequestMethod.POST)
	public String postAddAdvisor(@RequestParam("name") String name) {
		Advisor advisor = new Advisor();
		advisor.setName(name);
		ppzService.createAdvisor(advisor);
		
		return REDIRECT;
	}
	
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

	private EventImpact createEventImpact(Integer impactType, Long impactSize, Boolean insuredImpact, PossibleEvent po) {
		EventImpact ei = new EventImpact();
		ei.setType(impactType);
		ei.setImpactSize(impactSize);
		ei.setInsuredImpact(insuredImpact);
		ei.setPossibleEvent(po);
		
		return ei;
	}	
	
}