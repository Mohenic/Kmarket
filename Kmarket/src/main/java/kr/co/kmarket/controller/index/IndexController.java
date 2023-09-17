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
	
		List<ProductDTO> products1 = service.selectProductsHit();//히트상품 많이팔린순 8
		List<ProductDTO> products2 = service.selectProductsScore();//추천 SCORE 높은순 8
		List<ProductDTO> products3 = service.selectProductsNew();//최신 제일최근에 등록된 높은순 8
		List<ProductDTO> products4 = service.selectProductsDiscount();//할인 높은순 8
		List<ProductDTO> products5 = service.selectProductsSold();//좌측배너 베스트상품 sold가  높은순 5
		
		logger.info("products1 :",products1);
		logger.info("products2 :",products2);
		logger.info("products3 :",products3);
		logger.info("products4 :",products4);
		logger.info("products5 :",products5);
		
		req.setAttribute("products1", products1);
		req.setAttribute("products2", products2);
		req.setAttribute("products3", products3);
		req.setAttribute("products4", products4);
		req.setAttribute("products5", products5);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);	
		
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
	
}
