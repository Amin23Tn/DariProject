package tn.esprit.entities;

import javax.persistence.*;

@Entity
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClaim;
    private String Subject;
    private String Stage;
    @ManyToOne
    private User user;

    public int getIdClaim() {
        return idClaim;
    }

    public void setIdClaim(int idClaim) {
        this.idClaim = idClaim;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getStage() {
        return Stage;
    }

    public void setStage(String stage) {
        Stage = stage;
    }

    public Claim(int idClaim, String subject, String stage) {
        super();
        this.idClaim = idClaim;
        Subject = subject;
        Stage = stage;
    }

    public Claim() {
        super();
    }


}
