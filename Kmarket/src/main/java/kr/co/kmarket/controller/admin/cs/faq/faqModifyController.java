package kr.co.kmarket.controller.admin.cs.faq;

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

@WebServlet("/admin/cs/faq/modify.do")
public class faqModifyController extends HttpServlet {
	
	private static final long serialVersionUID = 5952818361843085900L;
	private adminArticleService aService = adminArticleService.instance;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String type = req.getParameter("type");
		String no = req.getParameter("no");
		
	
		
		
		adminArticleDTO article = aService.selectArticle(no);

		if(type == null) {
			type = "0";
		}
		
		logger.debug(article.toString());
		
		req.setAttribute("article", article);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/faq/modify.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		String no = req.getParameter("no");
		
		logger.debug("group" + group);
		logger.debug("no" + no);
		
		String cate = req.getParameter("cate");
		String type = req.getParameter("type");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		logger.debug("cate" + cate);
		logger.debug("type" + type);
		
		adminArticleDTO dto = new adminArticleDTO();
		dto.setCate(cate);
		dto.setType(type);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setNo(no);
		
		logger.debug(dto.toString());
				
		aService.updateArticleType(dto);
		
		resp.sendRedirect("/Kmarket/admin/cs/faq/view.do?group=faq&cate="+cate+"&type="+type+"&no="+no);
		
	}

}
