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

import kr.co.kmarket.dto.cs.FaqDTO;
import kr.co.kmarket.service.cs.FaqService;

@WebServlet("/cs/faq/list.do")
public class FaqListController extends HttpServlet {

	private static final long serialVersionUID = -8774674328679407014L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private FaqService service = FaqService.instance;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate = req.getParameter("cate");
		
		List<FaqDTO> faqArticle = service.selectFaqArticles(cate);
		
		req.setAttribute("cate", cate);
		req.setAttribute("faqArticle", faqArticle);
		
	
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/faq/list.jsp");
		dispatcher.forward(req, resp);
	}
}
