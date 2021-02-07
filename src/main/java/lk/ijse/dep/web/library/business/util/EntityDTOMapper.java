package lk.ijse.dep.web.library.business.util;

import lk.ijse.dep.web.library.dao.custom.MemberDAO;
import lk.ijse.dep.web.library.dto.BookDTO;
import lk.ijse.dep.web.library.dto.BorrowDTO;
import lk.ijse.dep.web.library.dto.MemberDTO;
import lk.ijse.dep.web.library.entity.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-05
 **/
public interface EntityDTOMapper {

    EntityDTOMapper instance = Mappers.getMapper(EntityDTOMapper.class);

    @Mapping(source = ".", target = "name")
    Member getMember(MemberDTO dto);

    Book getBook(BookDTO dto);

    MemberDTO gerMemberDTO(Member member);

    BookDTO getBookDTO(Book book);

    List<MemberDTO> getMemberDTOs(List<Member> members);

    List<BookDTO> getBookDTOs(List<Book> books);

    @Mapping(source = ".", target = "borrowPK")
    Borrow getBorrow(BorrowDTO dto);

    @InheritInverseConfiguration
    @Mapping(source = ".", target = "memberId", qualifiedByName = "memberId")
    @Mapping(source = ".", target = "bookId", qualifiedByName = "bookId")
    BorrowDTO getBorrow(Borrow borrow);

    /*to get member from dto*/
    default Name getName(MemberDTO dto){
        return new Name(dto.getFirstName(), dto.getLastName());
    }

    /*to get memberDto from member*/
    default String getFirstName(Member member){
        return member.getName().getFirstName();
    }

    default String getLastName(Member member){
        return member.getName().getLastName();
    }

    /*method for get Borrow*/
    default BorrowPK getBorrowPK(BorrowDTO dto){
        return new BorrowPK(dto.getMemberId(), dto.getBookId());
    }

    /*method for get BorrowDTO*/
    @Named("memberId")
    default int getMemberId(Borrow borrow){
        return borrow.getBorrowPK().getMemberId();
    }

    @Named("bookId")
    default int getBookId(Borrow borrow){
        return borrow.getBorrowPK().getBookId();
    }

}
