/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.admin;

import library.BaseRepository;
import entity.StudentCource;
import java.util.List;
import javax.persistence.Query;
/**
 *
 * @author macintoshhd
 */
public class StudentCourceRepository extends BaseRepository<StudentCource> {

    public StudentCourceRepository() {
        super(StudentCource.class);
    }
 public List<StudentCource> filterByStudent(long studentId) {
    String jpql = createSelectJpql()
            + " where  studentCource.student.studentId = :studentId";
    Query query = entityManager.createQuery(jpql);
    query.setParameter("studentId", studentId);
    return query.getResultList();
  } 
  public List<StudentCource> filterByCourceContent(long courceContentId) {
    String jpql = createSelectJpql()
            + " where  studentCource.courceContent.courceContentId = :courceContentId";
    Query query = entityManager.createQuery(jpql);
    query.setParameter("courceContentId", courceContentId);
    return query.getResultList();
  } 
 
}
