package kr.co.kmarket.controller.cs.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.cs.FaqDTO;
import kr.co.kmarket.dto.cs.ArticleDTO;
import kr.co.kmarket.service.cs.ArticleService;

@WebServlet("/cs/board/qna/write.do")
public class QnaWriteController extends HttpServlet {

	private static final long serialVersionUID = 8562356067027527812L;
	private ArticleService service = ArticleService.INSTANCE;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		
		req.setAttribute("group", group);
		req.setAttribute("cate", cate);
		req.setAttribute("index", "write");
		
		logger.debug("group = " + group);
		logger.debug("cate = " + cate);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/board/qnawrite.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String writer = req.getParameter("writer");
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String type = req.getParameter("type");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String regip = req.getRemoteAddr();
		
		logger.debug("writer =" +  writer);
		logger.debug("cate = " + cate);
		logger.debug("group = " + group);
		logger.debug("type = " + type);
		logger.debug("content = " + content);
		logger.debug("regip = " + regip);
		
		ArticleDTO dto = new ArticleDTO();
		dto.setGroup(group);
		dto.setCate(cate);
		dto.setType(type);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setWriter(writer);
		dto.setRegip(regip);
		
		logger.debug(dto.toString());
		
		service.insertArticle(dto);
		
		
		resp.sendRedirect("/Kmarket/cs/board/qna/list.do?group="+group+"&cate="+cate);
		
		
		
	
	}
}
