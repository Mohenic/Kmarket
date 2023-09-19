<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>케이마켓 고객센터</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="shortcut icon" type="image/x-icon" href="/Kmarket/images/favicon.ico">
    <link rel="stylesheet" href="/Kmarket/cs/css/style.css">
</head>
<body>
    <div id="container">
        <header>
            <div class="top">
                <div>
                    <p>
			          <c:if test="${sessUser eq null }">
			            <a href="/Kmarket/member/login.do">로그인</a>
			            <a href="/Kmarket/member/join.do">회원가입</a>
			          </c:if>
			          <c:if test="${sessUser ne null }">
			          	<c:if test="${sessUser.name ne null}">
			          		<a herf="#">${sessUser.name }</a>
			          	</c:if>
			          	<c:if test="${sessUser.type == 2 }">
			          		<a herf="#">${sessUser.company}</a>
			          		<a herf="/Kmarket/admin/index.do">관리자</a>
			          	</c:if>
		            	<a href="#">마이페이지</a>
		            	<a href="/Kmarket/member/logout.do">로그아웃</a>
		            	<a href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;장바구니</a>
		            	</c:if>
                    </p>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="/Kmarket/cs/index.do">
                        <img src="/Kmarket/cs/images/logo.png" alt="로고">고객센터
                    </a>
                </div>
            </div>
        </header>