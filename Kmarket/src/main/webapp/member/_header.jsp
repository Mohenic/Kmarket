<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>k-market::member</title>
    <!--
       날짜 : 2023/09/11
       작업자: 하민수
       내용 : header 모듈화


    -->

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="./css/member.css">
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
	<script>
	function checkCapsLock(event)  {
		  if (event.getModifierState("CapsLock")) {
		    document.getElementById("pass").innerText 
		      = "Caps Lock이 켜져 있습니다."
		  }else {
		    document.getElementById("pass").innerText 
		      = ""
		  }//capslock on/off 구분용도 
	}
	</script>
</head>


<body>
    <div id="container">
        <header>
                <div class ="topMenu">
                    <div>
                    <c:if test="${sessUser eq null }"> <!-- 로그인정보가 없을경우 // 추후삭제예정-->
                        <a href="./login.do">로그인</a>
                        <a href="./signup.do">회원가입</a>
                    </c:if>
                        <a href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;장바구니</a>
                        
                    </div>
                </div>
                <div class="logo">
                    <div>
                        <a href="/Kmarket">
                            <img src="../images/header_logo.png" alt="logo">
                        </a>
                    </div>
                </div>
        </header>