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

import kr.co.kmarket.dto.cs.ArticleDTO;
import kr.co.kmarket.service.cs.ArticleService;

@WebServlet("/cs/qna/view.do")
public class QnaViewController extends HttpServlet {

	private static final long serialVersionUID = 7853938763561354917L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	ArticleService service = ArticleService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//모듈화
		req.setAttribute("index", "view");
		
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");	
		String no = req.getParameter("no");		
		
		req.setAttribute("group", group);
		req.setAttribute("cate", cate);
		req.setAttribute("no", no);
		
		logger.debug("group = " + group);
		logger.debug("cate = " + cate);
		logger.debug("no = " + no);
		
		//글보기 
		ArticleDTO article = service.selectArticle(no);
		
		//답글 보기
		ArticleDTO answer = service.selectAnswerArticle(no);
		
		logger.debug(article.toString());
		req.setAttribute("article", article);
		req.setAttribute("answer", answer);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/qna/view.jsp");
		dispatcher.forward(req, resp);
	}
}
