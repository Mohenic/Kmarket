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
                            <li class="${cate eq 'noticeAll' ? 'on':'off'}"><a href="/Kmarket/cs/${group}/list.do?group=${group}&cate=noticeAll">전체</a></li>
                            <li class="${cate eq 'n_service' ? 'on':'off'}"><a href="/Kmarket/cs/${group}/list.do?group=${group}&cate=n_service">고객서비스</a></li>
                            <li class="${cate eq 'n_safe'    ? 'on':'off'}"><a href="/Kmarket/cs/${group}/list.do?group=${group}&cate=n_safe">안전거래</a></li>
                            <li class="${cate eq 'n_product' ? 'on':'off'}"><a href="/Kmarket/cs/${group}/list.do?group=${group}&cate=n_product">위해상품</a></li>
                            <li class="${cate eq 'n_event'   ? 'on':'off'}"><a href="/Kmarket/cs/${group}/list.do?group=${group}&cate=n_event">이벤트당첨</a></li>
                        </c:if>
                        </ul>
                    </aside>
                    
                  <article>
	                    <nav>
		                    <c:if test="${cate eq 'noticeAll'}">
		                            <h1>전체</h1>
		                            <h2>공지사항 전체 내용입니다.</h2>
		                    </c:if>
		                     <c:if test="${cate eq 'n_service'}">
		                            <h1>고객서비스</h1>
		                            <h2>공지사항 전체 내용입니다.</h2>
		                    </c:if>
		                    <c:if test="${cate eq 'n_safe'}">
				                    <h1>안전거래</h1>
				                    <h2>공지사항 안전거래 내용입니다.</h2>
		                    </c:if>
		                     <c:if test="${cate eq 'n_product'}">
		                            <h1>위해상품</h1>
		                            <h2>공지사항 위해상품 내용입니다.</h2>
		                    </c:if>
		                    <c:if test="${cate eq 'n_event'}">
		                            <h1>이벤트당첨</h1>
		                            <h2>공지사항 이벤트당첨 내용입니다.</h2>
		                    </c:if>
		               
		                
	                    </nav>
                 