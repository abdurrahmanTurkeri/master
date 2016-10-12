/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.admin;

import library.BaseRepository;
import entity.School;
import entity.Subject;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author macintoshhd
 */
public class SubjectRepository extends BaseRepository<Subject> {

    public SubjectRepository() {
        super(Subject.class);
    }
 public List<Subject> listByMandatory(boolean mandatory) {
    String jpql = createSelectJpql()
            + " where subject.mandatory = :mandatory";
    Query query = entityManager.createQuery(jpql);
    query.setParameter("mandatory", mandatory);
    return query.getResultList();
  } 
  
}
