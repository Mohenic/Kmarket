package kr.co.kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.member.MemberDTO;
import kr.co.kmarket.service.member.MemberService;



@WebServlet("/member/login.do")
public class MemberLoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3464963494518560371L;
	MemberService service = MemberService.INSTANCE;
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String success = req.getParameter("success");
		req.setAttribute("success", success);

		RequestDispatcher dispatcher=req.getRequestDispatcher("/member/login.jsp");
		dispatcher.forward(req, resp);

	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uid=req.getParameter("uid");
		String pass=req.getParameter("pass");
		
		logger.info("pass : "+pass);
		MemberDTO login =service.selectMember(uid, pass);
		
		logger.info("login : "+login);
		
		if(login != null) {
			
			HttpSession session=req.getSession();
			session.setAttribute("sessUser",login);
			resp.sendRedirect("/Kmarket");
		}else {
			resp.sendRedirect("/Kmarket/member/login.do?success=100");
		}
	
	
	}
	
	
	
}