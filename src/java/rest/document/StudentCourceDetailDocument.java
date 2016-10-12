/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.document;

import entity.CourceContent;
import entity.Student;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author macintoshhd
 */
public class StudentCourceDetailDocument implements Serializable{
  
    private long studentCourceId;
    private String courceContentName;
    private long studentId;
    private String classRoomName;
    private long classRoomId;

    public StudentCourceDetailDocument() {
    }

    public StudentCourceDetailDocument(long studentCourceId, String courceContentName, long studentId, String classRoomName, long classRoomId) {
        this.studentCourceId = studentCourceId;
        this.courceContentName = courceContentName;
        this.studentId = studentId;
        this.classRoomName = classRoomName;
        this.classRoomId = classRoomId;
    }

    public long getStudentCourceId() {
        return studentCourceId;
    }

    public void setStudentCourceId(long studentCourceId) {
        this.studentCourceId = studentCourceId;
    }

    public String getCourceContentName() {
        return courceContentName;
    }

    public void setCourceContentName(String courceContentName) {
        this.courceContentName = courceContentName;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public long getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(long classRoomId) {
        this.classRoomId = classRoomId;
    }

  


    
}
