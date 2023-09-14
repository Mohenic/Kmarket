package kr.co.kmarket.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.member.MemberDTO;

/*
 * 작업일 : 2023/09/05
 * 작업자 : 김철학
 * 내용 
 *  - 로그인 여부 체크 필터 작성
 *  - web.xml 필터 등록 및 해당 필터가 작동할 주소매핑 작업  
 */

public class CheckLoginFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 로그인 여부 확인
		logger.debug("doFilter...");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		
		MemberDTO sessUser = (MemberDTO) session.getAttribute("sessUser");
		
		if(sessUser != null) {
			logger.debug("here1...");
			chain.doFilter(request, response);
		}else {
			// 다음 필터 호출, 필터 없으면 최종 자원 요청
			logger.debug("here2...");
			((HttpServletResponse)response).sendRedirect("/Farmstory2/user/login.do?success=101");
		}
	}
}
