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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import library.FacesUtilities;
import repository.admin.CourceContentRepository;
import repository.admin.ExamRepository;
import repository.admin.QuestionRepository;
import utils.DateUtils;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@ViewScoped
public class ExamInformationBean implements Serializable {

    private long courceContentId;
    private List<Exam> examList;
    String startDates, endDates;

    public ExamInformationBean() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Unutmayınız! Başlangıç ve bitiş tarıhlerini seçmeniz gerekmektedir ."));

        getMyExam();
    }

    public long getCourceContentId() {
        return courceContentId;
    }

    public void setCourceContentId(long courceContentId) {
        this.courceContentId = courceContentId;
    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    public void getMyExam() {
        courceContentId = FacesUtilities.getRequestParameter("courceContentId", 0);
        if (courceContentId != 0) {
            ExamRepository examRepository = new ExamRepository();
            examList = examRepository.listFilter(courceContentId);
            examRepository.close();
        }

    }

    public void startExamStatus() {
        try {
            long examId = FacesUtilities.getRequestParameter("examId", 0);
            System.out.println("beans.portal.summery.ExamInformationBean.startExamStatus()" + examId);
            ExamRepository examRepository = new ExamRepository();
            Exam exam = examRepository.find(examId);
            exam.setStatus(1L);
            exam.setExamStartDate(startDates);
            exam.setExamEndDate(endDates);
            examRepository.merge(exam);
            examRepository.close();
            FacesContext.getCurrentInstance().getExternalContext().redirect("ExamInformationSummery.xhtml?courceContentId=" + courceContentId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getStartDates() {
        return startDates;
    }

    public void setStartDates(String startDates) {
        String val = DateUtils.formatDate(startDates);
        this.startDates = val;
    }

    public String getEndDates() {
        return endDates;
    }

    public void setEndDates(String endDates) {
        String val = DateUtils.formatDate(endDates);
        this.endDates = val;

    }

}
