/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.admin.detail;

import beans.admin.summery.SubjectSummeryBean;
import entity.Exam;
import entity.Question;
import entity.QuestionType;
import entity.Subject;
import entity.User;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import library.FacesUtilities;
import repository.admin.ExamRepository;
import repository.admin.QuestionRepository;
import repository.admin.SubjectRepository;
import repository.admin.UserRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@ViewScoped
public class QuestionDetailBean implements Serializable {

    private long selectedExamId;
    private long selectedQuestionId;
    private Question question;
    private List<QuestionType> questionTypeList;

    public QuestionDetailBean() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Unutmayin !\n Sorularin Puan toplami 100 Olmalidir "));
        long questionId = FacesUtilities.getRequestParameter("questionId", 0);
        selectedExamId = FacesUtilities.getRequestParameter("examId", 0);
        if (questionId == 0) {
            question = new Question();
            question.setText("Yeni Soru Giriniz");
            question.setOptionCount(4);
       
        } else {
            QuestionRepository repository = new QuestionRepository();
            question = repository.find(questionId);
            repository.close();
        }
        question.formatCorrectList();
    }

    public void setExam() {
        if (selectedExamId != 0) {
            ExamRepository examRepository = new ExamRepository();
            Exam exam = examRepository.find(selectedExamId);
            question.setExam(exam);
            examRepository.close();
        }
    }
//
//    public void setQuestion() {
//
//        if (selectedQuestionId != 0) {
//            QuestionRepository questionRepository = new QuestionRepository();
//            question = questionRepository.find(selectedQuestionId);
//            questionRepository.close();
//
//        }
//
//    }

    public void save() {
        try {
            setExam();
          if(question.getCorrectCount()>1){
            question.parseCorrectList();
          }
            QuestionRepository questionRepository = new QuestionRepository();
            questionRepository.persist(question);
            questionRepository.close();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Basari ile kaydedildi"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("QuestionSummery.xhtml?examId=" + selectedExamId);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bir yanlis lik oldu " + e.getMessage() + " " + getClass()));
        }
    }


    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public long getSelectedExamId() {
        return selectedExamId;
    }

    public void setSelectedExamId(long selectedExamId) {
        this.selectedExamId = selectedExamId;
    }

    public long getSelectedQuestionId() {
        return selectedQuestionId;
    }

    public void setSelectedQuestionId(long selectedQuestionId) {
        this.selectedQuestionId = selectedQuestionId;
    }

    public List<QuestionType> getQuestionTypeList() {
        return Arrays.asList(QuestionType.values());
    }

    public void setQuestionTypeList(List<QuestionType> questionTypeList) {
        this.questionTypeList = questionTypeList;
    }

}
