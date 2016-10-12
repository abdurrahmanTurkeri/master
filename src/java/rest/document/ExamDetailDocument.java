/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.document;

import java.io.Serializable;

/**
 *
 * @author macintoshhd
 */
public class ExamDetailDocument implements Serializable{
    private long examId;
    private String examName;
    private String examChart;
    private long teacherId;
    private long courceContentId;
    private Long status;
    private String examStartDate;
    private String examEndDate;

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

    public String getExamChart() {
        return examChart;
    }

    public void setExamChart(String examChart) {
        this.examChart = examChart;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public long getCourceContentId() {
        return courceContentId;
    }

    public void setCourceContentId(long courceContentId) {
        this.courceContentId = courceContentId;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getExamStartDate() {
        return examStartDate;
    }

    public void setExamStartDate(String examStartDate) {
        this.examStartDate = examStartDate;
    }

    public String getExamEndDate() {
        return examEndDate;
    }

    public void setExamEndDate(String examEndDate) {
        this.examEndDate = examEndDate;
    }
   
    
    
    

}
