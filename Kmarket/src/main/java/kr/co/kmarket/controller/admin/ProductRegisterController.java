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
import kr.co.kmarket.service.product.ProductService;

@WebServlet("/admin/product/register.do")
public class ProductRegisterController extends HttpServlet{
	private static final long serialVersionUID = 6138492371144597779L;

	ProductService service = ProductService.INSTANCE;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prodNo = req.getParameter("prodNo");
		String prodCate1 = req.getParameter("prodCate1");
		String prdoCate2 = req.getParameter("prodCate2");
		String prodName = req.getParameter("prodName");
		String descript = req.getParameter("descript");
		String seller = req.getParameter("seller");
		String company = req.getParameter("company");
		String price = req.getParameter("price");
		String discount = req.getParameter("discount");
		String point = req.getParameter("point");
		String stock = req.getParameter("stock");
		String delivery = req.getParameter("delivery");
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
		
		ProductDTO dto = new ProductDTO();
		dto.setProdNo(prodNo);
		dto.setProdCate1(prodCate1);
		dto.setProdCate2(prdoCate2);
		dto.setProdName(prodName);
		dto.setDescript(descript);
		dto.setSeller(seller);
		dto.setCompany(company);
		dto.setPrice(price);
		dto.setDiscount(discount);
		dto.setPoint(point);
		dto.setStock(stock);
		dto.setDelivery(delivery);
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
		
		logger.debug(dto.toString());
		
		service.insertProduct(dto);
		
		resp.sendRedirect("/Kmarket/admin/product/register.do");
	
	}
}
