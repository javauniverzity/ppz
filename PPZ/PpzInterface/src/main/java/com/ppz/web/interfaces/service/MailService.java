package com.ppz.web.interfaces.service;

// TODO: Auto-generated Javadoc
/**
 * Functionality for sending mail.
 *
 * @author Honza
 */

public interface MailService {

	/**
	 * Send mail.
	 *
	 * @param email the email
	 * @param subject the subject
	 * @param text the text
	 * @throws Exception the exception
	 */
	public void sendMail(String email, String subject, String text)
			throws Exception;
}
