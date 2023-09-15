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

import kr.co.kmarket.dto.cs.QnaDTO;
import kr.co.kmarket.service.cs.QnaService;

@WebServlet("/cs/qna/view.do")
public class QnaViewController extends HttpServlet {

	private static final long serialVersionUID = 7853938763561354917L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	QnaService service = QnaService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//모듈화
		req.setAttribute("index", "view");
		
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");	
		String qnaNo = req.getParameter("qnaNo");		
		
		req.setAttribute("group", group);
		req.setAttribute("cate", cate);
		req.setAttribute("qnaNo", qnaNo);
		
		logger.debug("group = " + group);
		logger.debug("cate = " + cate);
		logger.debug("qnaNo = " + qnaNo);
		
		//글보기 
		QnaDTO article = service.selectQnaArticle(qnaNo);
		
		logger.debug(article.toString());
		req.setAttribute("article", article);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/qna/view.jsp");
		dispatcher.forward(req, resp);
	}
}
