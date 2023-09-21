package kr.co.kmarket.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.product.ProductDTO;
import kr.co.kmarket.service.admin.adminArticleService;

@WebServlet("/admin/product/modify.do")
public class ProductModifyController extends HttpServlet{

	private static final long serialVersionUID = -7461736615488292213L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	adminArticleService service = adminArticleService.instance;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prodNo = req.getParameter("prodNo");
		logger.debug("prodNo = " + prodNo);
		
		ProductDTO product = service.selectProduct(prodNo);
		logger.debug(prodNo.toString());
		
		req.setAttribute("product", product);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}
