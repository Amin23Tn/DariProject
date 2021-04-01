package com.hiba.esprit.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table
public class QuestionUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nom;
	@NotNull
	private String email;
	@NotNull
	private String numeroTelephone;
	private String emailContent;
	private boolean isTreatmentAccepted;

	public QuestionUser() {

	}

	public QuestionUser(Long id, String nom, String email, String numeroTelephone, String emailContent,
			boolean isTreatmentAccepted) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.numeroTelephone = numeroTelephone;
		this.emailContent = emailContent;
		this.isTreatmentAccepted = isTreatmentAccepted;
	}

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public String getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getIsTreatmentAccepted() {
		return isTreatmentAccepted;
	}

	public void setIsTreatmentAccepted(boolean isTreatmentAccepted) {
		this.isTreatmentAccepted = isTreatmentAccepted;
	}

}
