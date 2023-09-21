package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.product.ProductCartDTO;
import kr.co.kmarket.service.product.ProductCartService;
import kr.co.kmarket.service.product.ProductService;

@WebServlet("/product/order.do")
public class ProductOrderController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3015799113155313307L;
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	ProductService service1 = ProductService.INSTANCE;
	ProductCartService service2 = ProductCartService.INSTANCE;

			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

				String uid = req.getParameter("uid");
				String type = req.getParameter("type");
				String delivery =req.getParameter("delivery");
				String cartNo[] = req.getParameterValues("chk");
				
				
				
				if(type.equals("cart")) {
					List<ProductCartDTO> list = new ArrayList<>();
					ProductCartDTO dto = new ProductCartDTO();
					for(String cartNos : cartNo) {
						dto=service2.selectCart(cartNos);
						list.add(dto);
					}
					req.setAttribute("list", list);
					req.setAttribute("type", type);
					req.setAttribute("delivery", delivery);
					
					RequestDispatcher dispatcher = req.getRequestDispatcher("/product/order.jsp");
					dispatcher.forward(req, resp);	
					
				}else if (type.equals("order")) {

					RequestDispatcher dispatcher = req.getRequestDispatcher("/product/order.jsp");
					dispatcher.forward(req, resp);
				}
					
			}
		}