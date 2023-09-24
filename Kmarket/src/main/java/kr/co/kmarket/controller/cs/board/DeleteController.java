package kr.co.kmarket.controller.cs.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.service.cs.ArticleService;

@WebServlet("/cs/board/delete.do")
public class DeleteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	ArticleService service = ArticleService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");

		
		//글 + 댓글 삭제
		service.deleteArticle(no);

				
		//리다이렉트
		resp.sendRedirect("/Kmarket/cs/board/qna/list.do?group="+group+"&cate="+cate+"&pg=1");
	}
}
