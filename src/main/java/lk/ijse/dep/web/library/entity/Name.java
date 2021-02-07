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

@Embeddable
@AllArgsConstructor @NoArgsConstructor @Data
public class Name implements Serializable {

    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
}
