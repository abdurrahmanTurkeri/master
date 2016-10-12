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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author macintoshhd
 */
@Entity
public class CourceContent extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long classContentId;
    private String classContentName;
    @OneToMany(mappedBy = "courceContent", cascade = CascadeType.ALL)
    private List<Cource> courceList;
    @ManyToOne
    @JoinColumn(name = "teacherId")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "subjectId")
    private Subject subject;
    private long isCanList;
//    @OneToMany(mappedBy = "courceContent", cascade = CascadeType.ALL)
//    private List<Student> studentList;
    @OneToMany(mappedBy = "courceContent", cascade = CascadeType.ALL)
    private List<StudentCource> studenCourceList;

    @OneToMany(mappedBy = "courceContent", cascade = CascadeType.ALL)
    private List<Exam> examList;
    @ManyToOne
    @JoinColumn(name = "classRoomId")
    private ClassRoom classRoom;

    public long getClassContentId() {
        return classContentId;
    }

    public void setClassContentId(long classContentId) {
        this.classContentId = classContentId;
    }

    public String getClassContentName() {
        return classContentName;
    }

    public void setClassContentName(String classContentName) {
        this.classContentName = classContentName;
    }

    public List<Cource> getCourceList() {
        return courceList;
    }

    public void setCourceList(List<Cource> courceList) {
        this.courceList = courceList;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

//    public List<Student> getStudentList() {
//        return studentList;
//    }
//
//    public void setStudentList(List<Student> studentList) {
//        this.studentList = studentList;
//    }
    public List<StudentCource> getStudenCourceList() {
        return studenCourceList;
    }

    public void setStudenCourceList(List<StudentCource> studenCourceList) {
        this.studenCourceList = studenCourceList;
    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public long getIsCanList() {
        return isCanList;
    }

    public void setIsCanList(long isCanList) {
        this.isCanList = isCanList;
    }

}
