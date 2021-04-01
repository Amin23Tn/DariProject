package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Agent extends User implements Serializable {
	
	
	private int idAgent;
	private String NameAgent;
	private String PrenomAgent;
	public int getIdAgent() {
		return idAgent;
	}
	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}
	public String getNameAgent() {
		return NameAgent;
	}
	public void setNameAgent(String nameAgent) {
		NameAgent = nameAgent;
	}
	public String getPrenomAgent() {
		return PrenomAgent;
	}
	public void setPrenomAgent(String prenomAgent) {
		PrenomAgent = prenomAgent;
	}
	public Agent(int idUser, String nameUser, String emailUser) {
		super(idUser, nameUser, emailUser);
	}
	

}
