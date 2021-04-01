package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Entity;
@Entity
public class Customer extends User implements Serializable {
	private int idClient;
	private String Login;
	private String password ;
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Customer(int idUser, String nameUser, String emailUser) {
		super(idUser, nameUser, emailUser);
	}
	

}
