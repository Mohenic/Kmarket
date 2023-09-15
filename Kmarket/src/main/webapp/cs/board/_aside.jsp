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
					<c:if test="${group eq 'faq'}">
						<li class="on"><a href="#">회원</a></li>
						<li><a href="#">쿠폰/이벤트</a></li>
						<li><a href="#">주문/결제</a></li>
						<li><a href="#">배송</a></li>
						<li><a href="#">취소/반품/교환</a></li>
						<li><a href="#">여행/숙박/항공</a></li>
						<li><a href="#">안전거래</a></li>
					</c:if>
					<c:if test="${group eq 'notice'}">
						<li class="on"><a href="#">전체</a></li>Z
						<li><a href="#">고객서비스</a></li>
						<li><a href="#">안전거래</a></li>
						<li><a href="#">위해상품</a></li>
						<li><a href="#">이벤트당첨</a></li>
					</c:if>
					<c:if test="${group eq 'qna'}">
						<li class="on"><a href="#">회원</a></li>
						<li><a href="#">쿠폰/이벤트</a></li>
						<li><a href="#">주문/결제</a></li>
						<li><a href="#">배송</a></li>
						<li><a href="#">취소/반품/교환</a></li>
						<li><a href="#">여행/숙박/항공</a></li>
						<li><a href="#">안전거래</a></li>
					</c:if>
				</ul>
			</aside>