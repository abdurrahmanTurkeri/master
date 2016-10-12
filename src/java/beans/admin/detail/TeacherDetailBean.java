package beans.admin.detail;

import entity.User;
import library.FacesUtilities;
import entity.Teacher;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import repository.admin.TeacherRepository;
import repository.admin.UserRepository;
@ManagedBean
@ViewScoped
public class TeacherDetailBean implements Serializable{

    private Teacher teacher;
    private long selectedTeacherId;

    public long getSelectedTeacherId() {
        return selectedTeacherId;
    }

    public void setSelectedTeacherId(long selectedTeacherId) {
        this.selectedTeacherId = selectedTeacherId;
    }

   
    public TeacherDetailBean() {
        long teacherId = FacesUtilities.getRequestParameter("teacherId", 0);
        if (teacherId == 0) {
            teacher = new Teacher();
            User user=new User();
            teacher.setUser(user);
        
        } else {
            TeacherRepository TeacherRepository = new TeacherRepository();
            teacher = TeacherRepository.find(teacherId);
            
            TeacherRepository.close();
        }

    }

    public Teacher getTeacher() {
        return teacher;
    }
    public void setUser() {
        if (selectedTeacherId != 0) {
            UserRepository userRepository = new UserRepository();
            User user = userRepository.find(selectedTeacherId);
            userRepository.close();
            teacher.setUser(user);
        }
    }
    public void save() {
        try {
            long teacherId = FacesUtilities.getRequestParameter("teacherId", 0);
            setUser();
            TeacherRepository teacherRepository = new TeacherRepository();
            if (teacherId == 0) {
                teacherRepository.persist(teacher);
            } else {
                teacherRepository.merge(teacher);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Basari ile kaydedildi"));
            teacherRepository.close();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bir yanlis lik oldu " + e.getMessage() + " " + getClass()));
            e.printStackTrace();
        }
    }

}
