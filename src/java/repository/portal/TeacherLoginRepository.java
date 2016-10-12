/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.portal;

import entity.Company;
import entity.Department;
import library.BaseRepository;
import entity.Teacher;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author macintoshhd
 */
public class TeacherLoginRepository extends BaseRepository<Teacher> {

    public TeacherLoginRepository() {
        super(Teacher.class);
    }
    public Teacher listFilter(String userName) {
        try {
            String jpql = createSelectJpql()
                    + " where teacher.user.userName = :userName";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("userName", userName);
            return (Teacher) query.getSingleResult();
        } catch (NoResultException e) {
           e.printStackTrace();
             return null;
        }
    }

}
