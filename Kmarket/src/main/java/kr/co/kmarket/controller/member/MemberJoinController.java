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

import kr.co.kmarket.service.member.MemberService;



@WebServlet("/member/join.do")
public class MemberJoinController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3464963494518560371L;

	private Logger logger =LoggerFactory.getLogger(this.getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		RequestDispatcher dispatcher=req.getRequestDispatcher("/member/join.jsp");
		dispatcher.forward(req, resp);

	}

	
	
	
}