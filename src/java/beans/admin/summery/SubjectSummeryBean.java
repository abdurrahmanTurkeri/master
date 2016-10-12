/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.admin.summery;
import entity.Subject;
import java.io.Serializable;
import library.FacesUtilities;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import repository.admin.SubjectRepository;
/**
 *
 * @author macintoshhd
 */
@ManagedBean
@RequestScoped
public class SubjectSummeryBean implements Serializable{
   private  List<Subject> subjectLsit;
    private long selectedSubject;
    
    @PostConstruct
    public void init() {
        selectCourceList();
    }

    public List<Subject> getSubjectLsit() {
        return subjectLsit;
    }

    public void setSubjectLsit(List<Subject> subjectLsit) {
        this.subjectLsit = subjectLsit;
    }

   
    
    
    public long getSelectedSubject() {
        return selectedSubject;
    }

    public void setSelectedSubject(long selectedSubject) {
        this.selectedSubject = selectedSubject;
    }
   
    public void selectCourceList() {
        long subjectId = FacesUtilities.getRequestParameter("subjectId", 0);
        SubjectRepository subjectRepository = new SubjectRepository();
           if (subjectId != 0) {
                //subjectLsit = courceRepository.listByClasRoomId(subjectId);
            } else {
                subjectLsit = subjectRepository.list();
            } 
        subjectRepository.close();
    }

}
