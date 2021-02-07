package lk.ijse.dep.web.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-05
 **/

@Data @AllArgsConstructor @NoArgsConstructor
@Embeddable
public class BorrowPK implements Serializable {
    @Column(name = "member_id")
    private int memberId;
    @Column(name = "book_id")
    private int bookId;
}
