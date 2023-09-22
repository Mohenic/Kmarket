package kr.co.kmarket.controller.admin.cs.notice;

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

import kr.co.kmarket.dto.admin.adminArticleDTO;
import kr.co.kmarket.service.admin.adminArticleService;

@WebServlet("/admin/cs/notice/list.do")
public class noticeListController extends HttpServlet {

	private static final long serialVersionUID = 8076023037498229732L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private adminArticleService aService = adminArticleService.instance;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate = req.getParameter("cate");
		String pg = req.getParameter("pg");
		
		if(cate == null) {
			cate = "0";
		}
		
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
		
		// 전체 게시물 갯수
		total = aService.selectCountArticleTotal("notice",cate);
		
		//LIMIT 시작값계산
		start =(currentPage -1)*10;

		if(total%10 == 0){
			lastPageNum =(total/10);
		}else{
			lastPageNum =(total/10)+1;
		}
		
		//페이지 그룹계산
		pageGroupCurrent=(int) Math.ceil(currentPage/5.0);
		pageGroupStart=(pageGroupCurrent-1)*5+1;
		pageGroupEnd=pageGroupCurrent*5;
		
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd=lastPageNum;
		}
		
		//페이지 시작번호 계산
		pageStartNum = total-start;
		
		List<adminArticleDTO> article = aService.selectArticles("notice", cate, start);
		
		req.setAttribute("article", article);
		req.setAttribute("cate", cate);
		req.setAttribute("start", start);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("total", total);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroupCurrent", pageGroupCurrent);
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("pageStartNum", pageStartNum);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/notice/list.jsp");
		dispatcher.forward(req, resp);
	}
}
