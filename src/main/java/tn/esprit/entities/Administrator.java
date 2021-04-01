package tn.esprit.entities;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Administrator  extends User implements Serializable {

    private int idAdmin;
    private String loginAdmin;
    private String pwdAdmin;


    public int getIdAdmin()
    {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getLoginAdmin() {
        return loginAdmin;
    }

    public void setLoginAdmin(String loginAdmin) {
        this.loginAdmin = loginAdmin;
    }

    public String getPwdAdmin()
    {
        return pwdAdmin;
    }

    public void setPwdAdmin(String pwdAdmin)
    {
        this.pwdAdmin = pwdAdmin;
    }

    public Administrator( String emailUser, String loginAdmin, String pwdAdmin) {
        super(loginAdmin, emailUser, pwdAdmin);
        this.unblock();
        this.loginAdmin = loginAdmin;
        this.pwdAdmin = pwdAdmin;
    }

    public Administrator(int idAdmin, String loginAdmin, String pwdAdmin) {
        this.idAdmin = idAdmin;
        this.loginAdmin = loginAdmin;
        this.pwdAdmin = pwdAdmin;
    }

    public Administrator()
    {
        super();
    }


}
