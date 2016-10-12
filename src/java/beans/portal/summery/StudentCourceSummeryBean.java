/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.portal.summery;

import entity.Student;
import entity.StudentCource;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;
import library.FacesUtilities;
import repository.admin.StudentCourceRepository;
import repository.admin.StudentRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@ViewScoped
public class StudentCourceSummeryBean implements Serializable{

    private long courceContentId;
    private Student student;
    private long selectedExamId;
    private List<StudentCource> studentCourceList;

    public StudentCourceSummeryBean() {
        getStudentData();
    }

    public void getStudentData() {

        HttpSession session = FacesUtilities.getSession();
        long studentId = Long.parseLong((String) session.getAttribute("studentId"));
        String teacherName = (String) session.getAttribute("studentName");
        
        if (studentId != 0) {
            StudentRepository studentRepository = new StudentRepository();
            student = studentRepository.find(studentId);
            studentRepository.close();
       
            System.out.println("Size "+student.getStudenCourceList().size());
            
            StudentCourceRepository studentCourceRepository=new StudentCourceRepository();
            studentCourceList=studentCourceRepository.filterByStudent(studentId);
            studentCourceRepository.close();
        }
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public long getCourceContentId() {
        return courceContentId;
    }

    public void setCourceContentId(long courceContentId) {
        this.courceContentId = courceContentId;
    }

    public long getSelectedExamId() {

        return selectedExamId;
    }

    public void setSelectedExamId(long selectedExamId) {
        this.selectedExamId = selectedExamId;
    }

    public List<StudentCource> getStudentCourceList() {
        return studentCourceList;
    }
     
    

}
