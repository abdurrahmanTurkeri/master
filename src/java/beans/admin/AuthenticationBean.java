/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.admin;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import library.FacesUtilities;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@ViewScoped
public class AuthenticationBean implements Serializable{

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthenticationBean() throws IOException {
        try {
            HttpSession session = FacesUtilities.getSession();
            if (session.getAttribute("userName").equals("")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../../index.xhtml");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void checkUser() {
        System.out.println("View Dan Alinan User Name :" + userName);
        System.out.println("View Dan Alinan password :" + password);
        String realUserName = FacesUtilities.getContextParam("userName", "");
        String realPassword = FacesUtilities.getContextParam("password", "");
        System.out.println("Faces Dan Alinan User Name :" + realUserName);
        System.out.println("Faces Dan Alinan password :" + realPassword);
        if (userName.equals(realUserName) && password.equals(realPassword)) {
            try {
                FacesUtilities.getSession().setAttribute("userName", userName);
                FacesContext.getCurrentInstance().getExternalContext().redirect("../../index.xhtml");
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kullanici Adi veya Sifre Yanlis"));
        }
    }

}
