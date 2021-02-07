package lk.ijse.dep.web.library.business.custom;

import lk.ijse.dep.web.library.business.SuperBO;
import lk.ijse.dep.web.library.dto.BookDTO;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-05
 **/
public interface BookBO extends SuperBO {

    void saveBook(BookDTO dto) throws Exception;

    void updateBook(BookDTO dto) throws Exception;

    void deleteBook(String bookId) throws Exception;

    List<BookDTO> getAllBooks() throws Exception;

    BookDTO getBook(String bookId) throws Exception;
}
