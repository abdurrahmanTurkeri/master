/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.admin;

import entity.Company;
import entity.Department;
import entity.Teacher;
import library.BaseRepository;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author macintoshhd
 */
public class TeacherClassRoomRepository extends BaseRepository<Teacher> {

    public TeacherClassRoomRepository() {
        super(Teacher.class);
    }
 public List<Teacher> listFilter(long classRoomId) {
    String jpql = createSelectJpql()
            + " where teacher.classRoom.classRoomId = :classRoomId";
    Query query = entityManager.createQuery(jpql);
    query.setParameter("classRoomId", classRoomId);
    return query.getResultList();
  } 
  
}
