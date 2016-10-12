package beans.admin.detail;

import library.FacesUtilities;
import entity.ClassRoom;
import entity.CourceContent;
import entity.School;
import entity.Subject;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import repository.admin.ClassRoomRepository;
import repository.admin.CourceContentRepository;
import repository.admin.SchoolRepository;
import repository.admin.SubjectRepository;

@ManagedBean
@ViewScoped
public class ClassRoomDetailBean implements Serializable{
    private ClassRoom clasRoom;
    private long selectedSchoolId;
    public long getSelectedSchoolId() {
        return selectedSchoolId;
    }
    public void setSelectedSchoolId(long selectedSchoolId) {
        this.selectedSchoolId = selectedSchoolId;
    }
    public ClassRoomDetailBean() {
        long clasRoomId = FacesUtilities.getRequestParameter("classRoomId", 0);
        if (clasRoomId == 0) {
            clasRoom = new ClassRoom();
            clasRoom.setClassRoomName("Adsiz");
        } else {
            ClassRoomRepository ClassRoomRepository = new ClassRoomRepository();
            clasRoom = ClassRoomRepository.find(clasRoomId);
            ClassRoomRepository.close();
        }
    }
    public ClassRoom getClassRoom() {
        return clasRoom;
    }
    public List<Subject>  getMandatorySubject(){
        SubjectRepository subjectRepository=new SubjectRepository();
        List<Subject> subjects=subjectRepository.listByMandatory(true);
        subjectRepository.close();
        return subjects;
    }
    public void createNewCourceContent(){
        CourceContentRepository contentRepository=new CourceContentRepository();
        for(Subject subject:getMandatorySubject()){
            CourceContent courceContent=new CourceContent();
            courceContent.setClassContentName(subject.getSubjectName());
            courceContent.setClassRoom(clasRoom);
            contentRepository.persist(courceContent);
        }
        contentRepository.close();
    }
    public void setDepartment() {
        if (selectedSchoolId != 0) {
            SchoolRepository schoolRepository = new SchoolRepository();
            School school = schoolRepository.find(selectedSchoolId);
            schoolRepository.close();
            clasRoom.setSchool(school);
        }
    }

    public void save() {
        try {
            long classRoomId = FacesUtilities.getRequestParameter("classRoomId", 0);
            setDepartment();
            ClassRoomRepository ClassRoomRepository = new ClassRoomRepository();
            if (classRoomId == 0) {
                ClassRoomRepository.persist(clasRoom);
            } else {
                ClassRoomRepository.merge(clasRoom);
            }
            createNewCourceContent();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Basari ile kaydedildi"));
            ClassRoomRepository.close();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bir yanlis lik oldu " + e.getMessage() + " " + getClass()));
            e.printStackTrace();
        }
    }

}
