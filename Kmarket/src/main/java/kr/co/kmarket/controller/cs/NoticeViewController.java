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

@WebServlet("/cs/notice/view.do")
public class NoticeViewController extends HttpServlet {

	private static final long serialVersionUID = 6033683340170033123L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		
		req.setAttribute("group", group);
		req.setAttribute("cate", cate);
		req.setAttribute("index", "view");
		
		logger.debug("group = " + group);
		logger.debug("cate = " + cate);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/notice/view.jsp");
		dispatcher.forward(req, resp);
	}
}
