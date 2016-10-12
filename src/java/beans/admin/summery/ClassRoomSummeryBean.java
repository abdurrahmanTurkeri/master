package beans.admin.summery;

import library.FacesUtilities;
import entity.ClassRoom;
import entity.School;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import repository.admin.ClassRoomRepository;
import repository.admin.SchoolRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@RequestScoped
public class ClassRoomSummeryBean implements Serializable{

    List<ClassRoom> classList;
    private long schoolId;

    public ClassRoomSummeryBean() {
        selectClassRoomList();
    }

    public List<ClassRoom> getClassRoomList() {
        return classList;
    }

    public void setClassRoomList(List<ClassRoom> classList) {
        this.classList = classList;
    }

    public List<ClassRoom> getClassList() {
        return classList;
    }

    public void setClassList(List<ClassRoom> classList) {
        this.classList = classList;
    }

    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(long schoolId) {
        this.schoolId = schoolId;
    }

    public void selectClassRoomList() {
        schoolId = FacesUtilities.getRequestParameter("schoolId", 0);
        selectClassRoomList(schoolId);
    }

    public void selectClassRoomList(long schoolId) {

        ClassRoomRepository schoolRepository = new ClassRoomRepository();
        if (schoolId != 0) {
            classList = schoolRepository.listBySchoolId(schoolId);
        } else {
            classList = schoolRepository.list();
        }
        schoolRepository.close();
    }

    public void filter() {
        selectClassRoomList(schoolId);
    }

    public List<School> getSchoolList() {
        SchoolRepository schoolRepository = new SchoolRepository();
        List<School> schoolList = schoolRepository.list();
        schoolRepository.close();
        return schoolList;
    }

}
