<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<h1>상품목록</h1>
	    <p>
	        HOME >
	        <c:if test="${prodCate1 == '11'}"><em>패션·의류·뷰티</em>
	         > 
	        <c:if test="${prodCate2 == '11'}"><em>남성의류</em></c:if>
	        <c:if test="${prodCate2 == '10'}"><em>여성의류</em></c:if>
	        <c:if test="${prodCate2 == '14'}"><em>잡화</em></c:if>
	        <c:if test="${prodCate2 == '16'}"><em>뷰티</em></c:if>
	        </c:if>
	        
	        <c:if test="${prodCate1 == '15'}"><em>가전·디지털</em>
	         > 
	        <c:if test="${prodCate2 == '10'}"><em>노트북</em></c:if>
	        <c:if test="${prodCate2 == '16'}"><em>가전</em></c:if>
	        <c:if test="${prodCate2 == '13'}"><em>휴대폰</em></c:if>
	        <c:if test="${prodCate2 == '12'}"><em>기타</em></c:if>
	        </c:if>
	        
	        <c:if test="${prodCate1 == '13'}"><em>식품·생필품</em>
	         > 
	        <c:if test="${prodCate2 == '10'}"><em>신선식품</em></c:if>
	        <c:if test="${prodCate2 == '11'}"><em>가공식품</em></c:if>
	        <c:if test="${prodCate2 == '12'}"><em>건강식품</em></c:if>
	        <c:if test="${prodCate2 == '14'}"><em>생필품</em></c:if>
	        </c:if>
	
	        <c:if test="${prodCate1 == '14'}"><em>홈·문구·취미</em>
	         > 
	        <c:if test="${prodCate2 == '10'}"><em>가구/DIY</em></c:if>
	        <c:if test="${prodCate2 == '11'}"><em>침구·커튼</em></c:if>
	        <c:if test="${prodCate2 == '13'}"><em>생활용품</em></c:if>
	        <c:if test="${prodCate2 == '15'}"><em>사무용품</em></c:if>
	        </c:if>
	    </p>
	</nav>

</body>
</html>