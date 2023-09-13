<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
    <div id="container">
        <main id="product">
        <%@ include file="./category.jsp" %>
    <!-- 장바구니 페이지 -->
            <section class="cart">
                <nav>
                <h1>장바구니</h1>
                <p>
                    HOME > <span>패션·의류·뷰티</span> > <strong>장바구니</strong>
                </p>
                </nav>
                <form action="#">
                <!-- 장바구니 목록 -->
                <table>
                    <thead>
                    <tr>
                        <th><input type="checkbox" name="all"></th>
                        <th>상품명</th>
                        <th>총수량</th>
                        <th>판매가</th>
                        <th>할인</th>
                        <th>포인트</th>
                        <th>배송비</th>
                        <th>소계</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="empty">
                        <td colspan="7">장바구니에 상품이 없습니다.</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name=""></td>
                        <td>
                        <article>
                            <a href="#"><img src="https://via.placeholder.com/80x80" alt=""></a>
                            <div>
                            <h2><a href="#">상품명</a></h2>
                            <p>상품설명</p>
                            </div>
                        </article>
                        </td>
                        <td>1</td>
                        <td>27,000</td>
                        <td>5%</td>
                        <td>270</td>
                        <td>무료배송</td>
                        <td>27,000</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name=""></td>
                        <td>
                        <article>
                            <a href="#"><img src="https://via.placeholder.com/80x80" alt=""></a>
                            <div>
                            <h2><a href="#">상품명</a></h2>
                            <p>상품설명</p>
                            </div>
                        </article>
                        </td>
                        <td>1</td>
                        <td>27,000</td>
                        <td>5%</td>
                        <td>270</td>
                        <td>무료배송</td>
                        <td>27,000</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name=""></td>
                        <td>
                        <article>
                            <a href="#"><img src="https://via.placeholder.com/80x80" alt=""></a>
                            <div>
                            <h2><a href="#">상품명</a></h2>
                            <p>상품설명</p>
                            </div>
                        </article>
                        </td>
                        <td>1</td>
                        <td>27,000</td>
                        <td>5%</td>
                        <td>270</td>
                        <td>무료배송</td>
                        <td>27,000</td>
                    </tr>
                    </tbody>
                </table>
                <input type="button" name="del" value="선택삭제">

                <!-- 장바구니 전체합계 -->
                <div class="total">
                    <h2>전체합계</h2>
                    <table border="0">
                    <tr>
                        <td>상품수</td>
                        <td>1</td>
                    </tr>
                    <tr>
                        <td>상품금액</td>
                        <td>27,000</td>
                    </tr>
                    <tr>
                        <td>할인금액</td>
                        <td>-1,000</td>
                    </tr>
                    <tr>
                        <td>배송비</td>
                        <td>0</td>
                    </tr>              
                    <tr>
                        <td>포인트</td>
                        <td>260</td>
                    </tr>
                    <tr>
                        <td>전체주문금액</td>
                        <td>26,000</td>
                    </tr>
                    </table>
                    <input type="submit" name="" value="주문하기">    
                </div>
                </form>
                
                <!-- 상단이동 버튼 -->
                <button type="button" id="top">상단이동</button>
            </section>
        </main>
    </div>
<%@ include file="./footer.jsp" %>
</body>
</html>
