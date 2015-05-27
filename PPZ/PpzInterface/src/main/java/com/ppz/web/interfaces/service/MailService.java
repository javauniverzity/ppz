package com.ppz.web.interfaces.service;

public interface MailService {

	public void sendMail(String email, String subject, String text) throws Exception;
}
