/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.admin.summery;

import entity.Question;
import java.io.IOException;
import java.io.Serializable;
import library.FacesUtilities;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import repository.admin.QuestionRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@RequestScoped
public class QuestionSummeryBean implements Serializable{

    List<Question> questionList;
    private long examId;

    public QuestionSummeryBean() throws IOException {
//        HttpSession session = FacesUtilities.getSession();
//        boolean loggedIn = session != null && session.getAttribute("userName") != null;
//      
//        if (loggedIn) {
        selectQuestionList();
//        } else {
//            FacesContext.getCurrentInstance().getExternalContext().redirect("admin/authentication/AdminLogin.xhtml");
//        }

    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public void selectQuestionList() {
        examId = FacesUtilities.getRequestParameter("examId", 0);
        QuestionRepository departmentRepository = new QuestionRepository();
        if (examId != 0) {
            questionList = departmentRepository.listFilter(examId);
        } else {
            questionList = departmentRepository.list();
        }
        departmentRepository.close();
    }

    public void filter() {
        selectQuestionList();
    }

    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
    }

    public void delete() throws IOException {
        examId = FacesUtilities.getRequestParameter("examId", 0);
        QuestionRepository departmentRepository = new QuestionRepository();
        departmentRepository.remove(examId);
        departmentRepository.close();
        FacesContext.getCurrentInstance().getExternalContext().redirect("QuestionSummery.xhtml");
    }

}
