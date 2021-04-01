package tn.esprit.entities;

import javax.persistence.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBank;
    private String name;
    @OneToOne(mappedBy = "BK")
    private Loan lo;

    public int getIdBank() {
        return idBank;
    }

    public void setIdBank(int idBank) {
        this.idBank = idBank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bank(int idBank, String name) {
        super();
        this.idBank = idBank;
        this.name = name;
    }

    public Bank() {
        super();
    }


}
