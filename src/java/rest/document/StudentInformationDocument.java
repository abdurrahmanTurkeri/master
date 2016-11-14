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
public class StudentInformationDocument implements Serializable {
private long id;
private String studentName;
private String studentNumber;
private String teacheMail;
private String isExisting;
private String currentDate;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getTeacheMail() {
        return teacheMail;
    }

    public void setTeacheMail(String teacheMail) {
        this.teacheMail = teacheMail;
    }

    public String getIsExisting() {
        return isExisting;
    }

    public void setIsExisting(String isExisting) {
        this.isExisting = isExisting;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public StudentInformationDocument() {
    }

    public StudentInformationDocument(String studentName, String studentNumber, String teacheMail, String isExisting, String currentDate) {
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.teacheMail = teacheMail;
        this.isExisting = isExisting;
        this.currentDate = currentDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    
    
}
