package org.tritux.restController;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tritux.dao.CandidatRepo;
import org.tritux.dao.UserRepo;
import org.tritux.entites.Candidat;
import org.tritux.entites.User;
import org.tritux.service.SmtpMailSender;
import org.tritux.service.email;

@RestController
@CrossOrigin 
public class sendingMailRest {
	
	@Autowired
	private SmtpMailSender smtpMailSender;

	@Autowired
	CandidatRepo candidatRepo;

	@Autowired
	UserRepo userRepo;


	// enovyer un email pour recuperation du mot de passe oublier 
	@RequestMapping(value = "/recupMail/{login}",method = RequestMethod.GET)
	public String recupMail(@PathVariable String login) throws MessagingException {
		
		User u=userRepo.findBylogin(login);
		Candidat c =candidatRepo.findOne(u.getId());
		
		smtpMailSender.send(c.getProfil().getEmail(), "Platforme Tritux:recuperer votre mot de passe",
				"veuillez ne plus oublier votre mot de passe merde "+"\n"+ "votre mot de passe est "+"\t"+u.getPassword());
		
		return "{\"email\": \"" + c.getProfil().getEmail() + "\"}";
	}
	
	
	
	// enovyer un email
	@RequestMapping(value = "/envoyerMail",method = RequestMethod.POST)
	public String sendingmail(@RequestBody email e) throws MessagingException {
		
//		@RequestParam("to") String to,
//		@RequestParam("subject") String subject,
//		@RequestParam("body") String body
		
		System.out.println(e.getTo());
		System.out.println(e.getSubject());
		System.out.println(e.getBody());
		
		smtpMailSender.send(e.getTo(),e.getSubject(),e.getBody());	
		return "{\"email envoyer\": \"" + e.getTo()+ "\"}";
	}

}
