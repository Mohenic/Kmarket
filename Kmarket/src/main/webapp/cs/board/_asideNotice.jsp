<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <section id="cs">
            <div class="notice">
                <nav>
                    <div>
                        <p>홈<span>></span>공지사항</p>
                    </div>
                </nav>
                <section class="list">
                    <aside>
                        <h2>공지사항</h2>
                        <ul>
                            <li class="on"><a href="#">전체</a></li>
                            <li><a href="#">고객서비스</a></li>
                            <li><a href="#">안전거래</a></li>
                            <li><a href="#">위해상품</a></li>
                            <li><a href="#">이벤트당첨</a></li>
                        </ul>
                    </aside>
                    
                    <c:if test="${cate eq 'noticeAll'}"> 
                        <h1>전체</h1>
                        <h2>공지사항 전체 내용입니다.</h2>
                    </c:if>    