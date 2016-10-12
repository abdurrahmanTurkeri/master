/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.admin;

import entity.CourceContent;
import library.BaseRepository;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author macintoshhd
 */
public class CourceContentRepository extends BaseRepository<CourceContent> {

    public CourceContentRepository() {
        super(CourceContent.class);
    }

    public List<CourceContent> listByClasRoomId(long classRoomId) {
        String jpql = createSelectJpql()
                + " where courceContent.classRoom.classRoomId = :classRoomId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("classRoomId", classRoomId);
        return query.getResultList();
    }
    public List<CourceContent> listByTeacherId(long teacherId) {
        String jpql = createSelectJpql()
                + " where courceContent.teacher.teacherId = :teacherId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("teacherId", teacherId);
        return query.getResultList();
    }
    public List<CourceContent> listByTeacherAndClassRoomId(long teacherId,long classRoomId) {
        String jpql = createSelectJpql()
                + " where courceContent.teacher.teacherId = :teacherId and courceContent.classRoom.classRoomId = :classRoomId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("teacherId", teacherId);
         query.setParameter("classRoomId", classRoomId);
        return query.getResultList();
    }
    public List<CourceContent> listBySubjectId(long subjectId) {
        String jpql = createSelectJpql()
                + " where courceContent.subject.subjectId = :subjectId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("subjectId", subjectId);
        return query.getResultList();
    }

}
