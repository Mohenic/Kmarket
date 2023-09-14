<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>k-market::member</title>
    <!--
        2023/09/11
        하민수
        로그인 화면구현


    -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="./css/member.css">
</head>


<body>
    <div id="container">
        <header>
                <div class ="topMenu">
                    <div>
                        <a href="./login.do">로그인</a>
                        <a href="./register.do">회원가입</a>
                        <a href="./signup.do">마이페이지</a>
                        <a href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;장바구니</a>
                        
                    </div>
                </div>
                <div class="logo">
                    <div>
                        <a href="../index.do">
                            <img src="../images/header_logo.png" alt="logo">
                        </a>
                    </div>
                </div>
        </header>