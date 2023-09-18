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
import kr.co.kmarket.service.cs.ArticleService;

@WebServlet("/cs/index.do")
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 7250034913434587988L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	ArticleService service = ArticleService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//최신글 조회
		List<ArticleDTO> qnaLates= service.selectArticleLatest("qna", 5);
		logger.debug(qnaLates.toString());
		
		req.setAttribute("qnaLates", qnaLates);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/index.jsp");
		dispatcher.forward(req, resp);
	}

}
