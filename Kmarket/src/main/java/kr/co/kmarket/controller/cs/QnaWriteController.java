package kr.co.kmarket.controller.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.dto.cs.FaqDTO;
import kr.co.kmarket.dto.cs.QnaDTO;
import kr.co.kmarket.service.cs.FaqService;

@WebServlet("/cs/qna/write.do")
public class QnaWriteController extends HttpServlet {

	private static final long serialVersionUID = 8562356067027527812L;
	
	private FaqService service = FaqService.instance;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		req.setAttribute("group", group);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/qna/write.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String writer = req.getParameter("wrier");
		String type = req.getParameter("req");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		FaqDTO dto = new FaqDTO();
		dto.setWriter(writer);
		dto.setCate2(type);
		
		
		
		
	
	}
}
