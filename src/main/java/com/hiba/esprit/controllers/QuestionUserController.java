package com.hiba.esprit.controllers;

import static org.springframework.http.HttpStatus.OK;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiba.esprit.entities.QuestionUser;
import com.hiba.esprit.service.QuestionUserService;

@RestController
@RequestMapping("/questionusers")
public class QuestionUserController {

	@Autowired
	private QuestionUserService questionUserService;
	

	@PostMapping(path = "/envoyermail")
	public ResponseEntity<String> sendMail(@RequestBody QuestionUser questionUser) {
		questionUserService.sendMail(questionUser);
		questionUserService.saveQuestionUser(questionUser);
		return new ResponseEntity<>("Nous avons reçu votre email et nous essaierons de vous répondre dans les plus brefs délais",OK);
	}
	
	@GetMapping(path ="/search/all")
	public ResponseEntity<Collection<QuestionUser>> findAll () {
		Collection<QuestionUser> allUsers = questionUserService.findAllQuestionUsers(); 
		return new ResponseEntity<>(allUsers,OK); 
	}
	
	@GetMapping(path ="/search/{id}")
	public ResponseEntity<QuestionUser> findById(@PathVariable(name = "id" , required = true) Long id) {
		QuestionUser questionUser = questionUserService.findQuestionUserById(id); 
		return new ResponseEntity<>(questionUser,OK); 
	}
	
	@PostMapping(path = "/save") 
	public ResponseEntity<QuestionUser> save (@RequestBody QuestionUser questionUser) {
	    questionUserService.saveQuestionUser(questionUser);  
		return new ResponseEntity<>(questionUser,OK); 
	}
	
	@PutMapping(path  = "/update")
	public ResponseEntity<QuestionUser> update (@RequestBody QuestionUser questionUser) {
		questionUserService.updateUser(questionUser); 
		return new ResponseEntity<>(questionUser,OK); 
	}
	
	@DeleteMapping(path ="/deleteById/{id}")
	public ResponseEntity<QuestionUser> deleteById(@PathVariable(name = "id") Long id ) {
		QuestionUser questionUser = questionUserService.deleteQuestionUserByID(id); 
		return new ResponseEntity<>(questionUser,OK);
	}
	
	@DeleteMapping(path ="/deleteAll") 
	public ResponseEntity<QuestionUser> deleteAll() {
		questionUserService.deleteAll() ;
		return new ResponseEntity<>(OK); 
	}
	
	
	
	
	
	
	
	
	

}
