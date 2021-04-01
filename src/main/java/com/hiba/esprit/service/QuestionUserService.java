package com.hiba.esprit.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiba.esprit.entities.QuestionUser;
import com.hiba.esprit.repository.QuestionUserRepository;
import com.hiba.esprit.utility.QuestionUserUtility;

@Service
public class QuestionUserService {

	@Autowired
	private MailService mailService;
	@Autowired 
	private QuestionUserRepository questionUserRepository ; 

	public void sendMail(QuestionUser questionUser) {
		QuestionUserUtility.checkUserDetails(questionUser);
		mailService.sendMail(questionUser);
	}

	public Collection<QuestionUser> findAllQuestionUsers() {
		return questionUserRepository.findAll(); 
	}

	public QuestionUser findQuestionUserById(Long id) {
		return questionUserRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("User with id " + id +" does not exist"));
	}

	public void saveQuestionUser(QuestionUser questionUser) {
		questionUserRepository.save(questionUser); 
	}

	public void updateUser(QuestionUser questionUser) {
		if (questionUserRepository.findById(questionUser.getId()).isPresent()) {
			QuestionUser existingUser = questionUserRepository.findById(questionUser.getId()).get(); 
			doMappingFromExistingUserToQuestionUser(existingUser,questionUser); 
			questionUserRepository.save(existingUser);
		} else {
			throw new IllegalArgumentException("Question user avec id" + questionUser.getId() + "n'existe pas dans la base de donne");
		}
	}

	private void doMappingFromExistingUserToQuestionUser(QuestionUser existingUser, QuestionUser questionUser) {
		existingUser.setNom(questionUser.getNom());
		existingUser.setEmail(questionUser.getEmail());
		existingUser.setIsTreatmentAccepted(questionUser.getIsTreatmentAccepted());
	}

	public void deleteAll() {
		questionUserRepository.deleteAll(); 
	}

	public QuestionUser deleteQuestionUserByID(Long id) {
		if (!questionUserRepository.findById(id).isPresent()) {
			throw new IllegalArgumentException("Question user avec id : " + id + "n'existe pas dans la base de donne");
		} else {
			QuestionUser questionUser = questionUserRepository.findById(id).get();
			questionUserRepository.deleteById(id);
			return questionUser; 
		}
	}
	
	
	


}
