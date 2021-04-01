package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Subscription implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
private int idSubsc;
	private String offer;
	@OneToOne
	private User user;
	

	public int getIdSubsc() {
		return idSubsc;
	}
	public void setIdSubsc(int idSubsc) {
		this.idSubsc = idSubsc;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	
	public Subscription(int idSubsc, String offer) {
		super();
		this.idSubsc = idSubsc;
		this.offer = offer;
	}
	public Subscription() {
		super();
	}
	

}
