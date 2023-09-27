package kr.co.kmarket.controller.admin.cs.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.service.cs.ArticleService;

@WebServlet("/admin/cs/qna/delete.do")
public class DeleteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	ArticleService service = ArticleService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] chks = req.getParameterValues("chk");
		
		for(String articleNo : chks) {
			service.deleteArticle(articleNo);
		}
		
		//리다이렉트
		resp.sendRedirect("/Kmarket/admin/cs/qna/list.do?group=qna");
	}
}
