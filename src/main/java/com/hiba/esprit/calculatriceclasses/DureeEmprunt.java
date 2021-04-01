package com.hiba.esprit.calculatriceclasses;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class DureeEmprunt {

	@NotNull
	@Min(value = 0 , message = "Prix du bien ne doit pas etre negatif")
	private Long prixDuBien;
	@NotNull
	@Min(value = 0 , message = "Mensualite  souhaite ne doit pas etre negatif")
	private Long mensualiteSouaite;
	@NotNull
	@Min(value = 0 , message = "Taux bien ne doit pas etre negatif")
	@Max(value = 100 , message = "Taux ne doit être entre 0 et 100")
	private Byte taux;




	public Long getPrixDuBient() {
		return prixDuBien;
	}

	public void setPrixDuBien(Long prixDuBient) {
		this.prixDuBien = prixDuBient;
	}

	public Long getMensualiteSouaite() {
		return mensualiteSouaite;
	}

	public void setMensualiteSouaite(Long mensualiteSouaite) {
		this.mensualiteSouaite = mensualiteSouaite;
	}

	public Byte getTaux() {
		return taux;
	}

	public void setTaux(Byte taux) {
		this.taux = taux;
	}
	
	

	
}
