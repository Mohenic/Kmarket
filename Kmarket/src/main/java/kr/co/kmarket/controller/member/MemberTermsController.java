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

import kr.co.kmarket.dto.member.Member_termsDTO;
import kr.co.kmarket.service.member.MemberTermsService;
@WebServlet("/member/signup.do")
public class MemberTermsController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8447071860548753347L;
	MemberTermsService service = MemberTermsService.INSTANCE;
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		
		Member_termsDTO dto =service.selectTerms(type);
		req.setAttribute("type", type);
		req.setAttribute("dto", dto);
		
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/member/signup.jsp");
		dispatcher.forward(req, resp);
	
		
	}
	
	
	
	
}
