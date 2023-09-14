package kr.co.kmarket.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import kr.co.kmarket.service.member.MemberService;



@WebServlet("/member/checkUid.do")
public class UidCheckController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3464963494518560371L;
	private MemberService service = MemberService.INSTANCE;
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String uid=req.getParameter("uid");

		int result =service.selectCountUid(uid);

		
		logger.info("result : "+result);
	
		JsonObject json = new JsonObject();
		json.addProperty("result", result);

		// Json 출력
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
		

	}

	
	
	
}