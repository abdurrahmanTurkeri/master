/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.admin;

import library.BaseRepository;
import entity.Exam;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author macintoshhd⁄
 */
public class ExamRepository extends BaseRepository<Exam> {

    public ExamRepository() {
        super(Exam.class);
    }
    public List<Exam> listFilter(long courceContentId) {
        String jpql = createSelectJpql()
                + " where exam.courceContent.classContentId = :courceContentId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("courceContentId", courceContentId);
        return query.getResultList();
    }
    public List<Exam> listBySubjectId(long subjectId) {

        String jpql = createSelectJpql()
                + " where exam.subject.subjectId = :subjectId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("subjectId", subjectId);
        return query.getResultList();

    }

    public List<Exam> listBySubjectIdNullCourceId(long subjectId) {
        String jpql = createSelectJpql()
                + " where exam.subject.subjectId = :subjectId and exam.courceContent is null";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("subjectId", subjectId);
        return query.getResultList();

    }
}
