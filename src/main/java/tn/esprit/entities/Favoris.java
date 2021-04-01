package tn.esprit.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Favoris implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Ad ad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public Favoris(Customer customer, Ad ad) {
        this.id = id;
        this.customer = customer;
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "Favoris [id=" + id + ", customer=" + customer + ", ad=" + ad
                + "]";
    }

    public Favoris() {
        super();
    }


}
