package kr.co.kmarket.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.product.ProductService;

@WebServlet("/product/list.do")
public class ProductListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	ProductService service = ProductService.INSTANCE;

			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

				RequestDispatcher dispatcher = req.getRequestDispatcher("/product/list.jsp");
				dispatcher.forward(req, resp);	
			}
		}