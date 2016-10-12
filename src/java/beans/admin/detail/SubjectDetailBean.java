package beans.admin.detail;

import library.FacesUtilities;
import entity.Subject;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import repository.admin.SubjectRepository;

@ManagedBean
@ViewScoped
public class SubjectDetailBean implements Serializable{

    private Subject subject;
    private boolean selectedMandatory;
  

    public SubjectDetailBean() {
        long subjectId = FacesUtilities.getRequestParameter("subjectId", 0);
        if (subjectId == 0) {
            subject = new Subject();
            subject.setSubjectName("Adsiz");
        } else {
            SubjectRepository subjectRepository = new SubjectRepository();
            subject = subjectRepository.find(subjectId);
            subjectRepository.close();
        }

    }
    public void save() {
        try {
            long subjectId = FacesUtilities.getRequestParameter("subjectId", 0);
          
             SubjectRepository subjectRepository = new SubjectRepository();
            if (subjectId == 0) {
             
                subject.setMandatory(selectedMandatory);
                subjectRepository.persist(subject);
            } else {
                subjectRepository.merge(subject);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Basari ile kaydedildi"));
            subjectRepository.close();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bir yanlis lik oldu " + e.getMessage() + " " + getClass()));

        }
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public boolean isSelectedMandatory() {
        return selectedMandatory;
    }

    public void setSelectedMandatory(boolean selectedMandatory) {
        this.selectedMandatory = selectedMandatory;
    }

}
