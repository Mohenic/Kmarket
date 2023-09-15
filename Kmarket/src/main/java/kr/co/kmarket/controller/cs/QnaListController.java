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

import kr.co.kmarket.dto.cs.QnaDTO;
import kr.co.kmarket.service.cs.QnaService;

@WebServlet("/cs/qna/list.do")
public class QnaListController extends HttpServlet {

	private static final long serialVersionUID = 3797589361217869280L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	QnaService service = QnaService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//모듈화 
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		
		List<QnaDTO> articles = service.selectQnaArticles(cate);
		
		logger.debug("group = " + group);
		logger.debug("cate = " + cate);
		logger.debug(articles.toString());
		
		
		req.setAttribute("group", group);
		req.setAttribute("index", "list");
		req.setAttribute("articles", articles);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/qna/list.jsp");
		dispatcher.forward(req, resp);
	}
}
