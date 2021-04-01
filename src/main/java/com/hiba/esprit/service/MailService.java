package com.hiba.esprit.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.hiba.esprit.entities.QuestionUser;
import com.hiba.esprit.utility.MailSenderProperties;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender; 
	
	public void sendMail(QuestionUser questionUser) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage); 
			messageHelper.setFrom(questionUser.getEmail());
			messageHelper.setTo("hibasouissi@gmail.com"); 
			messageHelper.setText(questionUser.getEmailContent());
		} ; 
		try {
			mailSender.send(messagePreparator);
			Logger.getGlobal().log(Level.INFO, "Email est reçu");
		} catch (MailException ex) {
			throw new MailSendException("Exception s'est produite lors de l'envoi de mail",ex.getCause()); 
		}
	}
	
	@Bean
	public JavaMailSender mailSender () {
		JavaMailSenderImpl sender = new JavaMailSenderImpl(); 
		sender.setHost(MailSenderProperties.MAIL_HOST);
		sender.setProtocol(MailSenderProperties.MAIL_PROTOCOL);
		sender.setUsername("0bf4c84481671a");
		sender.setPassword("3e53cbb378e926");
		sender.setPort(MailSenderProperties.MAIL_PORT);
		return sender;
	}
}
