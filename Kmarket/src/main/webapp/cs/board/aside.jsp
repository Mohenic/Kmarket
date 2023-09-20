<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="cs">
	<div class="${group}">
		<nav>
			<div>
				<p>
					홈<span>></span>자주묻는 질문
				</p>
			</div>
		</nav>
		<section class="${index}">
			<aside>
				<h2>자주묻는 질문</h2>
				<ul>
					<c:if test="${group eq 'faq' || group eq 'qna'}">
		    	  		<li class="${cate eq 'f_member' ? 'on':'off'}"><a href="/Kmarket/cs/board/${group}/list.do?group=${group}&cate=member">회원</a></li>
                        <li class="${cate eq 'f_event' ? 'on':'off'}"><a href="/Kmarket/cs/board/${group}/list.do?group=${group}&cate=event">쿠폰/이벤트</a></li>
                        <li class="${cate eq 'f_pay' ? 'on':'off'}"><a href="/Kmarket/cs/board/${group}/list.do?group=${group}&cate=pay">주문/결제</a></li>
                        <li class="${cate eq 'f_delivery' ? 'on':'off'}"><a href="/Kmarket/cs/board/${group}/list.do?group=${group}&cate=delivery">배송</a></li>
                        <li class="${cate eq 'f_cancel' ? 'on':'off'}"><a href="/Kmarket/cs/board/${group}/list.do?group=${group}&cate=cancel">취소/반품/교환</a></li>
                        <li class="${cate eq 'f_travel' ? 'on':'off'}"><a href="/Kmarket/cs/board/${group}/list.do?group=${group}&cate=travel">여행/숙박/항공</a></li>
                        <li class="${cate eq 'f_safe' ? 'on':'off'}"><a href="/Kmarket/cs/board/${group}/list.do?group=${group}&cate=safe">안전거래</a></li>
					</c:if>
					<c:if test="${group eq 'notice'}">
						 <li class="${cate eq '0' ? 'on':'off'}"><a href="/Kmarket/cs/board/${group}/list.do?group=${group}&cate=0">전체</a></li>
                            <li class="${cate eq 'service' ? 'on':'off'}"><a href="/Kmarket/cs/board/${group}/list.do?group=${group}&cate=service">고객서비스</a></li>
                            <li class="${cate eq 'safe'    ? 'on':'off'}"><a href="/Kmarket/cs/board/${group}/list.do?group=${group}&cate=safe">안전거래</a></li>
                            <li class="${cate eq 'product' ? 'on':'off'}"><a href="/Kmarket/cs/board/${group}/list.do?group=${group}&cate=danger">위해상품</a></li>
                            <li class="${cate eq 'event'   ? 'on':'off'}"><a href="/Kmarket/cs/board/${group}/list.do?group=${group}&cate=jackpot">이벤트당첨</a></li>
					</c:if>															
				</ul>
			</aside>
			
					<article>
						<c:if test="${group eq 'faq' || group eq 'qna'}">
	                    <nav>
		                    <c:if test="${cate eq 'member'}">
		                            <h1>회원</h1>
		                            <h2>회원 관련 문의 내용입니다.</h2>
		                    </c:if>
		                     <c:if test="${cate eq 'event'}">
		                            <h1>쿠폰</h1>
		                            <h2>쿠폰/이벤트 관련 문의 내용입니다.</h2>
		                    </c:if>
		                    <c:if test="${cate eq 'pay'}">
				                    <h1>주문/결제</h1>
				                    <h2>주문/결제 관련 문의 내용입니다.</h2>
		                    </c:if>
		                     <c:if test="${cate eq 'delivery'}">
		                            <h1>배송</h1>
		                            <h2>배송 관련 문의 내용입니다.</h2>
		                    </c:if>
		                    <c:if test="${cate eq 'cancel'}">
		                            <h1>취소/반품/교환</h1>
		                            <h2>취소/반품/교환 관련 문의 내용입니다.</h2>
		                    </c:if>
		                    <c:if test="${cate eq 'travel'}">
		                            <h1>여행/숙박/항공</h1>
		                            <h2>여행/숙박/항공 관련 문의 내용입니다.</h2>
		                    </c:if>
		                    <c:if test="${cate eq 'safe'}">
		                            <h1>안전거래</h1>
		                            <h2>안전거래 관련 문의 내용입니다.</h2>
		                    </c:if>
	                    </nav>
	                    </c:if>
	                    
	                    <c:if test="${group eq 'notice'}">
                    	 <nav>
		                    <c:if test="${cate eq '0'}">
		                            <h1>전체</h1>
		                            <h2>공지사항 전체 내용입니다.</h2>
		                    </c:if>
		                     <c:if test="${cate eq 'service'}">
		                            <h1>고객서비스</h1>
		                            <h2>공지사항 전체 내용입니다.</h2>
		                    </c:if>
		                    <c:if test="${cate eq 'safe'}">
				                    <h1>안전거래</h1>
				                    <h2>공지사항 안전거래 내용입니다.</h2>
		                    </c:if>
		                     <c:if test="${cate eq 'product'}">
		                            <h1>위해상품</h1>
		                            <h2>공지사항 위해상품 내용입니다.</h2>
		                    </c:if>
		                    <c:if test="${cate eq 'event'}">
		                            <h1>이벤트당첨</h1>
		                            <h2>공지사항 이벤트당첨 내용입니다.</h2>
		                    </c:if>  
	                    </nav>
	                    </c:if>