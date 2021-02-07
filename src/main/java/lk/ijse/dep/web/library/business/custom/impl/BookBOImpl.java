package lk.ijse.dep.web.library.business.custom.impl;

import lk.ijse.dep.web.library.business.custom.BookBO;
import lk.ijse.dep.web.library.business.util.EntityDTOMapper;
import lk.ijse.dep.web.library.dao.DAOFactory;
import lk.ijse.dep.web.library.dao.DAOTypes;
import lk.ijse.dep.web.library.dao.custom.BookDAO;
import lk.ijse.dep.web.library.dao.custom.BookDAO;
import lk.ijse.dep.web.library.dto.BookDTO;
import lk.ijse.dep.web.library.dto.BookDTO;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-05
 **/
public class BookBOImpl implements BookBO {

    private final BookDAO bookDAO;
    private EntityManager em;
    private final EntityDTOMapper mapper = EntityDTOMapper.instance;

    public BookBOImpl() {
         bookDAO = DAOFactory.getInstance().getDAO(DAOTypes.BOOK);
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        bookDAO.setEntityManager(em);
    }

    @Override
    public void saveBook(BookDTO dto) throws Exception {
        try {
            em.getTransaction().begin();
            bookDAO.save(mapper.getBook(dto));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }

    }

    @Override
    public void updateBook(BookDTO dto) throws Exception {
        try {
            em.getTransaction().begin();
            bookDAO.update(mapper.getBook(dto));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void deleteBook(String bookId) throws Exception {
        try {
            em.getTransaction().begin();
            bookDAO.delete(bookId);
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public List<BookDTO> getAllBooks() throws Exception {
        try {
            em.getTransaction().begin();
            List<BookDTO> bookDTOS = mapper.getBookDTOs(bookDAO.getAll());
            em.getTransaction().commit();
            return bookDTOS;
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public BookDTO getBook(String bookId) throws Exception {
        try{
            em.getTransaction().begin();
            BookDTO bookDTO = mapper.getBookDTO(bookDAO.get(bookId));
            em.getTransaction().commit();
            return bookDTO;
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }
}
