package com.ppz.web.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;

import com.ppz.web.entity.GameCode;
import com.ppz.web.entity.User;

public class WebUtils {

	public static GameCode getGameCode(HttpServletRequest request) {
		GameCode code = (GameCode) request.getSession().getAttribute(GameCode.GAME_CODE);
		if (code == null) {
			clearUser();
		}
		return code;
	}
	
	public static void setGameCode(HttpServletRequest request, GameCode code) {
		if (code == null) {
			clearUser();
		}
		request.getSession().setAttribute(GameCode.GAME_CODE, code);
	}
	
	public static void setUser(User user) {
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContext ctx = new SecurityContextImpl();  
        ctx.setAuthentication(auth);  
        SecurityContextHolder.setContext(ctx);
	}
	
	public static void clearUser() {
		SecurityContext ctx = new SecurityContextImpl();
		SecurityContextHolder.setContext(ctx);
	}
	
}
