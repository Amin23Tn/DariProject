package tn.esprit.entities;

import javax.persistence.Entity;
import java.io.Serializable;

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
        this.NameAgent = nameAgent;
    }

    public String getPrenomAgent() {
        return PrenomAgent;
    }

    public void setPrenomAgent(String prenomAgent) {
        this.PrenomAgent = prenomAgent;
    }



    public Agent(String emailUser, String password, String login) {
        super(login, emailUser, password);
        this.NameAgent = login;
        this.unblock();
    }
    public Agent() {
        super();
    }
}
