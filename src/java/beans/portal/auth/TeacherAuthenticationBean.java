/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.portal.auth;

import entity.Teacher;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import library.FacesUtilities;
import repository.portal.TeacherLoginRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@ViewScoped
public class TeacherAuthenticationBean implements Serializable{

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
    public TeacherAuthenticationBean() {
    }
    public void checkUser() throws IOException {
        System.out.println("View Dan Alinan User Name :" + userName);
        System.out.println("View Dan Alinan password :" + password);
        TeacherLoginRepository repository = new TeacherLoginRepository();
        Teacher teacher = repository.listFilter(userName);
        if (teacher != null) {
            if (teacher.getUser().getUserName().equals(userName) && teacher.getUser().getUserPassword().equals(password)) {
                HttpSession session=FacesUtilities.getSession();
                session.setAttribute("teacherId", ""+teacher.getTeacherId());
                session.setAttribute("teacherName", ""+userName);
                session.setAttribute("userName", ""+userName);
                 session.setAttribute("userType", "teacher");
                FacesContext.getCurrentInstance().getExternalContext().redirect("../TeacherCourcePage.xhtml");
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("KUllanici Adi veya Sifre Yanlis"));
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Boyle Bir kullanici Yok"));
        }

//        String realUserName = FacesUtilities.getContextParam("userName", "");
//        String realPassword = FacesUtilities.getContextParam("password", "");
//        
//        System.out.println("Faces Dan Alinan User Name :" + realUserName);
//        System.out.println("Faces Dan Alinan password :" + realPassword);
    }

}
