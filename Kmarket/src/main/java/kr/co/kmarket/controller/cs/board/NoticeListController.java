package kr.co.kmarket.controller.cs.board;

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

import kr.co.kmarket.dto.cs.ArticleDTO;
import kr.co.kmarket.service.cs.ArticleService;


@WebServlet("/cs/board/notice/list.do")
public class NoticeListController extends HttpServlet {

	private static final long serialVersionUID = 6278400394568290614L;
	ArticleService service = ArticleService.INSTANCE;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		
		req.setAttribute("group", group);
		req.setAttribute("cate", cate);
		req.setAttribute("index", "list");
		
		logger.debug("group = " + group);
		logger.debug("cate = " + cate);
		
		
		//페이지 처리
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
		total = service.selectCountTotal(group,cate);
		
		//LIMIT 시작값계산
		start =(currentPage -1)*10;

		if(total%10 == 0){
			lastPageNum =(total/10);
		}else{
			lastPageNum =(total/10)+1;
		}
		
		//페이지 그룹계산
		// 페이지 그룹 계산 (5개 단위로 나누기)
		pageGroupCurrent = (int) Math.ceil(currentPage / 5.0); // 현재 페이지 그룹 계산
		pageGroupStart = (pageGroupCurrent - 1) * 5 + 1; // 페이지 그룹의 시작 페이지 계산
		pageGroupEnd = Math.min(pageGroupCurrent * 5, lastPageNum); // 페이지 그룹의 끝 페이지 계산
		
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd=lastPageNum;
		}
		
		//페이지 시작번호 계산
		pageStartNum = total-start;
		
		List<ArticleDTO> articles = service.selectNoticeArticles(group, cate, 0);
		req.setAttribute("articles", articles);
		
		req.setAttribute("start", start);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("total", total);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroupCurrent", pageGroupCurrent);
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("pageStartNum", pageStartNum);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/board/noticelist.jsp");
		dispatcher.forward(req, resp);
	}
}
