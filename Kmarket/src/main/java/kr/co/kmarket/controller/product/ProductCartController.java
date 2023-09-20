package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import kr.co.kmarket.dto.product.ProductCartDTO;
import kr.co.kmarket.service.product.ProductCartService;

@WebServlet("/product/cart.do")
public class ProductCartController extends HttpServlet {

	private static final long serialVersionUID = -5012485570172792300L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	ProductCartService service = ProductCartService.INSTANCE;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

				String uid =req.getParameter("uid");
				
				List<ProductCartDTO> list = service.selectCarts(uid);
				req.setAttribute("list", list);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/product/cart.jsp");
				dispatcher.forward(req, resp);	
			}
			
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
				
				String uid = req.getParameter("uid");
				String prodNo = req.getParameter("prodNo");
				String price = req.getParameter("price");
				String point = req.getParameter("point");
				String discount = req.getParameter("discount");
				String delivery = req.getParameter("delivery");
				String count = req.getParameter("count");
				
				logger.info("uid : "+uid);
				logger.info("prodNo : "+prodNo);
				logger.info("price : "+price);
				logger.info("point : "+point);
				logger.info("discount : "+discount);
				logger.info("delivery : "+delivery);
				logger.info("count : "+count);
				
				ProductCartDTO dto = new ProductCartDTO();
				dto.setUid(uid);
				dto.setProdNo(prodNo);
				dto.setCount(count);
				dto.setPrice(price);
				dto.setDiscount(discount);
				dto.setPoint(point);
				dto.setDelivery(delivery);
				
				int result =service.insertCart(dto);
				
				JsonObject json = new JsonObject();

				json.addProperty("result", result);

				
				// Json 출력
				PrintWriter writer = resp.getWriter();
				writer.print(json.toString());				
			
			
		
			
		}
	}