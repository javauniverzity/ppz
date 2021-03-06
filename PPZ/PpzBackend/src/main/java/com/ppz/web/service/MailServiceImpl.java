package com.ppz.web.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.ppz.web.interfaces.service.MailService;

/**
 * Implementace sluzby mailService na starosti odesilani emailu.
 *
 * @author Honza
 */
@Service(value = "mailService")
public class MailServiceImpl implements MailService {
	
	@Override
	public void sendMail(final String email, final String subject, final String text) throws Exception {
		final Properties props = new Properties();
		setProperties(props);

		final Session mailSession = Session.getDefaultInstance(props, null);
		final Transport transport = mailSession.getTransport();

		final MimeMessage message = new MimeMessage(mailSession);
		message.setSubject(subject, "UTF-8");

		message.setContent(text, "text/html; charset=UTF-8");
		
		// upravit adresu
		message.addFrom(new InternetAddress[] { new InternetAddress("ppz@ppz.com") });
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

		transport.connect();
		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		transport.close();
	}

	/**
	 * Sets the properties.
	 *
	 * @param props the new properties
	 */
	private static void setProperties(final Properties props) {
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "localhost");
	}

}
