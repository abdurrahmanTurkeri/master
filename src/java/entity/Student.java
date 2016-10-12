/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.CourceContent;
import entity.User;
import java.util.List;
import library.BaseEntity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author macintoshhd
 */
@Entity
public class Student extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    private long courceContentId;
    @OneToOne(cascade = CascadeType.ALL)
    //Cascade all Ben bir islemi yaptgm da bunun icinde yap demek
    private User user;
    @ManyToOne
    @JoinColumn(name = "classRoom")
    private ClassRoom classRoom;
    private String dafCode;
    private String studentNumber;
    private String studentEmail;
    private String quardianPhoneNumber;
    private String quardianMailAdress;
    private String gcmToken;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<StudentCource> studenCourceList;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Solution> solutionList;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<StudentCource> getStudenCourceList() {
        return studenCourceList;
    }

    public void setStudenCourceList(List<StudentCource> studenCourceList) {
        this.studenCourceList = studenCourceList;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public List<Solution> getSolutionList() {
        return solutionList;
    }

    public void setSolutionList(List<Solution> solutionList) {
        this.solutionList = solutionList;
    }

    public String getDafCode() {
        return dafCode;
    }

    public void setDafCode(String dafCode) {
        this.dafCode = dafCode;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getQuardianPhoneNumber() {
        return quardianPhoneNumber;
    }

    public void setQuardianPhoneNumber(String quardianPhoneNumber) {
        this.quardianPhoneNumber = quardianPhoneNumber;
    }

    public String getQuardianMailAdress() {
        return quardianMailAdress;
    }

    public void setQuardianMailAdress(String quardianMailAdress) {
        this.quardianMailAdress = quardianMailAdress;
    }

    public String getGcmToken() {
        return gcmToken;
    }

    public void setGcmToken(String gcmToken) {
        this.gcmToken = gcmToken;
    }
    
    

}
