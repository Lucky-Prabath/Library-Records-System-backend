package lk.ijse.dep.web.library.business.custom.impl;

import lk.ijse.dep.web.library.business.SuperBO;
import lk.ijse.dep.web.library.business.custom.MemberBO;
import lk.ijse.dep.web.library.business.util.EntityDTOMapper;
import lk.ijse.dep.web.library.dao.DAOFactory;
import lk.ijse.dep.web.library.dao.DAOTypes;
import lk.ijse.dep.web.library.dao.custom.MemberDAO;
import lk.ijse.dep.web.library.dto.MemberDTO;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-05
 **/
public class MemberBOImpl implements MemberBO {

    private final MemberDAO memberDAO;
    private EntityManager em;
    private final EntityDTOMapper mapper = EntityDTOMapper.instance;

    public MemberBOImpl() {
        memberDAO = DAOFactory.getInstance().getDAO(DAOTypes.MEMBER);
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        memberDAO.setEntityManager(em);
    }

    @Override
    public void saveMember(MemberDTO dto) throws Exception {
        try {
            em.getTransaction().begin();
            memberDAO.save(mapper.getMember(dto));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }

    }

    @Override
    public void updateMember(MemberDTO dto) throws Exception {
        try {
            em.getTransaction().begin();
            memberDAO.update(mapper.getMember(dto));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void deleteMember(String memberId) throws Exception {
        try {
            em.getTransaction().begin();
            memberDAO.delete(memberId);
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public List<MemberDTO> getAllMembers() throws Exception {
        try {
            em.getTransaction().begin();
            List<MemberDTO> memberDTOS = mapper.getMemberDTOs(memberDAO.getAll());
            em.getTransaction().commit();
            return memberDTOS;
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public MemberDTO getMember(String memberId) throws Exception {
        try{
            em.getTransaction().begin();
            MemberDTO memberDTO = mapper.gerMemberDTO(memberDAO.get(memberId));
            em.getTransaction().commit();
            return memberDTO;
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }
}

