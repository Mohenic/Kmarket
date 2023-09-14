package kr.co.kmarket.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.dto.product.ProductDTO;
import kr.co.kmarket.service.product.ProductService;


@WebServlet("/product/view.do")
public class ProductViewController extends HttpServlet{
	
	private static final long serialVersionUID = 2687468093010817571L;
	ProductService service = ProductService.INSTANCE;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String prodNo = req.getParameter("prodNo");
			String prodName = req.getParameter("prodName");
			
			ProductDTO dto = new ProductDTO();
			req.setAttribute("prod", dto);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/product/view.jsp");
			dispatcher.forward(req, resp);	
		}
}