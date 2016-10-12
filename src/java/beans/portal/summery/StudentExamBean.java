/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.portal.summery;

import entity.Exam;
import entity.Question;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import library.FacesUtilities;
import repository.admin.ExamRepository;
import repository.admin.QuestionRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@ViewScoped
public class StudentExamBean implements Serializable {

    private long currentCourceContentId;
    private List<Exam> examList;

    public StudentExamBean() {
        getListOfExam();
    }

    public void getListOfExam() {
        currentCourceContentId = FacesUtilities.getRequestParameter("courceContentId", 0);
        ExamRepository questionRepository = new ExamRepository();
        examList = questionRepository.listFilter(currentCourceContentId);
        questionRepository.close();
    }

    public long getCurrentCourceContentId() {
        return currentCourceContentId;
    }

    public void setCurrentCourceContentId(long currentCourceContentId) {
        this.currentCourceContentId = currentCourceContentId;
    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    public void itIsntStart() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bu ödev öğretmeniniz tarafından aktif edilmemiştir! Bu ödevi çözmek için öğretmeninizden gelecek talimatı bekleyiniz "));
    }

}
