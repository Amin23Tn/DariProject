package com.hiba.esprit.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.hiba.esprit.calculatriceclasses.Mensualite;
import com.hiba.esprit.utility.CalculUtility;

@Service
public class MensualiteService {

	public double calculResultat(Mensualite mensualite) {
		verifierNull(mensualite) ; 
		return CalculUtility.calculerMensualite(mensualite); 
	}

	private void verifierNull(Mensualite mensualite) {
		 Objects.requireNonNull(mensualite.getDureeDuPret(),"Duree Du pret est null"); 
		 Objects.requireNonNull(mensualite.getPrixDuBien(),"Prix Due bien est null"); 
		 Objects.requireNonNull(mensualite.getTaux(),"Taux est null"); 
	}

}
