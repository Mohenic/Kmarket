package kr.co.kmarket.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.product.ProductService;

@WebServlet("/product/complete.do")
public class ProductCompleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5772880320109292475L;
	ProductService service = ProductService.INSTANCE;

			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

				RequestDispatcher dispatcher = req.getRequestDispatcher("/product/complete.jsp");
				dispatcher.forward(req, resp);	
			}
		}