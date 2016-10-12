/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.admin.summery;

import entity.CourceContent;
import entity.Exam;
import entity.Subject;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import library.FacesUtilities;
import repository.admin.ExamRepository;
import repository.admin.CourceContentRepository;
import repository.admin.SubjectRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@ViewScoped
public class ExamDetailBean implements Serializable {

    private long selectedCourceContentId;
    private long selectedExamId;
    private long selectedSubjectId;
    List<Subject> subjectList;
    private Exam exam;
    private Subject subject;
    boolean courceContentFixed;
      boolean subjecttFixed;
    

    public ExamDetailBean() {
        selectedExamId = FacesUtilities.getRequestParameter("examId", 0);

        if (selectedExamId == 0) {
            exam = new Exam();
            exam.setStatus(0L);
            exam.setExamName("Adsiz");
        } else {
            ExamRepository examRepository = new ExamRepository();
            // System.out.println("Id "+sel);
            exam = examRepository.find(selectedExamId);
            System.out.println("Name " + exam.getExamName() + "Id  + " + exam.getExamId());
            examRepository.close();
        }
        long subjectId = FacesUtilities.getRequestParameter("subjectId", 0);

        if (subjectId != 0) {
            subjecttFixed=true;
            SubjectRepository subjectRepository = new SubjectRepository();
            subject = subjectRepository.find(subjectId);
            subjectRepository.close();
            exam.setSubject(subject);

        }
        selectedSubject();
        selectedCourceContentId = FacesUtilities.getRequestParameter("courceContentId", 0);
        System.err.println("1 inci "+selectedCourceContentId);
        if (selectedCourceContentId != 0) {
            courceContentFixed=true;
            setCourceContent();
        }

    }

    public long getSelectedCourceContentId() {
        return selectedCourceContentId;
    }

    public void setSelectedCourceContentId(long selectedCourceContentId) {
        this.selectedCourceContentId = selectedCourceContentId;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public void setCourceContent() {
        if (selectedCourceContentId != 0) {
               System.err.println("2 inci "+selectedCourceContentId);
            CourceContentRepository contentRepository = new CourceContentRepository();
            CourceContent cc = contentRepository.find(selectedCourceContentId);
            contentRepository.close();
            exam.setCourceContent(cc);
        }
    }

    public void setSubject() {
        if (selectedSubjectId != 0) {
            
            SubjectRepository subjectRepository = new SubjectRepository();
            Subject cc = subjectRepository.find(selectedSubjectId);
            subjectRepository.close();
            exam.setSubject(cc);
        }
    }
    public void selectedSubject() {
        try {
            SubjectRepository subjectRepo = new SubjectRepository();
            subjectList = subjectRepo.list();
            subjectRepo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void save() {
        try {
            long examId = FacesUtilities.getRequestParameter("examId", 0);
            setCourceContent();
            setSubject();
            ExamRepository examRepository = new ExamRepository();
                exam.setStatus(0L);
            if (examId == 0) {
                examRepository.persist(exam);
            } else {
                examRepository.merge(exam);
            }
            examRepository.close();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Basari ile kaydedildi"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("ExamSummery.xhtml");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bir yanlis lik oldu " + e.getMessage() + " " + getClass()));
        }
    }

    public long getSelectedExamId() {
        return selectedExamId;
    }

    public void setSelectedExamId(long selectedExamId) {
        this.selectedExamId = selectedExamId;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public long getSelectedSubjectId() {
        return selectedSubjectId;
    }

    public void setSelectedSubjectId(long selectedSubjectId) {
        this.selectedSubjectId = selectedSubjectId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public boolean isCourceContentFixed() {
        return courceContentFixed;
    }

    public void setCourceContentFixed(boolean courceContentFixed) {
        this.courceContentFixed = courceContentFixed;
    }

    public boolean isSubjecttFixed() {
        return subjecttFixed;
    }

    public void setSubjecttFixed(boolean subjecttFixed) {
        this.subjecttFixed = subjecttFixed;
    }
    
    
    
}
