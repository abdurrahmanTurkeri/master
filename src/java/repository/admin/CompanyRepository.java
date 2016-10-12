/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.admin;

import entity.Company;
import entity.Department;
import library.BaseRepository;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author macintoshhd
 */
public class CompanyRepository extends BaseRepository<Company> {

    public CompanyRepository() {
        super(Company.class);
    }

    public List<Company> listFilter(long companyId) {
        String jpql = createSelectJpql()
                + " where company.companyId = :companyId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("companyId", companyId);
        return query.getResultList();
    }

}
