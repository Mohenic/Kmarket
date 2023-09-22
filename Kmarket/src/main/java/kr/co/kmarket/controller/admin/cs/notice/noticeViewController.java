package kr.co.kmarket.controller.admin.cs.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.admin.adminArticleDTO;
import kr.co.kmarket.service.admin.adminArticleService;

@WebServlet("/admin/cs/notice/view.do")
public class noticeViewController extends HttpServlet {

	private static final long serialVersionUID = -707406373816466644L;
	
	private adminArticleService aService = adminArticleService.instance;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		String type = req.getParameter("type");
		String no = req.getParameter("no");
		
		
		adminArticleDTO article = aService.selectArticle(no);

		if(type == null) {
			type = "0";
		}
		
		logger.debug(article.toString());
		
		req.setAttribute("article", article);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/notice/view.jsp");
		dispatcher.forward(req, resp);
	}

}
