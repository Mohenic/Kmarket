<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                <li><a href="Kmarket/product/list.do" class="on">${prod.sold}</a></li>
                <li><a href="Kmarket/product/list.do">${prod.price}</a></li>
                <li><a href="Kmarket/product/list.do">${prod.price}</a></li>
                <li><a href="Kmarket/product/list.do">${prod.score}</a></li>
                <li><a href="Kmarket/product/list.do">${prod.review}</a></li>
                <li><a href="Kmarket/product/list.do">${prod.rdate}</a></li>
            </ul>
            <table border="0">
      
                <tbody>
                    <tr>
                        <td>
                            <a href="view.do?prodNo=${prod.prodNo}" class="thumb">
                                <img src="https://via.placeholder.com/120x120" alt="상품이미지">
                            </a>
                        </td>
                        <td>
                        	<h3 class="name">${prod.prodName}</h3>
                            <a href="view.do" class="desc">상품설명</a>
                        </td>
                        <td>
                            <ul>
                                <li>
                                    <ins class="dis-price">${prod.price}</ins>
                                </li>
                                <li>
                                    <del class="org-price">${prod.price}</del>
                                    <span class="discount">${prod.discount}</span>
                                </li>
                                <li>
                                    <span class="free-delivery">${prod.delivery}</span>
                                </li>
                            </ul>
                        </td>
                        <td>
                            <h4 class="seller">
                                <i class="fas fa-home" aria-hidden="true"></i>
                                판매자
                            </h4>
                            <h5 class="badge power">${prod.seller}</h5>
                            <h6 class="rating star1">상품평</h6>
                        </td>
                    </tr>
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