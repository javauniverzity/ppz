package com.ppz.web.utils;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ppz.web.entity.User;

public class UserUtils {
	
	static Logger logger = Logger.getLogger(UserUtils.class);
	
	public static String getCurrentUsername(){
		String username = "";
		try {
			if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().getName() != null) {
				username = SecurityContextHolder.getContext().getAuthentication().getName();
			}
		} catch (Exception ex){
			logger.error("UserUtils: getCurrentUsername: Error while getting username from security context holder");
		}
		if (!"".equals(username)) {
			//logger.info("UserUtils: UserUtils.getCurrentUsername(): "+username);
		}
		return username;
	}

	public static String getMd5Password(User user, String password){
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		ReflectionSaltSource salt = new ReflectionSaltSource();
		salt.setUserPropertyToUse("getUsername");

		String result = encoder.encodePassword(password, salt.getSalt(user));
		return result;
	}
}
