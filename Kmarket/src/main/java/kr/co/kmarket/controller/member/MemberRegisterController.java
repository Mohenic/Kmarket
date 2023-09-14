package kr.co.kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.member.MemberDTO;
import kr.co.kmarket.dto.member.Member_termsDTO;
import kr.co.kmarket.service.member.MemberTermsService;
@WebServlet("/member/register.do")
public class MemberRegisterController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8447071860548753347L;
	MemberTermsService service = MemberTermsService.INSTANCE;
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		RequestDispatcher dispatcher=req.getRequestDispatcher("/member/register.jsp");
		dispatcher.forward(req, resp);
	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass2");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String hp = req.getParameter("hp");
		String zip = req.getParameter("zip");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String type = req.getParameter("type");
		String regip = req.getRemoteAddr();
		
		
		MemberDTO dto = new MemberDTO();
		dto.setUid(uid);
		dto.setPass(pass);
		dto.setName(name);
		dto.setGender(gender);
		dto.setEmail(email);
		dto.setHp(hp);
		dto.setZip(zip);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setType(type);
		dto.setRegip(regip);

		
		service.insertMember(dto);
		

		resp.sendRedirect("/Kmarket/member/login.do");
	
	}
	
	
	
	
}
