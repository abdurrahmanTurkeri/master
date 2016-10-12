/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.portal.detail;

import entity.CourceContent;
import entity.Solution;
import entity.Student;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import library.FacesUtilities;
import repository.admin.CourceContentRepository;
import repository.admin.StudentRepository;
import repository.portal.SolutionRepository;
import repository.portal.TeacherCourceDetailRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@ViewScoped
public class TeacherCourceDetailBeanByExam implements Serializable {

    private long classRoomId;
    private long examId;
    private List<Student> studentList;
   private Solution solution;

    public TeacherCourceDetailBeanByExam() {
        getResult();
    }

    public void getResult() {
         examId = FacesUtilities.getRequestParameter("examId", 0);
        classRoomId = FacesUtilities.getRequestParameter("classRoomId", 0);
        System.out.println("beans.portal.detail.TeacherCourceDetailBeanByExam.getResult()" + classRoomId);
        CourceContentRepository contentRepository=new CourceContentRepository();
        CourceContent content=contentRepository.find(classRoomId);
        contentRepository.close();
        long classId=content.getClassRoom().getClassRoomId();
        System.out.println("beans.portal.detail.TeacherCourceDetailBeanByExam.getResult()Sinif No"+classId);
        StudentRepository studentRepo = new StudentRepository();
        studentList = studentRepo.listFilterClassRoom(classId);
        //SolutionRepository solutionRepository=new SolutionRepository();
        
         studentRepo.close();
//        SolutionRepository solutionRepository=new SolutionRepository();
//        solution=solutionRepository.singleByStudentFilter(st);
        
    }

    public long getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(long classRoomId) {
        this.classRoomId = classRoomId;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
    }

  

}
