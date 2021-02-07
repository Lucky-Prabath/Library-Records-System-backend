package lk.ijse.dep.web.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-05
 **/

@Data @AllArgsConstructor @NoArgsConstructor
public class BorrowDTO implements Serializable {

    private int memberId;
    private int bookId;
    private Date date;
}
