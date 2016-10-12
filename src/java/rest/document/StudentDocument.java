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
public class StudentDocument implements Serializable {

    private long studentId;
    private long userId;
    private String userName;
    private String studentName;
    private long classRoomId;
    private String dafCode;
    private String studentNumber;
    private String studentEmail;
    private String quardianPhoneNumber;
    private String quardianMailAdress;

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

    public long getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(long classRoomId) {
        this.classRoomId = classRoomId;
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

    public StudentDocument() {
    }

    public StudentDocument(long studentId, String studentName, long classRoomId, String dafCode, String studentNumber, String studentEmail, String quardianPhoneNumber, String quardianMailAdress) {
        this.studentId = studentId;
        this.studentName = studentName;

        this.classRoomId = classRoomId;
        this.dafCode = dafCode;
        this.studentNumber = studentNumber;
        this.studentEmail = studentEmail;
        this.quardianPhoneNumber = quardianPhoneNumber;
        this.quardianMailAdress = quardianMailAdress;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
