/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.admin;

import entity.Company;
import entity.Department;
import library.BaseRepository;
import entity.ClassRoom;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author macintoshhd
 */
public class ClassRoomRepository extends BaseRepository<ClassRoom> {

    public ClassRoomRepository() {
        super(ClassRoom.class);
    }
 public List<ClassRoom> listFilter(long schoolId) {
    String jpql = createSelectJpql()
            + " where classRoom.school.schoolId = :schoolId";
    Query query = entityManager.createQuery(jpql);
    query.setParameter("schoolId", schoolId);
    return query.getResultList();
  } 
  public List<ClassRoom> listBySchoolId(long schoolId) {
    String jpql = createSelectJpql()
            + " where classRoom.school.schoolId = :schoolId";
    Query query = entityManager.createQuery(jpql);
    query.setParameter("schoolId", schoolId);
    return query.getResultList();
  }
}
