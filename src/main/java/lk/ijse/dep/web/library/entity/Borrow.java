package lk.ijse.dep.web.library.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-05
 **/

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "borrow")
public class Borrow implements SuperEntity{

    @EmbeddedId
    private BorrowPK borrowPK;
    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "member_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Member member;

    @ManyToOne
    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "book_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Book book;

    public Borrow(BorrowPK borrowPK, Date date) {
        this.borrowPK = borrowPK;
        this.date = date;
    }

    public Borrow(int memberId, int bookId, Date date) {
        this.borrowPK = new BorrowPK(memberId, bookId);
        this.date = date;
    }
}
