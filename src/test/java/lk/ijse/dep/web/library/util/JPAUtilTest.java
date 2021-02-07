package lk.ijse.dep.web.library.util;

import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-07
 **/
public class JPAUtilTest {

    @Test
    public void getEntityManagerFactory() {
        assertNotNull(JPAUtil.getEntityManagerFactory());
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        assertNotNull(entityManager);
        if (entityManager != null){
            entityManager.close();
        }
    }

    @Test
    public void getDataSource() {
        assertNotNull(JPAUtil.getDataSource());
    }
}
