package lk.ijse.dep.web.library.dao.custom.impl;

import lk.ijse.dep.web.library.dao.custom.QueryDAO;

import javax.persistence.EntityManager;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-05
 **/
public class QueryDAOImpl implements QueryDAO {

    @Override
    public void setEntityManager(EntityManager em) {
        //todo: check this
    }
}
