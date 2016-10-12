/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.admin;

import entity.Company;
import entity.Department;
import library.BaseRepository;
import entity.Teacher;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author macintoshhd
 */
public class TeacherRepository extends BaseRepository<Teacher> {

    public TeacherRepository() {
        super(Teacher.class);
    }
 public List<Teacher> listFilter(long courceContentId) {
    String jpql = createSelectJpql()
            + " where teacher.cource.courceContentId = :courceContentId";
    Query query = entityManager.createQuery(jpql);
    query.setParameter("courceContentId", courceContentId);
    return query.getResultList();
  } 
  public List<Teacher> listByDepartmentId(long courceContentId) {
    String jpql = createSelectJpql()
            + " where teacher.cource.courceContentId = :courceContentId";
    Query query = entityManager.createQuery(jpql);
    query.setParameter("courceContentId", courceContentId);
    return query.getResultList();
  }
}
