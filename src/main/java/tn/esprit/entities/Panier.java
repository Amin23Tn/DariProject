package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Panier implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idPanier;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date date ;
	//@ManyToOne
	private int userId;
	//@ManyToOne
	private String ProductName;
	
	
	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Panier(Date date) {
		super();
		this.date = date;
	}
	public long getIdPanier() {
		return idPanier;
	}
	public void setIdPanier(long idPanier) {
		this.idPanier = idPanier;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Panier [idPanier=" + idPanier + ", date=" + date + "]";
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	
	
	

}
