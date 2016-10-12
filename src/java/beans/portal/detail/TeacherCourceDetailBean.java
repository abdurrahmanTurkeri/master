/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.portal.detail;

import entity.Student;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import library.FacesUtilities;
import repository.admin.CourceContentRepository;
import repository.admin.StudentRepository;
import repository.portal.TeacherCourceDetailRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@ViewScoped
public class TeacherCourceDetailBean implements Serializable{
    private long selectedCourceContentId;
    private List<Student> studentList;

    public TeacherCourceDetailBean() {
        getResult();
    }
   
   
   public void getResult(){
        long courceContentId = FacesUtilities.getRequestParameter("classRoomId", 0);
        StudentRepository  studentRepo=new StudentRepository();
        studentList=studentRepo.listFilterClassRoom(courceContentId);
        studentRepo.close();
   }

    public long getSelectedCourceContentId() {
        return selectedCourceContentId;
    }

    public void setSelectedCourceContentId(long selectedCourceContentId) {
        this.selectedCourceContentId = selectedCourceContentId;
    }

   
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    
}
