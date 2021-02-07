package lk.ijse.dep.web.library.dto;

import lk.ijse.dep.web.library.entity.Name;
import lk.ijse.dep.web.library.util.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-05
 **/

@Data @NoArgsConstructor @AllArgsConstructor
public class MemberDTO implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private String contactNo;
    private Gender gender;
}
