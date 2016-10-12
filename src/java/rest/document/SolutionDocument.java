/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.document;

import entity.QuestionType;
import java.util.List;

/**
 *
 * @author macintoshhd
 */
public class SolutionDocument extends ResultDocument {

    private long solutionId;
    private long studentId;
    private String studentName;
    private long examId;
    private String examName;
    private String solutionDate;
    private String startTime;
    private String endTime;
    private long solutionStatus;
    private float result;
    private List<AnswerDocument> answerList;
    private QuestionType questionType;
    
    private float rate;

    public SolutionDocument() {
    }

    public SolutionDocument(long solutionId, long studentId, String studentName, long examId, String examName, String solutionDate, String startTime, String endTime, long solutionStatus, float result, List<AnswerDocument> answerList, QuestionType questionType, float rate) {
        this.solutionId = solutionId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.examId = examId;
        this.examName = examName;
        this.solutionDate = solutionDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.solutionStatus = solutionStatus;
        this.result = result;
        this.answerList = answerList;
        this.questionType = questionType;
        this.rate = rate;
    }

    
    
    
    
    public long getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(long solutionId) {
        this.solutionId = solutionId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getSolutionDate() {
        return solutionDate;
    }

    public void setSolutionDate(String solutionDate) {
        this.solutionDate = solutionDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public long getSolutionStatus() {
        return solutionStatus;
    }

    public void setSolutionStatus(long solutionStatus) {
        this.solutionStatus = solutionStatus;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public List<AnswerDocument> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<AnswerDocument> answerList) {
        this.answerList = answerList;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
    
}
