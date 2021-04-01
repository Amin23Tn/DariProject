package tn.esprit.entities;

import javax.persistence.*;

@Entity
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idWish;
    private float areaMin;
    private float areaMax;
    private float budgetMin;
    private float budgetMax;
    private String Lieu;
    private int nbRoom;
    private int nbGarage;
    private Boolean Elevator;

    @ManyToOne
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getIdWish() {
        return idWish;
    }

    public void setIdWish(int idWish) {
        this.idWish = idWish;
    }

    public float getAreaMin() {
        return areaMin;
    }

    public void setAreaMin(float areaMin) {
        this.areaMin = areaMin;
    }

    public float getAreaMax() {
        return areaMax;
    }

    public void setAreaMax(float areaMax) {
        this.areaMax = areaMax;
    }

    public float getBudgetMin() {
        return budgetMin;
    }

    public void setBudgetMin(float budgetMin) {
        this.budgetMin = budgetMin;
    }

    public float getBudgetMax() {
        return budgetMax;
    }

    public void setBudgetMax(float budgetMax) {
        this.budgetMax = budgetMax;
    }

    public String getLieu() {
        return Lieu;
    }

    public void setLieu(String lieu) {
        Lieu = lieu;
    }

    public int getNbRoom() {
        return nbRoom;
    }

    public void setNbRoom(int nbRoom) {
        this.nbRoom = nbRoom;
    }

    public int getNbGarage() {
        return nbGarage;
    }

    public void setNbGarage(int nbGarage) {
        this.nbGarage = nbGarage;
    }

    public Boolean getElevator() {
        return Elevator;
    }

    public void setElevator(Boolean elevator) {
        Elevator = elevator;
    }

    public WishList(int idWish, float areaMin, float areaMax, float budgetMin, float budgetMax, String lieu, int nbRoom,
                    int nbGarage, Boolean elevator) {
        super();
        this.idWish = idWish;
        this.areaMin = areaMin;
        this.areaMax = areaMax;
        this.budgetMin = budgetMin;
        this.budgetMax = budgetMax;
        Lieu = lieu;
        this.nbRoom = nbRoom;
        this.nbGarage = nbGarage;
        Elevator = elevator;
    }

    public WishList() {
        super();
    }

}
