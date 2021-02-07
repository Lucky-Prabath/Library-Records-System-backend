package lk.ijse.dep.web.library.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-05
 **/

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "book")
public class Book implements SuperEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String category;
    private String author;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "book")
    private List<Borrow> borrowList;

}
