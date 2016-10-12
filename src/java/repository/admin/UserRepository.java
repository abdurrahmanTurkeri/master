/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.admin;

import entity.User;
import library.BaseRepository;
import entity.School;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author macintoshhd
 */
public class UserRepository extends BaseRepository<User> {

    public UserRepository() {
        super(User.class);
    }
 public List<User> listFilter(long userId) {
    String jpql = createSelectJpql()
            + " where  user.userId = :userId";
    Query query = entityManager.createQuery(jpql);
    query.setParameter("userId", userId);
    return query.getResultList();
  } 
 
}
