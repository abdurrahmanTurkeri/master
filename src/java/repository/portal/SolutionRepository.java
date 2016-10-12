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
public class SolutionRepository extends BaseRepository<Solution> {

    public SolutionRepository() {
        super(Solution.class);
    }
    public Solution singleByStudentFilter(long solutionId) {
        try {
            String jpql = createSelectJpql()
                    + " where solution.solutionId = :solutionId ";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("solutionId", solutionId);
            return (Solution) query.getSingleResult();
        } catch (NoResultException e) {
           e.printStackTrace();
             return null;
        }
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
  
      public Solution filterByStudentAndExam(long examId, long studentId) {
        Solution solution=null;
         String jpql = createSelectJpql()
                + " where solution.exam.examId = :examId and  solution.student.studentId = :studentId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("examId", examId);
         query.setParameter("studentId", studentId);
         solution=(Solution)query.getSingleResult();
        return solution;
        
    }
      
        public List<Solution> filterByExamAndStudentid(long examId) {
   
         String jpql = createSelectJpql()
                + " where solution.exam.examId = :examId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("examId", examId);
        List<Solution> solutionlist=query.getResultList();
        return solutionlist;
        
    }
}
