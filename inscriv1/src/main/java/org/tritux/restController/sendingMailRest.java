package org.tritux.restController;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tritux.service.SmtpMailSender;

@RestController
public class sendingMailRest {
	
	@Autowired
	private SmtpMailSender smtpMailSender;


	@RequestMapping(value = "/envoieMail")
	public void sendMail() throws MessagingException {
		
		smtpMailSender.send("mohamed.slama@esprit.tn", "Test mail from Spring", "Visca Barca");
		
	}

}
