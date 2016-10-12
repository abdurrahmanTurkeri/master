/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.portal;

import entity.Student;
import java.util.List;
import javax.persistence.Query;
import library.BaseRepository;

/**
 *
 * @author macintoshhd
 */
public class PortalRegisterRepository extends BaseRepository<Student>{

    public PortalRegisterRepository() {
        super(Student.class);
    }
    public List<Student> studentFilter(long classRoomId){
    String jpql= createSelectJpql()+"where student.classRoom.classRoomId = :classRoomId";
      Query query = entityManager.createQuery(jpql);
    query.setParameter("classRoomId", classRoomId);
    return query.getResultList();
    }
    
}
