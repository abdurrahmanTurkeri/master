/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import library.BaseEntity;

/**
 *
 * @author macintoshhd
 */
@Entity
public class StudentCource extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentCourceId;
    @ManyToOne
    @JoinColumn(name = "courceContentId")
    private CourceContent courceContent;
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    public long getStudentCourceId() {
        return studentCourceId;
    }

    public void setStudentCourceId(long studentCourceId) {
        this.studentCourceId = studentCourceId;
    }

    public CourceContent getCourceContent() {
        return courceContent;
    }

    public void setCourceContent(CourceContent courceContent) {
        this.courceContent = courceContent;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
