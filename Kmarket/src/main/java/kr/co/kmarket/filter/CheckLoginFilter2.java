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

public class CheckLoginFilter2 implements Filter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 로그인 여부 확인
		logger.info("doFilter...");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		
		MemberDTO sessUser = (MemberDTO) session.getAttribute("sessUser");
		
			
		if(sessUser != null) {
			if(sessUser.getType()==2) {
				logger.info("here1...");
				chain.doFilter(request, response);
			}else if(sessUser.getType()==1){
				// 다음 필터 호출, 필터 없으면 최종 자원 요청
				logger.info("here2...");
				((HttpServletResponse)response).sendRedirect("/Kmarket/member/login.do?success=102");
			}
		}else {
			logger.info("here2...");
			((HttpServletResponse)response).sendRedirect("/Kmarket/member/login.do?success=102");
		}
	}
	
		
		
}
