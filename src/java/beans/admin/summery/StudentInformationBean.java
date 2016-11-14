/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.admin.summery;

import entity.School;
import entity.StudentInformation;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import repository.admin.SchoolRepository;
import repository.admin.StudentInformationRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@RequestScoped
public class StudentInformationBean implements Serializable{
       List<StudentInformation> schoolList;
    private long selectedSchoolId;
    public StudentInformationBean() {
      selectSchoolList();
    }
    public List<StudentInformation> getSchoolList() {
        return schoolList;
    }
    public void setSchoolList(List<StudentInformation> schoolList) {
        this.schoolList = schoolList;
    }
    public long getSelectedSchoolId() {
        return selectedSchoolId;
    }

    public void setSelectedSchoolId(long selectedSchoolId) {
        this.selectedSchoolId = selectedSchoolId;
    }
     public void selectSchoolList() {
       
         StudentInformationRepository schoolRepository = new StudentInformationRepository();
        schoolList = schoolRepository.list();
     
        schoolRepository.close();
    }
    public void filter() {
        selectSchoolList();
    }
    

    
}
