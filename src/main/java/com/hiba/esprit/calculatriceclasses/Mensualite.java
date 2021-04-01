package com.hiba.esprit.calculatriceclasses;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Mensualite {

	@NotNull
	@Min(value = 0 , message = "Prix du bien ne doit pas etre negatif")
	private Double prixDuBien;
	@NotNull
	@Min(value = 0 , message = "Duree du pret ne doit pas etre negatif")
	private Integer dureeDuPret;
	@NotNull
	@Min(value = 0 ,message = "le taux ne peut pas etre negatif")
	private Double taux ; 

	
	public Mensualite(@NotNull @Min(value = 0, message = "Prix du bien ne doit pas etre negatif") Double prixDuBien,
			@NotNull @Min(value = 0, message = "Duree du pret ne doit pas etre negatif") Integer dureeDuPret,
			@NotNull @Min(value = 0, message = "le taux ne peut pas etre negatif") Double taux) {
		super();
		this.prixDuBien = prixDuBien;
		this.dureeDuPret = dureeDuPret;
		this.taux = taux;
	}

	public Double getPrixDuBien() {
		return prixDuBien;
	}

	public void setPrixDuBien(Double prixDuBien) {
		this.prixDuBien = prixDuBien;
	}

	public Integer getDureeDuPret() {
		return dureeDuPret;
	}

	public void setDureeDuPret(Integer dureeDuPret) {
		this.dureeDuPret = dureeDuPret;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
	


}
