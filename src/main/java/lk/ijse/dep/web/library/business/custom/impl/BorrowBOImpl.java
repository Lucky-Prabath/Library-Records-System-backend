package lk.ijse.dep.web.library.business.custom.impl;

import lk.ijse.dep.web.library.business.custom.BorrowBO;
import lk.ijse.dep.web.library.business.util.EntityDTOMapper;
import lk.ijse.dep.web.library.dao.DAOFactory;
import lk.ijse.dep.web.library.dao.DAOTypes;
import lk.ijse.dep.web.library.dao.custom.BookDAO;
import lk.ijse.dep.web.library.dao.custom.BorrowDAO;

import javax.persistence.EntityManager;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-05
 **/
public class BorrowBOImpl implements BorrowBO {

    private final BorrowDAO borrowDAO;
    private EntityManager em;
    private final EntityDTOMapper mapper = EntityDTOMapper.instance;

    public BorrowBOImpl() {
        borrowDAO = DAOFactory.getInstance().getDAO(DAOTypes.BORROW);
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        borrowDAO.setEntityManager(em);
    }

    @Override
    public void borrowBook() throws Exception {
        try {
            em.getTransaction().begin();
            //todo: complete the method
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }
}
