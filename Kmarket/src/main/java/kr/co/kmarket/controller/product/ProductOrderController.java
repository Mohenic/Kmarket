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
import kr.co.kmarket.service.member.MemberService;
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
	MemberService service3 =MemberService.INSTANCE;

			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

				String uid = req.getParameter("uid");
				String type = req.getParameter("type");
				String delivery =req.getParameter("delivery");
				String point = req.getParameter("point");
				String seller = req.getParameter("seller");
				String discount1 = req.getParameter("discount1");
				String discount2 = req.getParameter("discount2");
				String price = req.getParameter("price");
				String total = req.getParameter("total");
				String prodCate1 = req.getParameter("prodCate1");
				String prodCate2 = req.getParameter("prodCate2");
				String descript = req.getParameter("descript");
				String prodName = req.getParameter("prodName");
				String prodNo = req.getParameter("prodNo");
				String thumb1 = req.getParameter("thumb1");
				String count = req.getParameter("num");
				String cartNo[] = req.getParameterValues("chk");
				int memberpoint=0;
				
				
				
				if(type.equals("cart")) {
					List<ProductCartDTO> list = new ArrayList<>();
					ProductCartDTO dto = new ProductCartDTO();
					for(String cartNos : cartNo) {
						dto=service2.selectCart(cartNos);
						list.add(dto);
					}
					memberpoint=service3.selectMemberPoint(uid);
					
					req.setAttribute("list", list);
					req.setAttribute("type", type);
					req.setAttribute("delivery", delivery);
					req.setAttribute("memberpoint", memberpoint);
					
					RequestDispatcher dispatcher = req.getRequestDispatcher("/product/order.jsp");
					dispatcher.forward(req, resp);	
					
				}else if (type.equals("order")) {
					
					memberpoint=service3.selectMemberPoint(uid);
					
					
					req.setAttribute("prodCate2", prodCate2);
					req.setAttribute("prodCate1", prodCate1);
					req.setAttribute("uid", uid);
					req.setAttribute("type", type);
					req.setAttribute("delivery", delivery);
					req.setAttribute("point", point);
					req.setAttribute("seller", seller);
					req.setAttribute("discount1", discount1);
					req.setAttribute("discount2", discount2);
					req.setAttribute("price", price);
					req.setAttribute("total", total);
					req.setAttribute("prodCate1", prodCate1);
					req.setAttribute("prodCate2", prodCate2);
					req.setAttribute("descript", descript);
					req.setAttribute("prodName", prodName);
					req.setAttribute("thumb1", thumb1);
					req.setAttribute("count", count);
					req.setAttribute("prodNo", prodNo);
					req.setAttribute("memberpoint", memberpoint);
					
					RequestDispatcher dispatcher = req.getRequestDispatcher("/product/order.jsp");
					dispatcher.forward(req, resp);
				}
					
			}
		}