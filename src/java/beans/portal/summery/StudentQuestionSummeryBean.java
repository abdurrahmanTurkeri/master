/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.portal.summery;

import entity.Answer;
import entity.Exam;
import entity.Question;
import entity.Solution;
import entity.Student;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;
import library.FacesUtilities;
import repository.admin.ExamRepository;
import repository.admin.StudentRepository;
import repository.portal.SolutionRepository;
import utils.DateUtils;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@ViewScoped
public class StudentQuestionSummeryBean implements Serializable {

    private Solution solution;
    private Student currentStudent;
    private boolean isStart;
    Exam currentExam;
    private long currentExamId;
    private boolean isShownResult;
    private boolean isStartExam;
    private String userName;
    private String[] corrects;

    public StudentQuestionSummeryBean() {
        currentExamId = FacesUtilities.getRequestParameter("examId", 0);
        System.out.println("Kurucu " + currentExamId);
        //getExamQuestionList();
        currentExam = selectExam(currentExamId);
        currentStudent = selectStudent(Long.parseLong(FacesUtilities.getSessionAtturubute("studentId")));
        System.out.println("Student Id " + currentStudent.getStudentId());

        try {
            SolutionRepository solutionRepository = new SolutionRepository();
            solution = solutionRepository.filterByStudentAndExam(currentExam.getExamId(), currentStudent.getStudentId());
            solutionRepository.close();
        } catch (NoResultException e) {
            generateSolution(currentExam);
        }

    }

    public Exam selectExam(long examId) {
        System.out.println("Exam Ids " + examId);
        if (examId != 0) {
            ExamRepository examRepository = new ExamRepository();
            Exam exam = examRepository.find(examId);
            examRepository.close();
            isShownResult = DateUtils.isAfterDate(exam.getExamEndDate());
            isStartExam = DateUtils.isAfterDate(exam.getExamStartDate());
            System.out.println("Is statt Exam" + isStartExam);
            System.out.println("isShownResult " + isShownResult);
            return exam;
        } else {
            return null;
        }
    }

    public Student selectStudent(long studentId) {
        StudentRepository studentRepository = new StudentRepository();
        Student student = studentRepository.find(studentId);
        studentRepository.close();
        return student;
    }
  
    private void generateSolution(Exam exam) {
        solution = new Solution();
        solution.setExam(exam);
        solution.setStudent(currentStudent);
        solution.setAnswerList(new ArrayList<Answer>());
        //  solution.setSolutionStatus(1);
        System.out.println("beans.portal.summery.StudentQuestionSummeryBean.generateSolution()" + solution.getSolutionStatus());
        for (Question question : solution.getExam().getQuestionList()) {
            Answer answer = new Answer();
            answer.setSolution(solution);
            answer.setQuestion(question);
            solution.getAnswerList().add(answer);
        }
        persistSolution();
    }

    private void persistSolution() {
        SolutionRepository solutionRepository = new SolutionRepository();
        solutionRepository.persist(solution);
        solutionRepository.close();
    }

    private void mergeSolution() throws IOException {
        SolutionRepository solutionRepository = new SolutionRepository();
        solutionRepository.merge(solution);
        solutionRepository.close();
        FacesContext.getCurrentInstance().getExternalContext().redirect("StudentQuestionsSummery.xhtml?examId=" + solution.getExam().getExamId());

        // FacesContext.getCurrentInstance().getExternalContext().redirect("StudentExamSummery.xhtml");
    }
//
//    private void complete() {
//
//        solution.setResult(0);
//
//        for (Answer answer : solution.getAnswerList()) {
//
//            if (answer.getAnswer1().equals(answer.getQuestion().getCorrrect1())) {
//
//                solution.setResult(solution.getResult() + 1);
//
//            }
//        }
//
//    }

    public Student getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(Student currentStudent) {
        this.currentStudent = currentStudent;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    public boolean isIsStart() {
        return isStart;
    }

    public void setIsStart(boolean isStart) {
        this.isStart = isStart;
    }

    public void startExam() throws IOException {
        isStart = true;
        solution.setSolutionStatus(1);
        solution.setStartTime(FacesUtilities.currentDare());

        SolutionRepository solutionRepository = new SolutionRepository();
        solutionRepository.merge(solution);
        System.out.println("beans.portal.summery.StudentQuestionSummeryBean.startExam()" + solution.getSolutionStatus());
        solutionRepository.close();
        FacesContext.getCurrentInstance().getExternalContext().redirect("StudentQuestionsSummery.xhtml?examId=" + solution.getExam().getExamId());
    }

    public void generetaExam() {
        ExamRepository exmExamRepository = new ExamRepository();
        exmExamRepository.merge(currentExam);
    }

    public void finishExam() throws IOException {
        System.out.println("beans.portal.summery.StudentQuestionSummeryBean.finishExam()" + " Girdi ");
        if (solution != null) {
            try {
                System.out.println("beans.portal.summery.StudentQuestionSummeryBean.finishExam()" + "if e Girdi ");
                solution.setSolutionStatus(2);
                // solution.setResult(0);
                solution.setEndTime(FacesUtilities.currentDare());
                for (Answer answer : solution.getAnswerList()) {
                    float point = answer.getPoint();
                    System.out.println("Answer Id" + answer.getAnswerId());
                    System.out.println("PUAN DURUMU " + point);
                    solution.setQuestionType(answer.getQuestion().getQuestionType());
                    solution.setResult(solution.getResult() + point);

                }
                solution.setRate(solution.getResult());

                mergeSolution();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        //     FacesContext.getCurrentInstance().getExternalContext().redirect("StudentQuestionsSummery.xhtml?examId=" + solution.getExam().getExamId());

    }

    public long getCurrentExamId() {
        return currentExamId;
    }

    public void setCurrentExamId(long currentExamId) {
        this.currentExamId = currentExamId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String[] getCorrects() {
        return corrects;
    }

    public void setCorrects(String[] corrects) {
        this.corrects = corrects;

    }

    public boolean isIsShownResult() {
        return isShownResult;
    }

    public void setIsShownResult(boolean isShownResult) {
        this.isShownResult = isShownResult;
    }

    public boolean isIsStartExam() {
        return isStartExam;
    }

    public void setIsStartExam(boolean isStartExam) {
        this.isStartExam = isStartExam;
    }

}
