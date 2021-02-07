package lk.ijse.dep.web.library.business.custom;

import lk.ijse.dep.web.library.business.SuperBO;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-05
 **/
public interface BorrowBO extends SuperBO {

    void borrowBook() throws Exception;
}
