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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author macintoshhd
 */
@Entity
public class ClassRoom extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long classRoomId;
    private String classRoomName;
    @ManyToOne
    @JoinColumn(name = "schoolId")
    private School school;
    @OneToOne
    private User classTeacher;

    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    private List<CourceContent> courceContentList;
    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    private List<Student> studentList;

    public long getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(long classRoomId) {
        this.classRoomId = classRoomId;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public User getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(User classTeacher) {
        this.classTeacher = classTeacher;
    }

    public List<CourceContent> getCourceContentList() {
        return courceContentList;
    }

    public void setCourceContentList(List<CourceContent> courceContentList) {
        this.courceContentList = courceContentList;
    }
    public List<Student> getStudentList() {
        return studentList;
    }
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

}
