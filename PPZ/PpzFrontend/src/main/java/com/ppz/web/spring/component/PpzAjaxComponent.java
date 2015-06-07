package com.ppz.web.spring.component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ppz.web.component.KomendiusComponent;
import com.ppz.web.entity.Game;
import com.ppz.web.entity.GameCode;
import com.ppz.web.entity.LinkedPerson;
import com.ppz.web.entity.PossibleEvent;
import com.ppz.web.interfaces.service.PpzService;
import com.ppz.web.interfaces.service.UserService;
import com.ppz.web.spring.entity.FormattedAvatar;
import com.ppz.web.spring.entity.FormattedGame;
import com.ppz.web.utils.PpzExclusionStrategy;
import com.ppz.web.utils.WebUtils;

/**
 * Trida PpzAjaxComponent.
 */
@Component(value = "ppzAjaxComponent")
public class PpzAjaxComponent {
	
	/** Nastaveni sporiciho uctu. */
	private BigDecimal sporUcetBallance = new BigDecimal("354221");
	
	/** Nastaveni typu hodnoty hypoteka. */
	private BigDecimal hypotekaBallance = new BigDecimal("-2132556");
	
	/** Nataveni typu hodnoty spotrebitelsky uver. */
	private BigDecimal spotrUverBallance = new BigDecimal("-126226");
	
	/** Nastaveni typu hodnoty investicni fond. */
	private BigDecimal akciovyIFBallance = new BigDecimal("125223");
	
	/** The loc. */
	private Locale loc = new Locale("cs", "CZ", "");
	
	/** The user service. */
	@Autowired
	UserService userService;

	
	/** The ppz service. */
	@Autowired
	PpzService ppzService;
	
	/** The kc. */
	@Autowired
	KomendiusComponent kc;

	/** The logger. */
	Logger logger = Logger.getLogger(PpzAjaxComponent.class);
	
	/**
	 * Nastaveni typu komunikace mezi backendem a interfacem.
	 *
	 * @return the json
	 */
	public String getJson() {
		try {
			WebContext ctx = WebContextFactory.get();
			HttpServletRequest request = ctx.getHttpServletRequest();			
			GameCode gc = kc.getNextGameEvent(WebUtils.getGameCode(request));
			WebUtils.setGameCode(request, gc);
			Game game = gc.getGame();
			StringBuilder jsn = new StringBuilder();
			
			String gameJSON = "";
			Gson gson = new GsonBuilder()
			.setExclusionStrategies(new PpzExclusionStrategy())
			.serializeNulls()
			.create();
			
			FormattedGame fGame = new FormattedGame(game);

			
			gameJSON = gson.toJson(fGame);
	
			//String bank = "\"bank\": {\"sporUcet\": \""+getSporeniValue()+"\",\"hypoteka\": \""+getHypotekaValue()+"\",\"spotrUver\": \""+getSpotrUverValue()+"\",\"akciovyIF\": \""+getAkciovyIFValue()+"\"}";
			String event = "\"events\": " + getRandomEvent();
			
			jsn.append("{");
			jsn.append("\"ppz\":");
			jsn.append(gameJSON);
			//jsn.append(", ");
			//jsn.append(bank);
			
			Boolean generateEvent = false;
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(3);
			switch (randomInt) {
				case 0: generateEvent = true; break;
				case 1: generateEvent = false; break;
				case 2: generateEvent = false; break;
			}		
			if(generateEvent == true) {
				jsn.append(", ");
				jsn.append(event);
			}
			jsn.append("}");
			String sJsn = jsn.toString();
		return sJsn;
		} catch (Exception e) {
			logger.error("JSON Error", e);
			return "";
		}
	}
	
	/**
	 * Dej zmenu formatu meny.
	 *
	 * @param number the number
	 * @return konvertovanou menu
	 */
	private String getConvertedCurrency(BigDecimal number) {
		NumberFormat nf = NumberFormat.getNumberInstance(loc);
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("###,###.###");
		return df.format(number);
	}
		
	/**
	 * Dej hodnotu sporeni a vypocitej ji
	 *
	 * @return hodnotu sporeni
	 */
	private String getSporeniValue() {
		BigDecimal urok = new BigDecimal("1.005");
		BigDecimal pocatecniSuma = sporUcetBallance;
		sporUcetBallance = pocatecniSuma.multiply(urok).setScale(2, BigDecimal.ROUND_HALF_UP);
		String konecnaSuma = getConvertedCurrency(sporUcetBallance);
		return konecnaSuma;
	}
	
	/**
	 * Nastaveni hodnoty hypoteky a jeji vypocet
	 *
	 * @return hodnotu hypoteky
	 */
	private String getHypotekaValue() {
		BigDecimal splatka = new BigDecimal("15537");
		BigDecimal pocatecniSuma = hypotekaBallance;
		hypotekaBallance = pocatecniSuma.add(splatka);
		String konecnaSuma = getConvertedCurrency(hypotekaBallance);
		return konecnaSuma;
	}
	
