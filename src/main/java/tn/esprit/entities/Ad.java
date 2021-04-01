package tn.esprit.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAd;
    @Enumerated(EnumType.STRING)
    private State Stat;
    @Enumerated(EnumType.STRING)
    private RentingType Type;
    @ManyToOne
    private User user;

    private Date dateAjout;
    private Date dateAchat;

    private float Area;
    private String location;
    private float price;

    private int nbRoom;
    private int nbGarage;
    private int nbBathroom;
    private Boolean Ascenseur;
    private Boolean Heater;
    private Boolean swimmingPool;
    private Boolean Garden;
    private Boolean Terasse;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getIdAd() {
        return idAd;
    }

    public void setIdAd(int idAd) {
        this.idAd = idAd;
    }

    public float getArea() {
        return Area;
    }

    public void setArea(float area) {
        Area = area;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
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

    public int getNbBathroom() {
        return nbBathroom;
    }

    public void setNbBathroom(int nbBathroom) {
        this.nbBathroom = nbBathroom;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public RentingType getType() {
        return Type;
    }

    public void setType(RentingType type) {
        Type = type;
    }

    public State getStat() {
        return Stat;
    }

    public void setStat(State stat) {
        Stat = stat;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Boolean getAscenseur() {
        return Ascenseur;
    }

    public void setAscenseur(Boolean ascenseur) {
        Ascenseur = ascenseur;
    }

    public Boolean getHeater() {
        return Heater;
    }

    public void setHeater(Boolean heater) {
        Heater = heater;
    }

    public Boolean getSwimmingPool() {
        return swimmingPool;
    }

    public void setSwimmingPool(Boolean swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    public Boolean getGarden() {
        return Garden;
    }

    public void setGarden(Boolean garden) {
        Garden = garden;
    }

    public Boolean getTerasse() {
        return Terasse;
    }

    public void setTerasse(Boolean terasse) {
        Terasse = terasse;
    }

    public Ad(int idAd, float area, Date dateAjout, int nbRoom, int nbGarage, int nbBathroom, String location,
              float price, RentingType type, State stat, Date dateAchat, Boolean ascenseur, Boolean heater,
              Boolean swimmingPool, Boolean garden, Boolean terasse) {
        super();
        this.idAd = idAd;
        Area = area;
        this.dateAjout = dateAjout;
        this.nbRoom = nbRoom;
        this.nbGarage = nbGarage;
        this.nbBathroom = nbBathroom;
        this.location = location;
        this.price = price;
        Type = type;
        Stat = stat;
        this.dateAchat = dateAchat;
        Ascenseur = ascenseur;
        Heater = heater;
        this.swimmingPool = swimmingPool;
        Garden = garden;
        Terasse = terasse;
    }

    public Ad() {
        super();
    }


}
