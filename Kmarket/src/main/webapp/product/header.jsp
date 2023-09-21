<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
<header>
            <div class="top">
                <div>
		<c:if test="${sessUser eq null }">
            <a href="./member/login.do">로그인</a>
            <a href="./member/join.do">회원가입</a>
          </c:if>
          <c:if test="${sessUser ne null }">
          	<c:if test="${sessUser.name ne null}">
          		<a href="#">${sessUser.name }</a>
          	</c:if>
          	<c:if test="${sessUser.type == 2 }">
          		<a href="#">${sessUser.company}</a>
          		<a href="/Kmarket/admin/index.do">관리자</a>
          	</c:if>
            	<a href="#">마이페이지</a>
            	<a href="/Kmarket/member/logout.do">로그아웃</a>
            	<a href="/Kmarket/product/cart.do?uid=${sessUser.uid}"
              	><i class="fa fa-shopping-cart" aria-hidden="true"></i
              	>&nbsp;장바구니</a
            	>
          </c:if>  
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="#"><img src="./images/header_logo.png" alt="로고"/></a>
                    <form action="#">
                        <input type="text" name="search"/>
                        <button><i class="fa fa-search"></i></button>
                    </form>                
                </div>
            </div>
            <div class="menu">
                <div>
                    <ul>
                        <li><a href="#">히트상품</a></li>
                        <li><a href="#">추천상품</a></li>
                        <li><a href="#">최신상품</a></li>
                        <li><a href="#">인기상품</a></li>
                        <li><a href="#">할인상품</a></li>
                    </ul>
                    <ul>
                        <li><a href="#">쿠폰존</a></li>
                        <li><a href="#">사용후기</a></li>
                        <li><a href="#">개인결제</a></li>
                        <li><a href="#">고객센터</a></li>
                        <li><a href="#">FAQ</a></li>
                    </ul>
                </div>
            </div>
        </header>
</body>
</html>