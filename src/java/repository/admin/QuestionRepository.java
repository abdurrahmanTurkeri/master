/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.admin;

import entity.Question;
import library.BaseRepository;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author macintoshhd
 */
public class QuestionRepository extends BaseRepository<Question> {

    public QuestionRepository() {
        super(Question.class);
    }
 public List<Question> listFilter(long examId) {
          System.out.println("Baslarken "+examId);
    String jpql = createSelectJpql()
            + " where question.exam.examId = :examId";
    Query query = entityManager.createQuery(jpql);
     System.out.println("Exam Id"+examId);
    query.setParameter("examId", examId);
     System.out.println("getResultList"+query.getResultList());
    return query.getResultList();
  } 
  
}
