/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.portal;
import entity.Student;
import library.BaseRepository;
import javax.persistence.NoResultException;
import javax.persistence.Query;
/**
 *
 * @author macintoshhd
 */
public class StudentLoginRepository extends BaseRepository<Student> {

    public StudentLoginRepository() {
        super(Student.class);
    }
//    public Student listFilter(String userName) {
//   
//            String jpql = createSelectJpql()
//                    + " where student.user.userName = :userName";
//            Query query = entityManager.createQuery(jpql);
//            query.setParameter("userName", userName);
//            return (Student) query.getSingleResult();
//   
//    }
    public Student listFilter(String username) {
        try {
            String jpql = createSelectJpql()
                    + " where student.user.userName = :userName";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("userName", username);
            return (Student) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    public Student listFilterByUserNameAndPassword(String username, String userPassword) {
        System.out.println("repository.portal.StudentLoginRepository.listFilterByUserNameAndPassword() name "+username+"  "+userPassword );
        try {
            String jpql = createSelectJpql()
                    + " where student.user.userName = :userName  and  student.user.userPassword = :userPassword";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("userName", username);
            query.setParameter("userPassword", userPassword);
            return (Student) query.getSingleResult();
        } catch (NoResultException e) {
             System.out.println("repository.portal.StudentLoginRepository.listFilterByUserNameAndPassword() null dondu sonuc");
            return null;
        }
    }
}
