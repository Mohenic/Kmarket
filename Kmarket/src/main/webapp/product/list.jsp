<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./header.jsp" %>
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <main id="product">
    	<%@ include file="./category.jsp" %>   
        <section class="list">
		<%@ include file="./menu.jsp" %>   
				<ul class="sort">
				    <li>
				    	<c:set var="sortOption" value="Selling"/>
				        <a href="list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&sort=sold&order=DESC" class="${param.sort == 'sold' ? 'on' : ''}">판매많은순</a>
				    </li>
					<li>
					    <c:set var="sortOption" value="lowprice"/>
					    <a href="list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&sort=price&order=ASC" class="${param.sort == 'price' && param.order == 'ASC' ? 'on' : ''}">낮은가격순</a>
					</li>
					<li>
					    <c:set var="sortOption" value="highprice"/>
					    <a href="list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&sort=price&order=DESC" class="${param.sort == 'price' && param.order == 'DESC' ? 'on' : ''}">높은가격순</a>
					</li>
				    <li>
				        <c:set var="sortOption" value="highrating"/>
				        <a href="list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&sort=score&order=DESC" class="${param.sort == 'score' ? 'on' : ''}">평점높은순</a>
				    </li>
				    <li>
				        <c:set var="sortOption" value="manyreviews"/>
				        <a href="list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&sort=review&order=DESC" class="${param.sort == 'review' ? 'on' : ''}">후기많은순</a>
				    </li>
				    <li>
				        <c:set var="sortOption" value="recent"/>
				        <a href="list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&sort=rdate&order=DESC" class="${param.sort == 'rdate' ? 'on' : ''}">최근등록순</a>
				    </li>
				</ul>
            <table border="0">
      
                <tbody>
                    <c:forEach var="prod" items="${list}">
                    <tr>
                        <td>
                            <a href="view.do?prodNo=${prod.prodNo}" class="thumb">
                                <img src="/Kmarket/thumb/${prod.prodCate1}/${prod.prodCate2}/${prod.thumb1}" alt="상품이미지">
                            </a>
                        </td>
                        <td>
                        <a href="view.do?prodNo=${prod.prodNo}">
                        	<h3 class="name">${prod.prodName}</h3>
                        	</a>
                            <p class="desc">${prod.descript}</p>
                        </td>
                        <td>
                            <ul>
                                <li><ins class="dis-price">${prod.getDiscount(prod.price,prod.discount)}</ins></li>
                            	<c:if test="${prod.discount != 0}">
                                <li>
                                    <del class="org-price">${prod.price}</del>
                                    <span class="discount">${prod.discount}%</span>
                                </c:if>
                                </li>
								<li><span class="<c:if test="${prod.delivery == 0}">free-delivery</c:if>"></span></li>
                            </ul>
                        </td>
                        <td>
                            <h4 class="seller"><i class="fas fa-home"></i>${prod.company}</h4>
                            <h5 class="badge power">${prod.hit}</h5>
                            <h6 class="rating star${prod.score}"></h6>
                        </td>	
                    </tr>
                    </c:forEach>
                </tbody>
            </table>

           <!-- 번호 버튼 -->
			<div class="paging">
			    <c:if test="${pageGroupStart > 1}">
			        <span class="prev">
			            <a href="list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&sort=${param.sort}&order=${param.order}&pg=${pageGroupStart - 1}">&lt;&nbsp;이전</a>
			        </span>
			    </c:if>
			    <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
			        <span class="num">
			            <a href="list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&sort=${param.sort}&order=${param.order}&pg=${i}" class="num ${currentPage !=i ? 'current' : 'on' }">${i}</a>
			        </span>
			    </c:forEach>
			    <c:if test="${pageGroupEnd < lastPageNum}">
			        <span class="next">
			            <a href="list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&sort=${param.sort}&order=${param.order}&pg=${pageGroupEnd + 1}">다음&nbsp;&gt;</a>
			        </span>
			    </c:if>
			</div>
			<!-- 상단 이동 버튼 -->
            <button type="button" id="top">상단이동</button>
        </section>
    </main>
<%@ include file="./footer.jsp" %>
</body>
</html>	