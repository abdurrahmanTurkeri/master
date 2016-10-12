package beans.admin.summery;

import library.FacesUtilities;
import entity.Exam;
import entity.School;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import repository.admin.ExamRepository;
import repository.admin.SchoolRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@RequestScoped
public class ExamSummeryBean implements Serializable {

    List<Exam> examList;
    private long courceContentId;
    private long selectedSubjectId;

    public ExamSummeryBean() {
        selectExamList();
    }

    public void selectExamList() {
        courceContentId = FacesUtilities.getRequestParameter("courceContentId", 0);
        selectedSubjectId = FacesUtilities.getRequestParameter("subjectId", 0);
        if (selectedSubjectId != 0) {
            selectExamListBySubject(selectedSubjectId);
        } else {
            selectExamListByCource(courceContentId);
        }
    }

    public void selectExamListByCource(long courceContentId) {

        ExamRepository schoolRepository = new ExamRepository();
        if (courceContentId != 0) {
            examList = schoolRepository.listFilter(courceContentId);
        } else {
            examList = schoolRepository.list();
        }

        schoolRepository.close();
    }

    public void selectExamListBySubject(long subjectId) {

        ExamRepository schoolRepository = new ExamRepository();
        if (subjectId != 0) {
            examList = schoolRepository.listBySubjectId(subjectId);
        } else {
            examList = schoolRepository.list();
        }

        schoolRepository.close();
    }

//    public List<School> getSchoolList() {
//        SchoolRepository schoolRepository = new SchoolRepository();
//        List<School> schoolList = schoolRepository.list();
//        schoolRepository.close();
//        return schoolList;
//    }
    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    public long getCourceContentId() {
        return courceContentId;
    }

    public void setCourceContentId(long courceContentId) {
        this.courceContentId = courceContentId;
    }

}
