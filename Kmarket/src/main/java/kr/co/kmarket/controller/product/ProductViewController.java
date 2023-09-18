package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.dto.product.ProductCartDTO;
import kr.co.kmarket.dto.product.ProductDTO;
import kr.co.kmarket.service.product.ProductCartService;
import kr.co.kmarket.service.product.ProductService;

@WebServlet("/product/view.do")
public class ProductViewController extends HttpServlet{
	
	private static final long serialVersionUID = 2687468093010817571L;
	ProductService service = ProductService.INSTANCE;
	ProductCartService service2 = ProductCartService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String prodNo = req.getParameter("prodNo");
			int parseNo = Integer.parseInt(prodNo);
			ProductDTO dto = service.selectProduct(parseNo);
			req.setAttribute("view", dto);
			logger.debug("Product View = " + dto);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/product/view.jsp");
			dispatcher.forward(req, resp);	
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			ProductCartDTO dto = new ProductCartDTO();
			
			String uid = req.getParameter("uid");
			String prodNo = req.getParameter("prodNo");
			String prodName = req.getParameter("prodName");
			String descript = req.getParameter("descript");
			String price = req.getParameter("price");
			String point = req.getParameter("point");
			String discount = req.getParameter("discount");
			String delivery = req.getParameter("delivery");
			String total = req.getParameter("total");
			String count = req.getParameter("num");
			
			dto.setUid(uid);
			dto.setProdNo(prodNo);
			dto.setCount(count);
			dto.setPrice(price);
			dto.setDiscount(discount);
			dto.setPoint(point);
			dto.setDelivery(delivery);
			dto.setTotal(total);
			service2.insertCart(dto);
			resp.sendRedirect("/product/cart.do");
			
			
		
		}
}