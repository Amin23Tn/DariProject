package tn.esprit.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dateApp;
    private String description;
    private String status;
    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateApp() {
        return dateApp;
    }

    public void setDateApp(Date dateApp) {
        this.dateApp = dateApp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Appointment(int id, Date dateApp, String description, String status) {
        super();
        this.id = id;
        this.dateApp = dateApp;
        this.description = description;
        this.status = status;
    }

    public Appointment() {
        super();
    }

}
