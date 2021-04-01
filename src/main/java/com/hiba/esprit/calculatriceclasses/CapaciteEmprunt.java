package com.hiba.esprit.calculatriceclasses;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CapaciteEmprunt {

	@NotNull
	@Min(value = 0, message = "Salaire ne doit pas etre negatif")
	private Double salaire;
	@NotNull
	@Min(value = 0, message = "Charge bien ne doit pas etre negatif")
	private Double charge;
	@NotNull
	@Min(value = 0, message = "Duree du pret du bien ne doit pas etre negatif")
	private Integer dureeDuPret;
	@NotNull
	@Min(value = 1, message = "Taux doit être entre 0 et 40 ")
	@Max(value = 40, message = "Taux doit être entre 0 et 40 ")
	private Double taux;

	public CapaciteEmprunt(@NotNull @Min(value = 0, message = "Salaire ne doit pas etre negatif") Double salaire,
			@NotNull @Min(value = 0, message = "Charge bien ne doit pas etre negatif") Double charge,
			@NotNull @Min(value = 0, message = "Duree du pret du bien ne doit pas etre negatif") Integer dureeDuPret,
			@NotNull @Min(value = 0, message = "Taux doit être entre 0 et 40 ") @Max(value = 40, message = "Taux doit être entre 0 et 40 ") Double taux) {
		super();
		this.salaire = salaire;
		this.charge = charge;
		this.dureeDuPret = dureeDuPret;
		this.taux = taux;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	public Double getCharge() {
		return charge;
	}

	public void setCharge(Double charge) {
		this.charge = charge;
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
