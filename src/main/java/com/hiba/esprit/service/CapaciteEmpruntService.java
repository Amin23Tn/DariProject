package com.hiba.esprit.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.hiba.esprit.calculatriceclasses.CapaciteEmprunt;
import com.hiba.esprit.utility.CalculUtility;

@Service
public class CapaciteEmpruntService {

	public double calculResultat(CapaciteEmprunt capaciteEmprunt) {
		verifierKeysCapaciteEmprunt(capaciteEmprunt);
		return CalculUtility.calculerCapaciteEmprunt(capaciteEmprunt); 
	}

	private void verifierKeysCapaciteEmprunt(CapaciteEmprunt capaciteEmprunt) {
		verifierNull(capaciteEmprunt); 
		verifierTaux(capaciteEmprunt.getTaux()); 
		verifierSalaire(capaciteEmprunt.getCharge(),capaciteEmprunt.getSalaire());
	}

	private void verifierSalaire(Double charge, Double salaire) {
		if (salaire < charge) 
			throw new IllegalArgumentException("Salaire doit être supperieur a la charge");
	}

	private void verifierTaux(Double taux) {
		if (taux.doubleValue() < 1 || taux.doubleValue() > 40) 
			throw new IllegalArgumentException("Le taux doit etre entre 0 et 40 ");
	}

	private void verifierNull(CapaciteEmprunt capaciteEmprunt) {
		Objects.requireNonNull(capaciteEmprunt.getCharge(),"Charge est null"); 
		Objects.requireNonNull(capaciteEmprunt.getDureeDuPret(),"Duree du pret est null"); 
		Objects.requireNonNull(capaciteEmprunt.getSalaire(),"Salaire est null"); 
		Objects.requireNonNull(capaciteEmprunt.getTaux(),"Taux est null"); 
	}


	

}
