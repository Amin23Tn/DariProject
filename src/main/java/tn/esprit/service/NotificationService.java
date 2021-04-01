package tn.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tn.esprit.entities.HelpCenter;
import tn.esprit.repository.HelpCenterRepository;
import tn.esprit.service.HalpCenterService;

@Service
public class NotificationService {
	private JavaMailSender JavaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender JavaMailSender)
	{
		this.JavaMailSender=JavaMailSender;
	}
	
	public void SendNotification(String email,String Subject)
	{
		email="";
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("houssemeddine.romdhani@esprit.tn");
		
		mail.setSubject("Claim");
		mail.setText(Subject);
		
		JavaMailSender.send(mail);
	}
}
