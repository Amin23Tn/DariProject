package com.hiba.esprit.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.hiba.esprit.calculatriceclasses.DureeEmprunt;
import com.hiba.esprit.utility.CalculUtility;

@Service
public class DureeEmpruntService {

	public double calculResultat(DureeEmprunt dureeEmprunt) {
		verifierNull(dureeEmprunt); 
		verifierTaux(dureeEmprunt.getTaux()); 
		return CalculUtility.calculerDureeEmprunt(dureeEmprunt) ; 
	}

	private void verifierTaux(Byte taux) {
		if (taux < 1 || taux > 3 ) 
			throw new IllegalArgumentException("Le taux doit etre entre 1 et 3 seulement");
	}

	private void verifierNull(DureeEmprunt dureeEmprunt) {
		Objects.requireNonNull(dureeEmprunt.getMensualiteSouaite(),"Mensualite souahaite est null");
		Objects.requireNonNull(dureeEmprunt.getPrixDuBient(),"Prix du bien est null"); 
		Objects.requireNonNull(dureeEmprunt.getTaux(),"Taux est null"); 
		
	}

}
