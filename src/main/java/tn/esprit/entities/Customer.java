package tn.esprit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Customer extends User implements Serializable {
    private int idClient;
    private String Login;
    private String password;
    private String DescriptionBlock;
    private String type;
    @Column(nullable = false)
    private long rating = 0;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private boolean block;
    private int nbre;
    public Customer(String emailUser, String password, String login) {
        super(login, emailUser, password);
        this.type ="Acheteur";
        this.Login = login;
        this.password = password;
        this.unblock();
        this.nbre = 0;
        this.rating = 0;

    }

    public Customer(String emailUser, String password, String login, String DescriptionBlock, String type) {
        super(login, emailUser, password);
        this.type = type;
        this.Login = login;
        this.password = password;
        this.DescriptionBlock = DescriptionBlock;
        this.unblock();
        this.nbre = 0;
        this.rating = 0;

    }
    public Customer() {
        super();
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getDescriptionBlock() {
        return DescriptionBlock;
    }

    public void setDescriptionBlock(String descriptionBlock) {
        this.DescriptionBlock = descriptionBlock;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        this.Login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNbre() {
        return nbre;
    }

    public void setNbre(int nbre) {
        this.nbre = nbre;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }
}
