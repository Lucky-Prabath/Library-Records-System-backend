package lk.ijse.dep.web.library.business;

import lk.ijse.dep.web.library.business.custom.impl.BookBOImpl;
import lk.ijse.dep.web.library.business.custom.impl.BorrowBOImpl;
import lk.ijse.dep.web.library.business.custom.impl.MemberBOImpl;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-05
 **/
public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return (boFactory == null) ? (boFactory = new BOFactory()) : boFactory;
    }

    public <T extends SuperBO> T getBO(BOTypes boTypes){
        switch (boTypes){
            case MEMBER:
                return (T) new MemberBOImpl();
            case BOOK:
                return (T) new BookBOImpl();
            case BORROW:
                return (T) new BorrowBOImpl();
            default:
                return null;
        }
    }
}
