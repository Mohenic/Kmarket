<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
	작업자 : 손영우
	작업시작일 : 2023/09/14
	작업종료일 : 2023/09/14
 -->
        <main>
            <aside>
                <ul id="gnb">
                    <li>
                        <a href="#"><i class="fa fa-cogs" aria-hidden="true"></i>환경설정</a>
                        <ol style="display: none;">
                            <li><a href="/Kmarket/admin/config/info.do">기본환경정보</a></li>
                            <li><a href="/Kmarket/admin/config/banner.do">배너관리</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fas fa-store" aria-hidden="true"></i>상점관리</a>
                        <ol style="display: none;">
                            <li><a href="#">판매자현황</a></li>
                            <li><a href="#">재고관리</a></li>
                        </ol>
                    </li>
                  
                    <li>
                        <a href="#"><i class="fa fa-users" aria-hidden="true"></i>회원관리</a>
                        <ol style="display: none;">
                            <li><a href="#">회원현황</a></li>
                            <li><a href="#">포인트관리</a></li>
                            <li><a href="#">비회원관리</a></li>
                            <li><a href="#">접속자관리</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fas fa-box-open" aria-hidden="true"></i>상품관리</a>
                        <ol style="display: none;">
                            <li><a href="/Kmarket/admin/product/list.do">상품현황</a></li>
                            <li><a href="/Kmarket/admin/product/register.do">상품등록</a></li>
                            <li><a href="#">재고관리</a></li>
                        </ol>
                    </li>
                 
                    <li>
                        <a href="#"><i class="fa fa-credit-card" aria-hidden="true"></i>주문관리</a>
                        <ol style="display: none;">
                            <li><a href="#">주문현황</a></li>
                            <li><a href="#">매출현황</a></li>
                            <li><a href="#">결제관리</a></li>
                            <li><a href="#">배송관리</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>고객센터</a>
                        <ol style="display: none;">
                            <li><a href="/Kmarket/admin/cs/notice/list.do?group=notice">공지사항</a></li>
                            <li><a href="#">자주묻는질문</a></li>
                            <li><a href="#">문의하기</a></li>
                        </ol>
                    </li>
                </ul>
            </aside>