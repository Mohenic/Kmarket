package kr.co.kmarket.controller.admin.cs.qna;

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
import kr.co.kmarket.dto.admin.adminArticleDTO;
import kr.co.kmarket.dto.cs.ArticleDTO;
import kr.co.kmarket.service.admin.adminArticleService;
import kr.co.kmarket.service.cs.ArticleService;

@WebServlet("/admin/cs/qna/write.do")
public class QnaWriteController extends HttpServlet {

	private static final long serialVersionUID = 8562356067027527812L;
	adminArticleService service = adminArticleService.instance;
	ArticleService Aservice = ArticleService.INSTANCE; 
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String writer = req.getParameter("writer");
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String type = req.getParameter("type");
		String no = req.getParameter("no");
		
		req.setAttribute("group", group);
		req.setAttribute("cate", cate);
		req.setAttribute("type", type);
		req.setAttribute("no", no);
		
		logger.debug("group = " + group);
		logger.debug("cate = " + cate);
		logger.debug("no = " + no);
		
		adminArticleDTO article =  service.selectArticle(no);

		
		req.setAttribute("article", article);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/qna/write.jsp");
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
		String no = req.getParameter("no");
		String regip = req.getRemoteAddr();
		
		logger.debug("writer =" +  writer);
		logger.debug("cate = " + cate);
		logger.debug("group = " + group);
		logger.debug("no = " + no);
		logger.debug("type = " + type);
		logger.debug("title = " + title);
		logger.debug("content = " + content);
		logger.debug("regip = " + regip);
		
		ArticleDTO dto = new ArticleDTO();
		dto.setParent(no);
		dto.setGroup(group);
		dto.setCate(cate);
		dto.setType(type);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setWriter(writer);
		dto.setRegip(regip);
		
		logger.debug(dto.toString());
		
		service.insertAnswer(dto);
		Aservice.updateCommentPlus(no);
		
		logger.debug("dto = " + dto.toString());
		
		resp.sendRedirect("/Kmarket/admin/cs/qna/view.do?group="+group+"&cate="+cate+"&no="+no);
		
		
		
	
	}
}
