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
import kr.co.kmarket.service.member.MemberService;

@WebServlet("/member/registerSeller.do")
public class MemberRegisterSellerController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7829484824303131209L;


	MemberService service = MemberService.INSTANCE;
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		RequestDispatcher dispatcher=req.getRequestDispatcher("/member/registerSeller.jsp");
		dispatcher.forward(req, resp);
	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass2");
		String email = req.getParameter("email");
		String zip = req.getParameter("zip");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String company = req.getParameter("company");
		String ceo = req.getParameter("ceo");
		String bizregnum = req.getParameter("corpReg");
		String comregnum = req.getParameter("onlineReg");
		String tel = req.getParameter("tel");
		String manager = req.getParameter("manager");
		String managerhp = req.getParameter("managerhp");
		String fax = req.getParameter("fax");

		
		String type = req.getParameter("type");
		String regip = req.getRemoteAddr();
		
		
		MemberDTO dto = new MemberDTO();
		dto.setUid(uid);
		dto.setPass(pass);
		dto.setEmail(email);
		dto.setZip(zip);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setCompany(company);
		dto.setCeo(ceo);
		dto.setBizRegNum(bizregnum);
		dto.setComRegNum(comregnum);
		dto.setTel(tel);
		dto.setManager(manager);
		dto.setManagerHp(managerhp);
		dto.setFax(fax);
		dto.setType(type);
		dto.setRegip(regip);
		
		service.insertMember(dto);
		

		resp.sendRedirect("/Kmarket/member/login.do");
	
	}
	
	
	
	
}