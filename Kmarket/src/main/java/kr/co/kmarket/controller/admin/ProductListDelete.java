package kr.co.kmarket.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.service.file.FileService;
import kr.co.kmarket.service.product.ProductService;

@WebServlet("/admin/product/delete.do")
public class ProductListDelete extends HttpServlet{

	private static final long serialVersionUID = 6735037993180614080L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ProductService pService = ProductService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 제품 번호 가져오기 
		
		String[] chks = req.getParameterValues("chk");
		
		for(String prodNo : chks) {
			pService.deleteProduct(prodNo);
		}
		
		resp.sendRedirect("/Kmarket/admin/product/list.do");
	}
}
