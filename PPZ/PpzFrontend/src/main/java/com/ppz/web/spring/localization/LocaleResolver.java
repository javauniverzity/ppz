package com.ppz.web.spring.localization;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import com.ppz.web.entity.User;
import com.ppz.web.interfaces.service.UserService;
import com.ppz.web.utils.UserUtils;

/**
 * Trida lokalni resici jednotka
 * 
 * @author David
 *
 */
public class LocaleResolver extends AcceptHeaderLocaleResolver {
	
	Logger logger = Logger.getLogger(LocaleResolver.class);
	
	private static UserService userService;
	/**
	 * Zpusob reseni lokalnich promennych pomoci zaslani pozadavku
	 */
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		Locale locale = null;
		if (request.getSession() != null && request.getSession().getAttribute("locale") != null) {
			locale = (Locale) request.getSession().getAttribute("locale");
		}
		if (locale == null){
			//logger.debug("LocaleResolver: LocaleContextHolder.getLocale() == null");
			String username = UserUtils.getCurrentUsername();
			User user = userService.loadUserByUsername(username);
			if (user != null) {
				String userLocale = user.getLocale();
				if (userLocale != null && !"".equals(userLocale)) {
					for (Locale l : Locale.getAvailableLocales()) {
						if (userLocale.equals(l.getLanguage())) {
							//logger.debug("LocaleResolver: Locale from db for user " + username + " locale: "+userLocale);
							locale = l;
							request.getSession().setAttribute("locale", locale);
							break;
						}
					}
				}
			} else {
				return super.resolveLocale(request);	
			}
			//logger.debug("LocaleResolver: LocaleContextHolder.getLocale(): "+ locale);
			
		}
		if (locale != null) {
			//logger.debug("LocaleResolver: Locale return - locale: " + locale.getLanguage());
		} else {
			return super.resolveLocale(request);
		}
		return locale; 
	}
	/**
	 * Nastaveni lokalniho uzivatele 
	 * @param locale
	 * @param request
	 */
	public void setLocale(Locale locale, HttpServletRequest request){
		String username = UserUtils.getCurrentUsername();
		User user = userService.loadUserByUsername(username);
		if (user != null && locale != null) {
			user.setLocale(locale.getLanguage());
			userService.updateUser(user);
		}
		request.getSession().setAttribute("locale", locale);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		LocaleResolver.userService = userService;
	}

	/**
	 * Nastaveni jazyku lokalniho uzivatele
	 * @param userLocale
	 * @param request
	 */
	public void setLocale(String userLocale, HttpServletRequest request) {
		for (Locale l : Locale.getAvailableLocales()) {
			if (userLocale.equals(l.getLanguage())) {
				logger.debug("LocaleResolver: Set locale from String: "+userLocale);
				request.getSession().setAttribute("locale", l);
				break;
			}
		}
		
	}
	
}
