package kr.co.kmarket.controller.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/cs/qna/view.do")
public class QnaViewController extends HttpServlet {

	private static final long serialVersionUID = 7853938763561354917L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String group = req.getParameter("group");
		
		req.setAttribute("group", group);
		req.setAttribute("index", "view");
		
		logger.debug("group = " + group);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/qna/view.jsp");
		dispatcher.forward(req, resp);
	}
}
