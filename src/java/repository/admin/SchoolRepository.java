/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.admin;

import library.BaseRepository;
import entity.School;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author macintoshhd
 */
public class SchoolRepository extends BaseRepository<School> {

    public SchoolRepository() {
        super(School.class);
    }
 public List<School> listFilter(long departmentId) {
    String jpql = createSelectJpql()
            + " where school.department.departmentId = :departmentId";
    Query query = entityManager.createQuery(jpql);
    query.setParameter("departmentId", departmentId);
    return query.getResultList();
  } 
  public List<School> listByDepartmentId(long departmentId) {
    String jpql = createSelectJpql()
            + " where school.department.departmentId = :departmentId";
    Query query = entityManager.createQuery(jpql);
    query.setParameter("departmentId", departmentId);
    return query.getResultList();
  }
}
