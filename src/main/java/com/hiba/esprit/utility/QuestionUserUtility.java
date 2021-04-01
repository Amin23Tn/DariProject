package com.hiba.esprit.utility;

import java.util.regex.Pattern;

import org.dom4j.IllegalAddException;

import com.hiba.esprit.entities.QuestionUser;

public class QuestionUserUtility {

	private static String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";

	private QuestionUserUtility() {
	}

	public static void checkUserDetails(QuestionUser questionUser) {
		verifierEmail(questionUser.getEmail());
		verifierIsTreatmentAccepted(questionUser);
		veryfierNumeroTelephone(questionUser); 
	}

	private static void veryfierNumeroTelephone(QuestionUser questionUser) {
		if (String.valueOf(questionUser.getNumeroTelephone()) != null  && questionUser.getNumeroTelephone().length() != 8)
				throw new IllegalAddException("Le Numero de telephone" + questionUser.getNumeroTelephone() + " n'est pas valide");
	} 

	private static void verifierIsTreatmentAccepted(QuestionUser questionUser) {
		if (!questionUser.getIsTreatmentAccepted())
			throw new IllegalArgumentException(
					"Traitement de donné n'est pas accepte de la part de user" + questionUser.getNom());

	}

	private static void verifierEmail(String email) {
		if (!Pattern.compile(emailPattern).matcher(email).matches())
			throw new IllegalArgumentException("Email " + email + " is not valid");
	}

}
