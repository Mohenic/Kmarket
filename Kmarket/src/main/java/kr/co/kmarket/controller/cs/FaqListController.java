package kr.co.kmarket.controller.cs;

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

import kr.co.kmarket.dto.cs.FaqDTO;
import kr.co.kmarket.service.cs.FaqService;

@WebServlet("/cs/faq/list.do")
public class FaqListController extends HttpServlet {

	private static final long serialVersionUID = -8774674328679407014L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private FaqService service = FaqService.instance;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		
		//데이터수신
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
		
		
		// 현재페이지계산
		if(pg!=null){
			currentPage =Integer.parseInt(pg);
			
		}
		
		// 전체 상품 갯수
		total = service.selectCountTotal(cate);
		
		//LIMIT 시작값계산
		start =(currentPage -1)*10;

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
		pageStartNum = total-start;
		
		
		List<FaqDTO> article = service.selectFaqArticles(cate, start);
		
		req.setAttribute("group", group);
		req.setAttribute("cate", cate);
		req.setAttribute("article", article);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("total", total);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroupCurrent", pageGroupCurrent);
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/faq/list.jsp");
		dispatcher.forward(req, resp);
	}
}
