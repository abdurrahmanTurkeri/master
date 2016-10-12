package beans.portal.summery;

import entity.CourceContent;
import entity.Exam;
import entity.Teacher;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import library.FacesUtilities;
import repository.admin.CourceContentRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@RequestScoped
public class TeacherCourceContentSummeryBean implements Serializable {

    private List<CourceContent> courceContentList;
    private long currentTeacherId;
    private String studentSize;
    private long clasRoomId;
    private String userFullname;

    public String getStudentSize() {
        return studentSize;
    }

    public void setStudentSize(String studentSize) {
        this.studentSize = studentSize;
    }

    public TeacherCourceContentSummeryBean() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Unutmayınız! Öğrencilerin ödevleri çözebilmlerii için ödevleri başlatmanız gerekmektedir."));
        clasRoomId = FacesUtilities.getRequestParameter("classRoomId", 0);
        if (clasRoomId == 0) {
            selectCourceContentRoomList();
        } else {
            selectCourceContentRoomList();
        }
    }

    public List<CourceContent> getCourceContentList() {
        return courceContentList;
    }

    public void setCourceContentList(List<CourceContent> courceContentList) {
        this.courceContentList = courceContentList;
    }

    public long getCurrentTeacherId() {
        return currentTeacherId;
    }

    public void setCurrentTeacherId(long currentTeacherId) {
        this.currentTeacherId = currentTeacherId;
    }

    public void selectCourceContentRoomList() {
        //  currentTeacherId = FacesUtilities.getRequestParameter("teacherId", 0);
        HttpSession session = FacesUtilities.getSession();
        currentTeacherId = Long.parseLong((String) session.getAttribute("teacherId"));
        String teacherName = (String) session.getAttribute("teacherName");
        System.out.println(" currentTeacherId" + currentTeacherId);
        if (clasRoomId == 0) {
            selectCourceContentRoomList(currentTeacherId);
        } else {
            selectTeacherAndClassromFilterList(currentTeacherId, clasRoomId);
        }
    }

    public void selectTeacherAndClassromFilterList(long teacherId, long classRoomId) {
        CourceContentRepository courceContentRepository = new CourceContentRepository();
        courceContentList = courceContentRepository.listByTeacherAndClassRoomId(currentTeacherId, classRoomId);
        courceContentRepository.close();
        Teacher teacher = courceContentList.get(0).getTeacher();
        userFullname = teacher.getUser().getUserFirstName() + " " + teacher.getUser().getUserLastName();
        System.out.println("");
    }

    public void selectCourceContentRoomList(long id) {
        CourceContentRepository courceContentRepository = new CourceContentRepository();
        courceContentList = courceContentRepository.listByTeacherId(currentTeacherId);
        Teacher teacher = courceContentList.get(0).getTeacher();
        userFullname = teacher.getUser().getUserFirstName() + " " + teacher.getUser().getUserLastName();
        courceContentRepository.close();
        System.out.println(" courceContentList.size() " + courceContentList.size());
    }

    public void startExam(long examId) {
        Exam exam = courceContentList.get(0).getExamList().get(0);
    }

    public long getClasRoomId() {
        return clasRoomId;
    }

    public void setClasRoomId(long clasRoomId) {
        this.clasRoomId = clasRoomId;
    }

    public String getUserFullname() {
        return userFullname;
    }

    public void setUserFullname(String userFullname) {
        this.userFullname = userFullname;
    }

}
