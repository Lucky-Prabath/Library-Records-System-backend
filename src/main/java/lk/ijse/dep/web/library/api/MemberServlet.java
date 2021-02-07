package lk.ijse.dep.web.library.api;

import lk.ijse.dep.web.library.business.BOFactory;
import lk.ijse.dep.web.library.business.BOTypes;
import lk.ijse.dep.web.library.business.custom.BookBO;
import lk.ijse.dep.web.library.business.custom.MemberBO;
import lk.ijse.dep.web.library.dto.BookDTO;
import lk.ijse.dep.web.library.dto.MemberDTO;
import lk.ijse.dep.web.library.entity.Member;
import lk.ijse.dep.web.library.exception.HttpResponseException;
import lk.ijse.dep.web.library.exception.ResponseExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-06
 **/

@WebServlet(name = "MemberServlet",urlPatterns = "/api/v1/members/*")
public class MemberServlet  extends HttpServlet {

    final Logger logger = LoggerFactory.getLogger(MemberServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            super.service(req, resp);
        }catch (Throwable t){
            ResponseExceptionUtil.handle(t, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();

        final EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        try {
            resp.setContentType("application/json");
            MemberBO memberBO = BOFactory.getInstance().getBO(BOTypes.MEMBER);
            memberBO.setEntityManager(em);
            resp.getWriter().println(jsonb.toJson(memberBO.getAllMembers()));
        } catch (Throwable t) {
            ResponseExceptionUtil.handle(t, resp);
        }finally {
            em.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        final EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        try {
            MemberDTO dto =  jsonb.fromJson(req.getReader(), MemberDTO.class);
                //todo: check the better option:- include "Name" to dto or include "firstname and lastname"
            if(dto.getFirstName().trim().isEmpty() || dto.getLastName().trim().isEmpty() ||
                    dto.getContactNo().trim().isEmpty() || dto.getGender() == null ){
                throw new HttpResponseException(400, "Invalid member details", null);
            }

            MemberBO memberBO = BOFactory.getInstance().getBO(BOTypes.MEMBER);
            memberBO.setEntityManager(em);
            memberBO.saveMember(dto);
            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.setContentType("application/json");
            resp.getWriter().println(jsonb.toJson(dto));
        }catch (SQLIntegrityConstraintViolationException exp){
            throw  new HttpResponseException(400, "Duplicate entry", exp);
        }catch (JsonbException exp){
            throw  new HttpResponseException(400, "Failed to read the json", exp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            em.close();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        final EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        try{
            if(req.getPathInfo() == null || req.getPathInfo().replace("/", "").trim().isEmpty()){
                throw new HttpResponseException(400, "Invalid member id", null);
            }

            String id = req.getPathInfo().replace("/","");
            MemberDTO dto = jsonb.fromJson(req.getReader(), MemberDTO.class);

            if(dto.getFirstName().trim().isEmpty() || dto.getLastName().trim().isEmpty() ||
                    dto.getContactNo().trim().isEmpty() || dto.getGender() == null){
                throw  new HttpResponseException(400, "Invalid details", null);
            }

            MemberBO memberBO = BOFactory.getInstance().getBO(BOTypes.MEMBER);
            memberBO.setEntityManager(em);
            memberBO.updateMember(dto);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }catch (JsonbException exp){
            throw new HttpResponseException(400, "Failed to read the json", exp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            em.close();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        try{

            if(req.getPathInfo() == null || req.getPathInfo().replace("/", "").trim().isEmpty()){
                throw new HttpResponseException(400, "Invalid course id", null);
            }

            String id = req.getPathInfo().replace("/", "");

            MemberBO memberBO = BOFactory.getInstance().getBO(BOTypes.MEMBER);
            memberBO.setEntityManager(em);
            memberBO.deleteMember(id);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            em.close();
        }
    }
}
