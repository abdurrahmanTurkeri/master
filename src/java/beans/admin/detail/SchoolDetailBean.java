package beans.admin.detail;

import entity.Department;
import library.FacesUtilities;
import entity.School;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import repository.admin.DeparmentRepository;
import repository.admin.DeparmentRepository;
import repository.admin.SchoolRepository;

@ManagedBean
@ViewScoped
public class SchoolDetailBean implements Serializable{

    private School school;
    private long selectedDepartmentId;

    public long getSelectedDeparmentId() {
        return selectedDepartmentId;
    }

    public void setSelectedDeparmentId(long selectedDepartmentId) {
        this.selectedDepartmentId = selectedDepartmentId;
    }

    public SchoolDetailBean() {
        long schoolId = FacesUtilities.getRequestParameter("schoolId", 0);
        if (schoolId == 0) {

            school = new School();
            school.setSchoolName("Adsiz");
        } else {
            SchoolRepository schoolRepository = new SchoolRepository();
            school = schoolRepository.find(schoolId);
            schoolRepository.close();
        }

    }

    public School getSchool() {
        return school;
    }

    public void setDepartment() {
        if (selectedDepartmentId != 0) {
            DeparmentRepository departmentRepository = new DeparmentRepository();
            Department company = departmentRepository.find(selectedDepartmentId);
            departmentRepository.close();
            school.setDepartment(company);
        }
    }
    public void delete() throws IOException{
     long schoolId = FacesUtilities.getRequestParameter("schoolId", 0);
     
       SchoolRepository schoolRepository = new SchoolRepository();
       schoolRepository.remove(schoolId);
       schoolRepository.close();
        FacesContext.getCurrentInstance().getExternalContext().redirect("SchoolSummery.xhtml");
    }

    public void save() {
        try {
            long schoolId = FacesUtilities.getRequestParameter("schoolId", 0);
            setDepartment();
            SchoolRepository schoolRepository = new SchoolRepository();
            if (schoolId == 0) {
                schoolRepository.persist(school);
            } else {
                schoolRepository.merge(school);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Basari ile kaydedildi"));
            schoolRepository.close();
          
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bir yanlis lik oldu " + e.getMessage() + " " + getClass()));

        }
    }

}
