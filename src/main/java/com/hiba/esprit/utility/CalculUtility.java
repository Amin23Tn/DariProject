package com.hiba.esprit.utility;

import com.hiba.esprit.calculatriceclasses.CapaciteEmprunt;
import com.hiba.esprit.calculatriceclasses.DureeEmprunt;
import com.hiba.esprit.calculatriceclasses.Mensualite;

public class CalculUtility {
	
	
	private static final double TMM = 6.23 ; 
	
	private CalculUtility() {
		
	}
	
	
	public static double calculerMensualite(Mensualite mensualite) {
		double prixDuBien = mensualite.getPrixDuBien(); 
		double duree = mensualite.getDureeDuPret(); 
		double taux =  (TMM + 5)/100 ; 
		double numerateur = prixDuBien * (taux/12) ; 
		double denominateur =  1 - Math.pow(1+(taux/12),duree*-1); 
		return numerateur / denominateur ;
	}
	
	public static double calculerCapaciteEmprunt(CapaciteEmprunt capaciteEmprunt) {
		double salaire = capaciteEmprunt.getSalaire(); 
		double charge = capaciteEmprunt.getCharge(); 
		double taux = capaciteEmprunt.getTaux() / 100; 
		int duree = capaciteEmprunt.getDureeDuPret();
		return ((salaire - charge) * taux ) * duree ; 
	}
	
	
	public static double calculerDureeEmprunt(DureeEmprunt dureeEmprunt) {
		double prixDuBien = dureeEmprunt.getPrixDuBient(); 
		double mensualiteSouhaite = dureeEmprunt.getMensualiteSouaite(); 
		double taux = dureeEmprunt.getTaux().doubleValue() / 100 ;  
		double premierLn = (mensualiteSouhaite*-1) / (taux/12) * prixDuBien - mensualiteSouhaite ; 
		double secondLn  = 1 + (taux/2) ; 
		return Math.log(premierLn) / Math.log(secondLn); 
	}

}
