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
public class DeparmentRepository extends BaseRepository<Department> {

    public DeparmentRepository() {
        super(Department.class);
    }
 public List<Department> listFilter(long departmentId) {
    String jpql = createSelectJpql()
            + " where department.company.companyId = :departmentId";
    Query query = entityManager.createQuery(jpql);
    query.setParameter("departmentId", departmentId);
    return query.getResultList();
  } 
  
}
