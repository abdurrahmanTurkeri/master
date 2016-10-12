/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.portal.summery;

import entity.CourceContent;
import entity.Exam;
import entity.Question;
import entity.QuestionType;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import library.FacesUtilities;
import repository.admin.CourceContentRepository;
import repository.admin.ExamRepository;
import repository.admin.QuestionRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@ViewScoped
public class HomeBean implements Serializable {
    public String gotoTeacherLogin(){
        System.out.println("beans.portal.summery.HomeBean.gotoTeacherLogin()" +"GFidiyor");
        return "/portal/authentication/TeacherLoginPage.xhtml?faces-redirect=true";
    }
       public String gotoStudentLogin(){
        System.out.println("beans.portal.summery.HomeBean.gotoTeacherLogin()" +"GFidiyor");
        return "/portal/authentication/TeacherLoginPage.xhtml?faces-redirect=true";
    }

}
