/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.portal;

import entity.Company;
import entity.Department;
import entity.Solution;
import library.BaseRepository;
import entity.Teacher;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author macintoshhd
 */
public class StudentGraphicxRepository extends BaseRepository<Solution> {

    public StudentGraphicxRepository() {
        super(Solution.class);
    }
   
  public List<Solution> listByStudentFilter(long studentId) {
        try {
            String jpql = createSelectJpql()
                    + " where solution.student.studentId = :studentId ";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("studentId", studentId);
            return  query.getResultList();
        } catch (NoResultException e) {
           e.printStackTrace();
             return null;
        }
    }
  
     
}
