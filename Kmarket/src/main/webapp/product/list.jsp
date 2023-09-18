<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./header.jsp" %>
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <main id="product">
    	<%@ include file="./category.jsp" %>   
        <section class="list">
            <nav>
                <h1>상품목록</h1>
                <p>HOME > <span>패션·의류·뷰티</span> > <strong>남성의류</strong></p>
            </nav>
				<ul class="sort">
				    <li>
				        <c:set var="sortOption" value="selling"/>
				        <a href="list.do?sort=selling" class="${param.sort == 'selling' ? 'on' : ''}">판매많은순</a>
				    </li>
				    <li>
				        <c:set var="sortOption" value="lowprice"/>
				        <a href="list.do?sort=lowprice" class="${param.sort == 'lowprice' ? 'on' : ''}">낮은가격순</a>
				    </li>
				    <li>
				        <c:set var="sortOption" value="highprice"/>
				        <a href="list.do?sort=highprice" class="${param.sort == 'highprice' ? 'on' : ''}">높은가격순</a>
				    </li>
				    <li>
				        <c:set var="sortOption" value="highrating"/>
				        <a href="list.do?sort=highrating" class="${param.sort == 'highrating' ? 'on' : ''}">평점높은순</a>
				    </li>
				    <li>
				        <c:set var="sortOption" value="manyreviews"/>
				        <a href="list.do?sort=manyreviews" class="${param.sort == 'manyreviews' ? 'on' : ''}">후기많은순</a>
				    </li>
				    <li>
				        <c:set var="sortOption" value="recent"/>
				        <a href="list.do?sort=recent" class="${param.sort == 'recent' ? 'on' : ''}">최근등록순</a>
				    </li>
				</ul>
            <table border="0">
      
                <tbody>
                    <c:forEach var="prod" items="${list}">
                    <tr>
                        <td>
                            <a href="view.do?prodNo=${prod.prodNo}" class="thumb">
                                <img src="${prod.thumb1}" alt="상품이미지">
                            </a>
                        </td>
                        <td>
                        	<h3 class="name">${prod.prodName}</h3>
                            <a href="view.do" class="desc">${prod.descript}</a>
                        </td>
                        <td>
                            <ul>
                                <li><ins class="dis-price">${prod.price}</ins></li>
                                <li>
                                    <del class="org-price">${prod.price}</del>
                                    <span class="discount">${prod.discount}%</span>
                                </li>
                                <li><span class="free-delivery">${prod.delivery}</span></li>
                            </ul>
                        </td>
                        <td>
                            <h4 class="seller"><i class="fas fa-home"></i>${prod.seller}</h4>
                            <h5 class="badge power">${prod.seller}</h5>
                            <h6 class="rating">${prod.score}</h6>
                            <script>
						        var score = parseInt('${prod.score}');
						        if (!isNaN(score) && score >= 1 && score <= 5) {
						            var ratingElement = document.querySelector('.rating');
						            ratingElement.classList.add('star' + score);
						        }
						    </script>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- 번호 버튼 -->
            <div class="paging">
                <span class="prev">
                    <a href="Kmarket/product/list.do">< 이전</a>
                </span>
                <span class="num">
                    <a href="Kmarket/product/list.do" class="on">1</a>
                    <a href="Kmarket/product/list.do">2</a>
                    <a href="Kmarket/product/list.do">3</a>	
                    <a href="Kmarket/product/list.do">4</a>
                    <a href="Kmarket/product/list.do">5</a>
                    <a href="Kmarket/product/list.do">6</a>
                    <a href="Kmarket/product/list.do">7</a>
                </span>
                <span class="next">
                    <a href="Kmarket/product/list.do">다음 ></a>
                </span>
            </div>

            <!-- 상단 이동 버튼 -->
            <button type="button" id="top">상단이동</button>
        </section>
    </main>
<%@ include file="./footer.jsp" %>
</body>
</html>