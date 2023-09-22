package kr.co.kmarket.controller.admin.cs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.service.admin.adminArticleService;

@WebServlet("/admin/cs/notice/delete.do")
public class noticeDeleteController extends HttpServlet{
	
	private static final long serialVersionUID = -1109690995620287899L;
	private adminArticleService aService = adminArticleService.instance;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] chks = req.getParameterValues("chk");
		
		for(String articleNo : chks) {
			aService.deleteArticle(articleNo);
		}
		
		resp.sendRedirect("/Kmarket/admin/cs/notice/list.do");
		
	}

}
