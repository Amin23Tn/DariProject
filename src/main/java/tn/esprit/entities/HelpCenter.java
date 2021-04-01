package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HelpCenter implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idContact;
	private String Subject ;
	@ManyToOne
	private User user;
	
	
	public HelpCenter() {
		super();
	}


	public HelpCenter(String subject, User user) {
		super();
		Subject = subject;
		this.user = user;
	}


	public long getIdContact() {
		return idContact;
	}


	public void setIdContact(long idContact) {
		this.idContact = idContact;
	}


	public String getSubject() {
		return Subject;
	}


	public void setSubject(String subject) {
		Subject = subject;
	}


	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
