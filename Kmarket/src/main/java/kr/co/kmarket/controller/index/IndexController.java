package kr.co.kmarket.controller.index;

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

import kr.co.kmarket.dto.product.ProductDTO;
import kr.co.kmarket.service.index.IndexService;
@WebServlet(value = {"", "/index.do"})
public class IndexController extends HttpServlet{


	private static final long serialVersionUID = -3843457495908140291L;
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	IndexService service =IndexService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		List<ProductDTO> products = service.selectProducts();
		
		req.setAttribute("products", products);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);	
		
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	
}
