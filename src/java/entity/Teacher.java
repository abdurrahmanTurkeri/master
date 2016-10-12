/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.CourceContent;
import entity.User;
import library.BaseEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author macintoshhd
 */
@Entity
public class Teacher extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;
    private String gsmNumber;
    private String email;
    private boolean isCanCall;
    
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<CourceContent> courceContentList;
    
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Exam> examList;

    public List<CourceContent> getCourceContentList() {
        return courceContentList;
    }

    public void setCourceContentList(List<CourceContent> courceContentList) {
        this.courceContentList = courceContentList;
    }

    @OneToOne(cascade = CascadeType.ALL)
    //Cascade all Ben bir islemi yaptgm da bunun icinde yap demek
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }



    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    public String getGsmNumber() {
        return gsmNumber;
    }

    public void setGsmNumber(String gsmNumber) {
        this.gsmNumber = gsmNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsCanCall() {
        return isCanCall;
    }

    public void setIsCanCall(boolean isCanCall) {
        this.isCanCall = isCanCall;
    }
    
    

}