	/**
	 * Nastaveni hodnoty spotrebitelskeho uveru a jeho vypocet
	 *
	 * @return hodnotu spotrebitelskeho uveru
	 */
	private String getSpotrUverValue() {
		BigDecimal splatka = new BigDecimal("3245");
		BigDecimal pocatecniSuma = spotrUverBallance;
		spotrUverBallance = pocatecniSuma.add(splatka);
		String konecnaSuma = getConvertedCurrency(spotrUverBallance);
		return konecnaSuma;
	}
	
	/**
	 * Nastaveni hodnoty akcioveho investicniho fondu a jeho vypocet
	 *
	 * @return hodnotu investicniho fondu
	 */
	private String getAkciovyIFValue() {
		BigDecimal urok = new BigDecimal("1.012");
		BigDecimal pocatecniSuma = akciovyIFBallance;
		akciovyIFBallance = pocatecniSuma.multiply(urok).setScale(2, BigDecimal.ROUND_HALF_UP);
		String konecnaSuma = getConvertedCurrency(akciovyIFBallance);
		return konecnaSuma;
	}
		
	/**
	 * Nastaveni nahodne udalosti
	 *
	 * @return nahodou udalost
	 */
	private String getRandomEvent() {
		try {
			PossibleEvent possibleEvent = new PossibleEvent();
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(4);
			switch (randomInt) {
				case 0: possibleEvent.setName("Chripka");; break;
				case 1: possibleEvent.setName("Pes si zlomil nohu"); break;
				case 2: possibleEvent.setName("Sperky pro manzelku"); break;
				case 3: possibleEvent.setName("Dovolena v Alpach"); break;
			}
	
			Random randomGenerator2 = new Random();
			int randomInt2 = randomGenerator2.nextInt(3);
			switch (randomInt2) {
				case 0: possibleEvent.setStopper(false);; break;
				case 1: possibleEvent.setStopper(false); break;
				case 2: possibleEvent.setStopper(true); break;
			}
			
			String eventJSON = "";
			
			Gson gson = new GsonBuilder()
			.setExclusionStrategies(new PpzExclusionStrategy())
			.serializeNulls()
			.create();
			
			eventJSON = gson.toJson(possibleEvent);
			return eventJSON;
		} catch (Exception e) {
			logger.error("JSON Error", e);
			return "";
		}
	}
	
	/**
	 * Dej detaily avatara pomoci jasonu
	 *
	 * @return avatar detail json
	 */
	public String getAvatarDetailJson() {
		try {
			// TODO dodelat pro vsechny ostatni objekty
			WebContext ctx = WebContextFactory.get();
			GameCode gameCode = WebUtils.getGameCode(ctx.getHttpServletRequest()); 
			Game game = gameCode.getGame();
			
			Gson gson = new GsonBuilder()
			.setExclusionStrategies(new PpzExclusionStrategy())
			.serializeNulls()
			.create();
	
			FormattedAvatar fAvatar = new FormattedAvatar(game.getAvatar());
			
			String fAvatarJSON = "";
			fAvatarJSON = gson.toJson(fAvatar);
			
			StringBuilder jsn = new StringBuilder();
			jsn.append("{");
			jsn.append("\"fAvatar\": " + fAvatarJSON);
			jsn.append("}");
	
			return jsn.toString();
		} catch (Exception e) {
			logger.error("JSON Error", e);
			return "";
		}
	}
	
	/**
	 * Dej detaily o rodine pomoci json.
	 *
	 * @param type
	 * @return detaily pomoci json
	 */
	public String getFamilyDetailJson(int type) {
		try {
			// TODO dodelat pro vsechny ostatni objekty family
			WebContext ctx = WebContextFactory.get();
			GameCode gameCode = WebUtils.getGameCode(ctx.getHttpServletRequest()); 
			
			String personJSON = "";
			
			Long round = gameCode.getGame().getRoundPlayed();
			List<LinkedPerson> linkedPersons = ppzService.getLinkedPersonByAvatar(gameCode.getGame().getAvatar(), round);
			for (LinkedPerson person : linkedPersons) {
				if(person.getType() == type) {
					
					Gson gson = new GsonBuilder()
					.setExclusionStrategies(new PpzExclusionStrategy())
					.serializeNulls()
					.create();
					
					personJSON = gson.toJson(person);
				}
			}
			
			StringBuilder jsn = new StringBuilder();
			jsn.append("{");
			jsn.append("\"person\": " + personJSON);
			jsn.append("}");
			System.out.println(jsn);
			return jsn.toString();
		} catch (Exception e) {
			logger.error("JSON Error", e);
			return "";
		}
	}
}
