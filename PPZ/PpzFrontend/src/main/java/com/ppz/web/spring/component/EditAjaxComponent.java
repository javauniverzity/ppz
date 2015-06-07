package com.ppz.web.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ppz.web.interfaces.service.UserService;

/**
 * Trida EditAjaxComponent, ktera se stara o editaci 
 * 
 * @author David
 */
@Component
public class EditAjaxComponent {
	
	/** User service. */
	@Autowired
	UserService userService;
	
	/**
	 * Sada hodnot.
	 *
	 * @param value1 the value1
	 * @param value2 the value2
	 * @return the string
	 */
	public String setValue(String value1, String value2) {
		System.out.println(value1);
		System.out.println(value2);
		if ("error".equals(value1)) {
			return "Byla zadana chybna hodnota v prvnim policku";
		}
		if ("error".equals(value2)) {
			return "Byla zadana chybna hodnota v druhem policku";
		}
		return "";
	}

}
