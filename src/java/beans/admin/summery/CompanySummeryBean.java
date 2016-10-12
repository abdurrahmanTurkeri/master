/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.admin.summery;

import entity.Company;
import entity.Department;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import repository.admin.CompanyRepository;
import repository.admin.DeparmentRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@RequestScoped
public class CompanySummeryBean implements Serializable {
       List<Company> companyList;
    private long selectCompanyId;

    public CompanySummeryBean() {
        try {
                 selectCompanyList();
        } catch (Exception e) {
            System.out.println("Hata "+e.getMessage());
        }
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public long getSelectCompanyId() {
        return selectCompanyId;
    }

    public void setSelectCompanyId(long selectCompanyId) {
        this.selectCompanyId = selectCompanyId;
    }

     public void selectCompanyList() {
         CompanyRepository companyRepository = new CompanyRepository();
        if (selectCompanyId != 0) {
           companyList = companyRepository.listFilter(selectCompanyId);
        } else {
            companyList = companyRepository.list();
        }
        companyRepository.close();
    }

    public void filter() {
        selectCompanyList();
    }

    
}
