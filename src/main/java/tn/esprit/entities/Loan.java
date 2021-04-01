package tn.esprit.entities;

import javax.persistence.*;

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCredit;
    private float price;
    private int interestRate;
    private int MonthlyIncome;
    @ManyToOne
    private User user;

    @OneToOne
    private Bank BK;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getIdCredit() {
        return idCredit;
    }

    public void setIdCredit(int idCredit) {
        this.idCredit = idCredit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public int getMonthlyIncome() {
        return MonthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        MonthlyIncome = monthlyIncome;
    }

    public Loan(int idCredit, float price, int interestRate, int monthlyIncome) {
        super();
        this.idCredit = idCredit;
        this.price = price;
        this.interestRate = interestRate;
        MonthlyIncome = monthlyIncome;
    }

    public Loan() {
        super();
    }


}
