/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.portal.auth;

import entity.Student;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import library.FacesUtilities;
import repository.portal.StudentLoginRepository;

@ManagedBean
@ViewScoped
public class StudentLoginBean implements Serializable{

    private Student student;
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

    public StudentLoginBean() {
    }

    public void checkUser() {
        try {
            StudentLoginRepository repository = new StudentLoginRepository();
            student = repository.listFilter(userName);
            if (student != null) {
                if (student.getUser().getUserName().equals(userName) && student.getUser().getUserPassword().equals(password)) {
                    HttpSession session = FacesUtilities.getSession();
                    session.setAttribute("studentId", "" + student.getStudentId());
                    session.setAttribute("studentName", "" + userName);
                    System.out.println("View Dan Alinan User Name :" + userName);
                    System.out.println("View Dan Alinan password :" + password);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("../StudentCourceContentSummery.xhtml");
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kullanici Adi veya Sifre Yanlis"));
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Boyle Bir kullanici Yok"));
            }
        } catch (Exception e) {
            e.printStackTrace();
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bir Hata Oldu"));
        }

//        String realUserName = FacesUtilities.getContextParam("userName", "");
//        String realPassword = FacesUtilities.getContextParam("password", "");
//        
//        System.out.println("Faces Dan Alinan User Name :" + realUserName);
//        System.out.println("Faces Dan Alinan password :" + realPassword);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
