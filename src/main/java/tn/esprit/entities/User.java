package tn.esprit.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements org.springframework.security.core.userdetails.UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    private String emailUser;

    @Column(unique = true, nullable = false)
    private String nameUser;

    @Column(unique = false, nullable = false)
    private String password;
    @Column(unique = false, nullable = false)
    private boolean enabled = true;
    @OneToOne(mappedBy = "user")
    private Subscription sub;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<WishList> wish;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<Ad> ad;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<Appointment> app;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<Loan> lo;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<Claim> cl;


    public List<Claim> getCl() {
        return cl;
    }

    public void setCl(List<Claim> cl) {
        this.cl = cl;
    }

    public List<Loan> getLo() {
        return lo;
    }

    public void setLo(List<Loan> lo) {
        this.lo = lo;
    }

    public List<Appointment> getApp() {
        return app;
    }

    public void setApp(List<Appointment> app) {
        this.app = app;
    }

    public List<Ad> getAd() {
        return ad;
    }

    public void setAd(List<Ad> ad) {
        this.ad = ad;
    }

    public List<WishList> getWish() {
        return wish;
    }

    public void setWish(List<WishList> wish) {
        this.wish = wish;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [idUser=" + idUser + ", nameUser=" + nameUser + ", EmailUser=" + emailUser + "]";
    }

    public User(String nameUser, String emailUser, String password) {
        super();
        this.nameUser = nameUser;
        this.emailUser = emailUser;
        this.password = password;
    }

    public User() {
        super();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.nameUser;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public void block() {
        this.enabled = false;
    }

    public void unblock() {
        this.enabled = true;
    }

}
