package lk.ijse.dep.web.library.entity;

import lk.ijse.dep.web.library.util.Gender;
import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-05
 **/

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "member")
public class Member implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Embedded
    private Name name;
    @Column(name = "contact_no")
    private String contactNo;
    private Gender gender;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "member")
    private List<Borrow> borrowList;

    public Member(int id, Name name, String contactNo, Gender gender) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.gender = gender;
    }
}
