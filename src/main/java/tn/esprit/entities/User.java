package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User implements Serializable  {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
private int idUser;
private String nameUser;
private String EmailUser;
@OneToOne(mappedBy="user")

private Subscription sub;

@OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL
    )
private List<WishList> wish;
@OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL
    )
private List<Ad> ad;

@OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL
    )
private List<Appointment> app;

@OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL
    )
private List<loan> lo;

@OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL
    )
private List<HelpCenter> cl;




public List<HelpCenter> getCl() {
	return cl;
}
public void setCl(List<HelpCenter> cl) {
	this.cl = cl;
}

public List<loan> getLo() {
	return lo;
}
public void setLo(List<loan> lo) {
	this.lo = lo;
}
public List<Appointment> getApp() {
	return app;
}
public void setApp(List<Appointment> app) {
	this.app = app;
}
public List<Ad> getAd() {
	return ad;
}
public void setAd(List<Ad> ad) {
	this.ad = ad;
}
public List<WishList> getWish() {
	return wish;
}
public void setWish(List<WishList> wish) {
	this.wish = wish;
}
public int getIdUser() {
	return idUser;
}
public void setIdUser(int idUser) {
	this.idUser = idUser;
}
public String getNameUser() {
	return nameUser;
}
public void setNameUser(String nameUser) {
	this.nameUser = nameUser;
}
public String getEmailUser() {
	return EmailUser;
}
public void setEmailUser(String emailUser) {
	EmailUser = emailUser;
}
@Override
public String toString() {
	return "User [idUser=" + idUser + ", nameUser=" + nameUser + ", EmailUser=" + EmailUser + "]";
}
public User(int idUser, String nameUser, String emailUser) {
	super();
	this.idUser = idUser;
	this.nameUser = nameUser;
	EmailUser = emailUser;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}

}
