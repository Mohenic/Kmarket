package kr.co.kmarket.controller.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cs/qna/write.do")
public class QnaWriteController extends HttpServlet {

	private static final long serialVersionUID = 8562356067027527812L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/qna/write.jsp");
		dispatcher.forward(req, resp);
	}
}
