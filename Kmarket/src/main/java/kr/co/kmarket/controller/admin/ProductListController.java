package kr.co.kmarket.controller.admin;

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
import kr.co.kmarket.service.product.ProductService;

@WebServlet("/admin/product/list.do")
public class ProductListController extends HttpServlet{
	private static final long serialVersionUID = 6818509803008828934L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ProductService pService = ProductService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		// 값 요청
		
		String pg = req.getParameter("pg");
		
		//페이지 관련 변수
		int start=0;
		int currentPage =1;
		int total=0;
		int lastPageNum=0;
		int pageGroupCurrent=1;
		int pageGroupStart=1;
		int pageGroupEnd=0;
		int pageStartNum=0;
		
		
		//현재페이지계산
		if(pg!=null){
			currentPage =Integer.parseInt(pg);
			
		}
		
		//LIMIT 시작값계산
		start =(currentPage -1)*10;

		//전체상품 갯수조회 
		total=pService.selectCountProductTotal();
		
		if(total%10 == 0){
			lastPageNum =(total/10);
		}else{
			lastPageNum =(total/10)+1;
		}
		
		//페이지 그룹계산
		pageGroupCurrent=(int) Math.ceil(currentPage/10.0);
		pageGroupStart=(pageGroupCurrent-1)*10+1;
		pageGroupEnd=pageGroupCurrent*10;
		
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd=lastPageNum;
		}
		
		//페이지 시작번호 계산
		pageStartNum =total-start;
		
		List<ProductDTO> products = pService.selectProducts(start);
		
		req.setAttribute("products", products);
		req.setAttribute("start", start);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("total", total);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroupCurrent", pageGroupCurrent);
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("pageStartNum", pageStartNum);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/list.jsp");
		dispatcher.forward(req, resp);
	}
	
}
