package lk.ijse.dep.web.library.business.custom;

import lk.ijse.dep.web.library.business.SuperBO;
import lk.ijse.dep.web.library.dto.MemberDTO;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-05
 **/
public interface MemberBO extends SuperBO {

    void saveMember(MemberDTO dto) throws Exception;

    void updateMember(MemberDTO dto) throws Exception;

    void deleteMember(String memberId) throws Exception;

    List<MemberDTO> getAllMembers() throws Exception;

    MemberDTO getMember(String memberId) throws Exception;
}
