package beans.admin.summery;
import entity.Teacher;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import repository.admin.TeacherRepository;

@ManagedBean
@RequestScoped
public class TeacherSummeryBean implements Serializable{
    private List<Teacher> teacherList;
    private long selectedClassRoomId;

    public TeacherSummeryBean() {
        selectteacherList();
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public long getSelectedClassRoomId() {
        return selectedClassRoomId;
    }

    public void setSelectedClassRoomId(long selectedClassRoomId) {
        this.selectedClassRoomId = selectedClassRoomId;
    }

    public long getselectedClassRoomId() {
        return selectedClassRoomId;
    }

    public void setselectedClassRoomId(long selectedClassRoomId) {
        this.selectedClassRoomId = selectedClassRoomId;
    }

   
    public void selectteacherList() {
        TeacherRepository employeeRepository = new TeacherRepository();
        if (selectedClassRoomId != 0) {
            teacherList = employeeRepository.listByDepartmentId(selectedClassRoomId);
        } else {
            teacherList = employeeRepository.list();
        }
        employeeRepository.close();
    }

    public void filter() {
        selectteacherList();
    }

}
