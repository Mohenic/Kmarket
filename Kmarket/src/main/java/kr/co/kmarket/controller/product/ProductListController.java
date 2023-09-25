package kr.co.kmarket.controller.product;

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

@WebServlet("/product/list.do")
public class ProductListController extends HttpServlet {
    private static final long serialVersionUID = -7715231998323392840L;
    private ProductService service = ProductService.INSTANCE;
    private static final Logger logger = LoggerFactory.getLogger(ProductListController.class);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sortOption = req.getParameter("sort");
        String orderOption = req.getParameter("order");
        String category1Param = req.getParameter("prodCate1");
        String category2Param = req.getParameter("prodCate2");
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
		
		if (pg != null && !pg.isEmpty()) {
			try {
				currentPage = Integer.parseInt(pg);
			} catch (NumberFormatException e) {
				// "pg" 매개변수가 숫자로 변환할 수 없는 경우, 기본 페이지를 유지합니다.
			}
		}
        
		//LIMIT 시작값계산
		start =(currentPage -1)*5;

		//전체상품 갯수조회 
		total=service.selectCountProductTotal();
		
		if(total%5 == 0){
			lastPageNum =(total/5);
		}else{
			lastPageNum =(total/5)+1;
		}
		
		//페이지 그룹계산
		pageGroupCurrent = (int) Math.ceil(currentPage / 5.0);
		pageGroupStart = ((currentPage - 1) / 5) * 5 + 1; // 수정된 부분
		pageGroupEnd = pageGroupCurrent * 5;
		
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd=lastPageNum;
		}
		
		//페이지 시작번호 계산
		pageStartNum =total-start;
        List<ProductDTO> list;
        list = service.getProductsByCategory(sortOption, orderOption, Integer.parseInt(category1Param), Integer.parseInt(category2Param), start);

        req.setAttribute("prodCate1", category1Param);
        req.setAttribute("prodCate2", category2Param);
        req.setAttribute("sortOption", sortOption);
        req.setAttribute("orderOption", orderOption);
        req.setAttribute("list", list);
		req.setAttribute("total", total);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroupCurrent", pageGroupCurrent);
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("pg", pg);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/product/list.jsp");
        dispatcher.forward(req, resp);
    }
}