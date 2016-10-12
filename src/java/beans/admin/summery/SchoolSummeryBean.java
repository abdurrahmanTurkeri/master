/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.admin.summery;

import entity.School;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import repository.admin.SchoolRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@RequestScoped
public class SchoolSummeryBean implements Serializable{
       List<School> schoolList;
    private long selectedSchoolId;
    public SchoolSummeryBean() {
      selectSchoolList();
    }
    public List<School> getSchoolList() {
        return schoolList;
    }
    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }
    public long getSelectedSchoolId() {
        return selectedSchoolId;
    }

    public void setSelectedSchoolId(long selectedSchoolId) {
        this.selectedSchoolId = selectedSchoolId;
    }
     public void selectSchoolList() {
         
        SchoolRepository schoolRepository = new SchoolRepository();
        if (selectedSchoolId != 0) {
           schoolList = schoolRepository.listByDepartmentId(selectedSchoolId);
        } else {
            schoolList = schoolRepository.list();
        }
        schoolRepository.close();
    }
    public void filter() {
        selectSchoolList();
    }
    

    
}
