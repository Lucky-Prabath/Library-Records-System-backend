package lk.ijse.dep.web.library.dao;

import javax.persistence.EntityManager;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-05
 **/
public interface SuperDAO {

    void setEntityManager(EntityManager em);

}
