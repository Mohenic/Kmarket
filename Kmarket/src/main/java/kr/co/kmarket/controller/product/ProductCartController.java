package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.dto.product.ProductCartDTO;
import kr.co.kmarket.service.product.ProductCartService;

@WebServlet("/product/cart.do")
public class ProductCartController extends HttpServlet {

	private static final long serialVersionUID = -5012485570172792300L;
		ProductCartService service = ProductCartService.INSTANCE;

			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

				List<ProductCartDTO> list = service.selectCarts();
				req.setAttribute("list", list);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/product/cart.jsp");
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
				service.insertCart(dto);
				resp.sendRedirect("/product/cart.do");
				
			
				
			}
		}