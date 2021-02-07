package lk.ijse.dep.web.library.dao;

import lk.ijse.dep.web.library.dao.custom.impl.BookDAOImpl;
import lk.ijse.dep.web.library.dao.custom.impl.BorrowDAOImpl;
import lk.ijse.dep.web.library.dao.custom.impl.MemberDAOImpl;
import lk.ijse.dep.web.library.dao.custom.impl.QueryDAOImpl;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-05
 **/
public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){
    }

    public static DAOFactory getInstance(){
        return (daoFactory != null)? daoFactory: (daoFactory = new DAOFactory());
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoType){
        switch (daoType){
            case MEMBER:
                return (T) new MemberDAOImpl();
            case BOOK:
                return (T) new BookDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            case BORROW:
                return (T) new BorrowDAOImpl();
            default:
                return null;
        }
    }
}
