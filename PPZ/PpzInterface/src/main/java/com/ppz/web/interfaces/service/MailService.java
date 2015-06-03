package com.ppz.web.interfaces.service;

/**
 * Functionality for sending mail
 */

public interface MailService {

	public void sendMail(String email, String subject, String text)
			throws Exception;
}
