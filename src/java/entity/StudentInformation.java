/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import library.BaseEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author macintoshhd
 */
@Entity
public class StudentInformation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String studentName;
    private String studentNumber;
    private String teacheMail;
    private String schoolName;
    private String currentDate;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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


    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public StudentInformation() {
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public StudentInformation(long id, String studentName, String studentNumber, String teacheMail, String schoolName, String currentDate) {
        this.id = id;
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.teacheMail = teacheMail;
        this.schoolName = schoolName;
        this.currentDate = currentDate;
    }


}
