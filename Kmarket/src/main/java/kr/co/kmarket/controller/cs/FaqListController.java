package kr.co.kmarket.controller.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.cs.ArticleDTO;
import kr.co.kmarket.dto.cs.FaqDTO;
import kr.co.kmarket.service.cs.ArticleService;
import kr.co.kmarket.service.cs.FaqService;

@WebServlet("/cs/faq/list.do")
public class FaqListController extends HttpServlet {

	private static final long serialVersionUID = -8774674328679407014L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ArticleService service = ArticleService.INSTANCE;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		
		logger.debug("group = " + group);
		logger.debug("cate = " + cate);
		
		List<ArticleDTO> articles = service.selectArticles(group, cate, 0);
		logger.debug(articles.toString());
		
		req.setAttribute("index", "list");
		
		req.setAttribute("group", group);
		req.setAttribute("cate", cate);
		req.setAttribute("articles", articles);

		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/faq/list.jsp");
		dispatcher.forward(req, resp);
	}
}
