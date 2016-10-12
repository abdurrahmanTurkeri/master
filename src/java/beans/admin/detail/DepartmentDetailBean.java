package beans.admin.detail;

import entity.Company;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import repository.admin.DeparmentRepository;
import entity.Department;
import java.io.Serializable;
import library.FacesUtilities;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import repository.admin.CompanyRepository;

    @ManagedBean
    @ViewScoped
public class DepartmentDetailBean implements Serializable{

    private Department deparment;
    private long selectedCompanyId;

    public long getSelectedDepartmentId() {
        return selectedCompanyId;
    }

    public void setSelectedDepartmentId(long selectedCompanyId) {
        this.selectedCompanyId = selectedCompanyId;
    }

    public DepartmentDetailBean() {
        long deparmentId = FacesUtilities.getRequestParameter("departmentId", 0);
        if (deparmentId == 0) {
            deparment = new Department();
            deparment.setDepartmentName("Adsiz");
        } else {
            DeparmentRepository deparmentRepository = new DeparmentRepository();
            deparment = deparmentRepository.find(deparmentId);
            deparmentRepository.close();
        }

    }

    public Department getDeparment() {
        return deparment;
    }

    public void setCompany() {
        if (selectedCompanyId != 0) {
            CompanyRepository companyRepository = new CompanyRepository();
            Company company = companyRepository.find(selectedCompanyId);
            companyRepository.close();
            deparment.setCompany(company);
        }
    }

    public void save() {
        try {
            long deparmentId = FacesUtilities.getRequestParameter("departmentId", 0);
            setCompany();
            DeparmentRepository deparmentRepository = new DeparmentRepository();
            if (deparmentId == 0) {
                deparmentRepository.persist(deparment);
            } else {
                deparmentRepository.merge(deparment);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Basari ile kaydedildi"));
            
            deparmentRepository.close();
            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bir yanlis lik oldu " + e.getMessage() + " " + getClass()));
        }

    }
}
