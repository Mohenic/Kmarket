<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
        <section id="cs">
            <div class="notice">
                <nav>
                    <div>
                        <p>홈<span>></span>공지사항</p>
                    </div>
                </nav>
                <section class="${index}">
                    <aside>
                        <h2>공지사항</h2>
                        <ul>
                        <c:if test="${group eq 'notice'}">
                            <li class="${cate eq '0' ? 'on':'off'}"><a href="/Kmarket/cs/${group}/list.do?group=${group}&cate=0">전체</a></li>
                            <li class="${cate eq 'service' ? 'on':'off'}"><a href="/Kmarket/cs/${group}/list.do?group=${group}&cate=service">고객서비스</a></li>
                            <li class="${cate eq 'safe'    ? 'on':'off'}"><a href="/Kmarket/cs/${group}/list.do?group=${group}&cate=safe">안전거래</a></li>
                            <li class="${cate eq 'product' ? 'on':'off'}"><a href="/Kmarket/cs/${group}/list.do?group=${group}&cate=danger">위해상품</a></li>
                            <li class="${cate eq 'event'   ? 'on':'off'}"><a href="/Kmarket/cs/${group}/list.do?group=${group}&cate=jackpot">이벤트당첨</a></li>
                        </c:if>
                        </ul>
                    </aside>
                    
                  <article>
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
                 