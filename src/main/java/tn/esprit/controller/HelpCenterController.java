package tn.esprit.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.MailException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.HelpCenter;
import tn.esprit.repository.HelpCenterRepository;
import tn.esprit.service.HalpCenterService;
import tn.esprit.service.NotificationService;

@RestController
@RequestMapping("/Report")
public class HelpCenterController {
	
	
	@Autowired
	private HalpCenterService helpcenterservice ; 
	@Autowired
	private NotificationService NotificationService;
	
	
	@GetMapping("/afficherClaim") 
	@ResponseBody 
	 //http://localhost:8081/retrieve-all-users 
	 public List<HelpCenter> getClaim() { 
		 List<HelpCenter> list = helpcenterservice.afficherClaim() ; 
		 return list; 
	} 
	
	
	@PostMapping("/ajouterClaim") 
	 public void addClaim(@RequestBody HelpCenter helpCenter) { 
		 helpcenterservice.ajouterClaim(helpCenter); 
		 try{
			 NotificationService.SendNotification("romdhanihoussemeddine@gmail.com",helpCenter.getSubject());
		 }catch(MailException e){
			 
		 }
	} 
	
	@DeleteMapping("/deleteClaim") 
	 public void deleteClaim(@Param(value = "id") long id) { 
		 helpcenterservice.deleteClaim(id); 
	} 
}
