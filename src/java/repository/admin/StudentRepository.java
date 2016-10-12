/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.admin;

import entity.Company;
import entity.Department;
import entity.Solution;
import library.BaseRepository;
import entity.Student;
import entity.Teacher;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author macintoshhd
 */
public class StudentRepository extends BaseRepository<Student> {

    public StudentRepository() {
        super(Student.class);
    }

    public List<Student> listFilter(long courceContentId) {
        String jpql = createSelectJpql()
                + " where student.cource.courceContentId = :courceContentId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("courceContentStudentId", courceContentId);
        return query.getResultList();
    }

    public List<Student> listFilterClassRoom(long classRoomId) {
        String jpql = createSelectJpql()
                + " where student.classRoom.classRoomId = :classRoomId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("classRoomId", classRoomId);
        return query.getResultList();
    }

    public Student checkStudent(String dafCode) {
        Student student = null;
        try {
            String jpql = createSelectJpql()
                    + " where student.dafCode = :dafCode";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("dafCode", dafCode);
            student = (Student) query.getSingleResult();
        } catch (Exception e) {
            student = null;
        }
        return student;
    }

//    public Student studentFilter(long studentId) {
//        String jpql = createSelectJpql()
//                + " where student.studentId = :studentId";
//        Query query = entityManager.createQuery(jpql);
//        query.setParameter("studentId", studentId);
//        return (Student) query.getSingleResult();
//    }
}
