/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.admin.summery;

import entity.Department;
import java.io.IOException;
import java.io.Serializable;
import library.FacesUtilities;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import repository.admin.DeparmentRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@RequestScoped
public class DepartmentSummeryBean implements Serializable{

    List<Department> departmentList;
    private long selectedDepartmentId;

    public DepartmentSummeryBean() throws IOException {
//        HttpSession session = FacesUtilities.getSession();
//        boolean loggedIn = session != null && session.getAttribute("userName") != null;
//      
//        if (loggedIn) {
            selectDepartmentList();
//        } else {
//            FacesContext.getCurrentInstance().getExternalContext().redirect("admin/authentication/AdminLogin.xhtml");
//        }

    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public long getSelectedDepartmentId() {
        return selectedDepartmentId;
    }

    public void setSelectedDepartmentId(long selectedDepartmentId) {
        this.selectedDepartmentId = selectedDepartmentId;
    }

    public void selectDepartmentList() {
        selectedDepartmentId = FacesUtilities.getRequestParameter("departmentId", 0);
        DeparmentRepository departmentRepository = new DeparmentRepository();
        if (selectedDepartmentId != 0) {
            departmentList = departmentRepository.listFilter(selectedDepartmentId);
        } else {
            departmentList = departmentRepository.list();
        }
        departmentRepository.close();
    }

    public void filter() {
        selectDepartmentList();
    }

}
