/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.admin;

import entity.Cource;
import library.BaseRepository;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author macintoshhd
 */
public class CourceRepository extends BaseRepository<Cource> {

    public CourceRepository() {
        super(Cource.class);
    }

  public List<Cource> listByClasRoomId(long courceContentId) {
    String jpql = createSelectJpql()
            + " where cource.courceContent.courceContentId = :courceContentId";
    Query query = entityManager.createQuery(jpql);
    query.setParameter("courceContentId", courceContentId);
    return query.getResultList();
  }
}
