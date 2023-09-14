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

@WebServlet("/product/list.do")
public class ProductListController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7715231998323392840L;
	ProductService service = ProductService.INSTANCE;

			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

				RequestDispatcher dispatcher = req.getRequestDispatcher("/product/list.jsp");
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
				dto.setProdNo(prodNo);
				dto.setProdCate1(prodCate1);
				dto.setProdCate2(prodCate2);
				dto.setProdName(prodName);
				dto.setDescript(descript);
				dto.setSeller(seller);
				dto.setCompany(company);
				dto.setPrice(price);
				dto.setDiscount(discount);
				dto.setPoint(point);
				dto.setStock(stock);
				dto.setSold(sold);
				dto.setDelivery(delivery);
				dto.setHit(hit);
				dto.setScore(score);
				dto.setReview(review);
				dto.setThumb1(thumb1);
				dto.setThumb2(thumb2);
				dto.setThumb3(thumb3);
				dto.setDetail(detail);
				dto.setStatus(status);
				dto.setDuty(duty);
				dto.setReceipt(receipt);
				dto.setBizType(bizType);
				dto.setOrigin(origin);
				dto.setIp(ip);
				dto.setEtc1(etc1);
				dto.setEtc2(etc2);
				dto.setEtc3(etc3);
				dto.setEtc4(etc4);
				dto.setEtc5(etc5);
				
			}
		}