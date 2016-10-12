/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.portal.auth;

import entity.ClassRoom;
import entity.CourceContent;
import entity.School;
import entity.Student;
import entity.StudentCource;
import entity.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import library.FacesUtilities;
import repository.portal.AjaxSchoolSelectionRepository;
import repository.admin.CourceContentRepository;
import repository.admin.StudentCourceRepository;
import repository.admin.StudentRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@ViewScoped
public class AjaxSchoolSelectionBean implements Serializable {

    List<School> schoolList;
    List<ClassRoom> classRoomList;
    private long currentSchoolId = 0;
    private long currentClassRoomId = 0;
    private School currentSchool;
    private ClassRoom currentClassRoom;
    private Student student;

    List<StudentCource> studentCourceList = new ArrayList<>();
    private User user;

    public AjaxSchoolSelectionBean() {
        AjaxSchoolSelectionRepository repository = new AjaxSchoolSelectionRepository();
        schoolList = repository.selectSchoolList();
        student = new Student();
        user = new User();
    }

    public List<School> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }

    public List<ClassRoom> getClassRoomList() {
        if (classRoomList != null) {
            System.out.println(" classRoomList  GET : " + classRoomList.size());
        }
        return classRoomList;

    }

    public void setClassRoomList(List<ClassRoom> classRoomList) {
        this.classRoomList = classRoomList;
    }

    public long getCurrentSchoolId() {
        return currentSchoolId;
    }

    public void setCurrentSchoolId(long currentSchoolId) {
        this.currentSchoolId = currentSchoolId;
        System.out.println("current scool Id  " + currentSchoolId);
        if (currentSchoolId == 0) {
            currentClassRoomId = 0;
            classRoomList = new ArrayList<>();
            return;
        }
        AjaxSchoolSelectionRepository repository = new AjaxSchoolSelectionRepository();
        currentSchool = repository.selectSchool(currentSchoolId);
        classRoomList = currentSchool.getClassRoomList();
        System.out.println("classRoomList SET: " + classRoomList.size());
    }

    public long getCurrentClassRoomId() {
        return currentClassRoomId;
    }

    public void setCurrentClassRoomId(long currentClassRoomId) {
        this.currentClassRoomId = currentClassRoomId;
        System.out.println("currentClassRoomId : " + currentClassRoomId);
        AjaxSchoolSelectionRepository ajaxSchoolSelectionRepository = new AjaxSchoolSelectionRepository();
        currentClassRoom = ajaxSchoolSelectionRepository.selectClassRoom(currentClassRoomId);
        System.out.println("Currnt clasrom : " + currentClassRoom.toString());
    }

    public School getCurrentSchool() {
        return currentSchool;
    }

    public void setCurrentSchool(School currentSchool) {
        this.currentSchool = currentSchool;
    }

    public ClassRoom getCurrentClassRoom() {
        return currentClassRoom;
    }

    public void setCurrentClassRoom(ClassRoom currentClassRoom) {
        this.currentClassRoom = currentClassRoom;
    }

//    public void setUser() {
//
//        UserRepository userRepository = new UserRepository();
//        User user = userRepository.find(selectedStudentId);
//        userRepository.close();
//        student.setUser(user);
//
//    }
    public void setMyCourceList(List<CourceContent> courceContents) {
        StudentCourceRepository courceRepository = new StudentCourceRepository();
        for (CourceContent cc : courceContents) {
            StudentCource studentCource = new StudentCource();
            studentCource.setCourceContent(cc);
            studentCource.setStudent(student);
            courceRepository.persist(studentCource);
        }
        courceRepository.close();
    }
    public void saveStudent() {
        HttpSession session = FacesUtilities.getSession();
      // String dafCode = (String) session.getAttribute("studentId");
        String dafCode = (String) session.getAttribute("dafCode");
        StudentRepository studentRepository = new StudentRepository();
        Student suStudent = studentRepository.checkStudent(dafCode);
        try {
            if (suStudent == null) {
                student.setClassRoom(currentClassRoom);
                student.setUser(user);
                student.setDafCode(dafCode);
                studentRepository.persist(student);
                studentRepository.close();
                writeSession();
                List<CourceContent> contents = getClassCourceContentList();
                System.out.println("Cource Lisr Size 1 " + contents.size());
                setMyCourceList(contents);
                FacesContext.getCurrentInstance().getExternalContext().redirect("../StudentCourceContentSummery.xhtml");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Basari ile kaydedildi"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bu kod Daha once kullanılmış"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bir yanlis lik oldu " + e.getMessage() + " " + getClass()));
        }

    }

    public List<CourceContent> getClassCourceContentList() {
        CourceContentRepository contentRepository = new CourceContentRepository();
        List<CourceContent> contents = contentRepository.listByClasRoomId(student.getClassRoom().getClassRoomId());
        contentRepository.close();
        return contents;
    }

    public void writeSession() {
        HttpSession session = FacesUtilities.getSession();
        session.setAttribute("studentId", "" + student.getStudentId());
        session.setAttribute("studentName", "" + student.getUser().getUserName());
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<StudentCource> getStudentCourceList() {
        return studentCourceList;
    }

    public void setStudentCourceList(List<StudentCource> studentCourceList) {
        this.studentCourceList = studentCourceList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
