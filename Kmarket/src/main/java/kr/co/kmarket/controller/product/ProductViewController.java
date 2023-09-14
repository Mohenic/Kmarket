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
public class ProductViewController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2687468093010817571L;
	ProductService service = ProductService.INSTANCE;

			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	 
				RequestDispatcher dispatcher = req.getRequestDispatcher("/product/view.jsp");
				dispatcher.forward(req, resp);	
			}
			
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				super.doPost(req, resp);
				
				String prodNo = req.getParameter("prodNo");
				String prodCate1 = req.getParameter("prodCate1");
				String prodCate2 = req.getParameter("prodCate2");
				String prodName = req.getParameter("prodName");
				String descript = req.getParameter("descript");
				String seller = req.getParameter("seller");
				String company = req.getParameter("company");
				String price = req.getParameter("price");
				String discount = req.getParameter("discount");
				String point = req.getParameter("point");
				String stock = req.getParameter("stock");
				String sold = req.getParameter("sold");
				String delivery = req.getParameter("delivery");
				String hit = req.getParameter("hit");
				String score = req.getParameter("score");
				String review = req.getParameter("review");
				String thumb1 = req.getParameter("thumb1");
				String thumb2 = req.getParameter("thumb2");
				String thumb3 = req.getParameter("req");
				String detail = req.getParameter("detail");
				String status = req.getParameter("status");
				String duty = req.getParameter("duty");
				String receipt = req.getParameter("receipt");
				String bizType = req.getParameter("bizType");
				String origin = req.getParameter("origin");
				String ip = req.getRemoteAddr();
				String etc1 = req.getParameter("etc1");
				String etc2 = req.getParameter("etc2");
				String etc3 = req.getParameter("etc3");
				String etc4 = req.getParameter("etc4");
				String etc5 = req.getParameter("etc5");
				
				ProductDTO dto = new ProductDTO();
				dto.setProdName(prodName);
				dto.setProdCate1(prodCate1);
				dto.setProdCate2(prodCate2);
				dto.setProdName(prodName);
				dto.setDescript(descript);
				dto.setSeller(seller);
				dto.setCompany(company);
				dto.setPrice(price);
				dto.setDiscount(discount);
				
				
			}
		}