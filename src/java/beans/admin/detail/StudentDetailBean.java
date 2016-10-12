package beans.admin.detail;

import entity.User;
import library.FacesUtilities;
import entity.Student;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import repository.admin.StudentRepository;
import repository.admin.UserRepository;
@ManagedBean
@ViewScoped
public class StudentDetailBean implements Serializable{

    private Student student;
    private long selectedStudentId;
    private long courceContentId;

    public long getCourceContentId() {
        return courceContentId;
    }

    public void setCourceContentId(long courceContentId) {
        this.courceContentId = courceContentId;
    }

    public long getSelectedStudentId() {
        return selectedStudentId;
    }

    public void setSelectedStudentId(long selectedStudentId) {
        this.selectedStudentId = selectedStudentId;
    }

   
    public StudentDetailBean() {
        long studentId = FacesUtilities.getRequestParameter("studentId", 0);
        if (studentId == 0) {
            student = new Student();
            User user=new User();
            student.setUser(user);
        
        } else {
            StudentRepository StudentRepository = new StudentRepository();
            student = StudentRepository.find(studentId);
            
            StudentRepository.close();
        }

    }

    public Student getStudent() {
        return student;
    }
    public void setUser() {
        if (selectedStudentId != 0) {
            UserRepository userRepository = new UserRepository();
            User user = userRepository.find(selectedStudentId);
            userRepository.close();
            student.setUser(user);
        }
    }
//    public void setCourceContent(){
//        if(courceContentId!=0){
//            CourceContentRepository courceRepository=new CourceContentRepository();
//            CourceContent courceContent=courceRepository.find(courceContentId);
//            student.setCourceContent(courceContent);
//        }
//        
//    }
    public void save() {
        try {
            long studentId = FacesUtilities.getRequestParameter("studentId", 0);
            setUser();
          //  setCourceContent();
            StudentRepository studentRepository = new StudentRepository();
            if (studentId == 0) {
                studentRepository.persist(student);
            } else {
                studentRepository.merge(student);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Basari ile kaydedildi"));
            studentRepository.close();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bir yanlis lik oldu " + e.getMessage() + " " + getClass()));
            e.printStackTrace();
        }
    }

}
