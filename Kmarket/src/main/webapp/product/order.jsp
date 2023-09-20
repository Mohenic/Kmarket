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
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="/Kmarket/product/JS/zipcode.js"></script>
    
</head>
<script>
	$(function(){
		let countRe=0;
		let deliveryRe=0;
		let priceRe=0;
		let totalRe=0;
		let discountRe=0;
		
		let count = $(".count").map(function() {
			  return $(this).text();
			}).get();
			console.log(count);
		
		let price = $(".price").map(function() {
			  return $(this).text();
			}).get();
			console.log(price);


		$.each(count,function(index,value){
			countRe +=parseInt(value,10);
		})
		$.each(price,function(index,value){
			priceRe +=parseInt(value,10);
		})



		console.log(countRe);
		$('.countRe').text(countRe+"건");
		$('.priceRe').text(priceRe+"원");
		$('.priceRe1').text(priceRe);

	
		let seller = $(".seller").map(function() {
			return $(this).text();
			  if(!seller.include($(this).text())){
				  
			  }
			}).get();
		console.log(seller)
		
		let delivery = $(".delivery1").map(function() {

			return $(this).text();
			}).get();
			console.log(delivery);
		
		$.each(delivery,function(index,value){
				deliveryRe +=parseInt(value,10);
		})
			
		$('.deliveryRe').text(deliveryRe+"원");
		
		let discount = $(".discount1").map(function() {

			return $(this).text();
			}).get();
			console.log(discount);
		
		$.each(discount,function(index,value){
				discountRe +=parseInt(value,10);
		})
			
		$('.discountRe').text("-"+discountRe+"원");
		
		var total = priceRe+deliveryRe-discountRe
		$('.totalRe').text(total+"원")
		
	
		$('input[name=select]').click(function(e){
			e.preventDefault();
			
			var point = $('input[name=point]').val();
			console.log(point)
			$('.point').text("-"+point+"원");
			var total = priceRe+deliveryRe-discountRe-point
			$('.totalRe').text(total+"원")
		})
		
		
	})
	
	$(function(){

		
		
		
	})
		
	
	
	
</script>
<body>
    <div id="container">
        <main id="product">
        <%@ include file="./category.jsp" %>
            <!-- 주문 페이지 시작-->
            <section class="order">
                <!-- 제목, 페이지 네비게이션 -->
                <nav>
                <h1>주문결제</h1>
                <p>
                    HOME > 장바구니 > <strong>주문결제</strong>
                </p>
                </nav>
                <form action="/Kmarket/product/order.do" method="post">
                <!-- 주문 상품 목록 -->                  
                <table>
                    <thead>
                    <tr>
                        <th>상품명</th>
                        <th>총수량</th>
                        <th>판매가</th>
                        <th>배송비</th>
                        <th>소계</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${type eq 'cart'}">
                    <c:forEach var="carts" items="${list}">
                    <tr>
                        <td>
                        <article>
                            <a href="#"><img src="/Kmarket/thumb/${carts.prodCate1}/${carts.prodCate2}/${carts.thumb1}" alt=""></a>
                            <div>
			                    <h2><a href="/Kmartek/product/list.do"></a>${carts.prodName }</h2>
			                    <p>${carts.descript}</p>
		                  </div>
                        </article>
                        </td>
                        <td class="hidden count">1</td>
                        <td class="hidden seller">${carts.seller}</td>
                        <td >${carts.count }</td>
                        <td class="price">${carts.price }</td>
                        <td class="delivery1">${carts.delivery }</td>
                        <td class="total">${carts.total }</td>
                        <td class="hidden discount1">${carts.getDiscountPrice2(carts.price,carts.discount) }</td>

                    </tr>
                    </c:forEach>
                    </c:if>
                    </tbody>
                </table>                 
                <!-- 최종 결제 정보 -->
                <div class="final">
                    <h2>최종결제 정보</h2>
                    <table border="0">
                    <input type="hidden" name="price" class="priceRe1"/>
                    <input type="hidden" name="discount" class="priceRe1"/>
                    <input type="hidden" name="delivery" class="priceRe1"/>
                    <input type="hidden" name="point" class="priceRe1"/>
                    <input type="hidden" name="total" class="priceRe1"/>
                    <input type="hidden" name="price" class="priceRe1"/>
                    <tr>
                        <td>총</td>
                        <td class="countRe"></td>
                       	
                    </tr>
                    <tr>
                        <td>상품금액</td>
                        <td class="priceRe">27,000</td>
                        
                    </tr>
                    <tr>
                        <td>할인금액</td>
                        <td class="discountRe">-1,000</td>
                    </tr>
                    <tr>
                        <td>배송비</td>
                        <td class="deliveryRe">0</td>
                    </tr>
                    <tr>
                        <td>포인트 할인</td>
                        <td class="point">0원</td>
                    </tr>
                    <tr>
                        <td>전체주문금액</td>
                        <td class="totalRe">25,000</td>
                    </tr>                            
                    </table>
                    <input type="button" name="" value="결제하기">              
                </div>
                    
                <!-- 배송정보 -->
                <article class="delivery">
                    <h1>배송정보</h1>                          
                    <table>
                    <tr>
                        <td>주문자</td>
                        <td><input type="text" name="orderer" value="${sessUser.name }" /></td>
                    </tr>
                    <tr>
                        <td>휴대폰</td>
                        <td>
                        <input type="text" name="hp" value="${sessUser.hp }" />
                        <span>- 포함 입력</span>
                        </td>
                    </tr>
                    <tr>
                        <td>우편번호</td>
                        <td>
                        <input type="text" name="zip" value="${sessUser.zip }"/>
                        
                        <button type="button" class="btnZip" onclick="zipcode()">검색</button>
                        </td>
                    </tr>
                    <tr>
                        <td>기본주소</td>
                        <td>
                        <input type="text" name="addr1" value="${sessUser.addr1 }"/>
                        </td>
                    </tr>
                    <tr>
                        <td>상세주소</td>
                        <td>
                        <input type="text" name="addr2" value="${sessUser.addr2 }"/>
                        </td>
                    </tr>
                    </table>
                </article>
                <!-- 할인정보 -->
                <article class="discount">
                    <h1>할인정보</h1>
                    <div>
                    <p>현재 포인트 : <span>${sessUser.point}</span>점</p>
                    <label>
                        <input type="text" name="point"/>점
                        <input type="button" name="select" value="적용"/>
                    </label>
                    <span>포인트 5,000점 이상이면 현금처럼 사용 가능합니다.</span>
                    </div>
                </article>
                <!-- 결제방법 -->
                <article class="payment">
                    <h1>결제방법</h1>
                    <div>
                        <span>신용카드</span>
                        <p>
                            <label><input type="radio" name="payment" value="type1"/>신용카드 결제</label>
                            <label><input type="radio" name="payment" value="type2"/>체크카드 결제</label>                                
                        </p>
                    </div>
                    <div>
                        <span>계좌이체</span>
                        <p>
                            <label><input type="radio" name="payment" value="type3"/>실시간 계좌이체</label>
                            <label><input type="radio" name="payment" value="type4"/>무통장 입금</label>                                
                        </p>
                    </div>
                    <div>
                        <span>기타</span>
                        <p>
                            <label><input type="radio" name="payment" value="type3"/>휴대폰결제</label>
                            <label>
                                <input type="radio" name="payment" value="type4"/>카카오페이
                                <img src="./images/ico_kakaopay.gif" alt="카카오페이"/>
                            </label>                                
                        </p>
                    </div>
                </article>
           
                <!-- 경고 -->
                <article class="alert">
                    <ul>
                        <li><span>케이마켓의 모든 판매자는 안전거래를 위해 구매금액, 결제수단에 상관없이 모든거래에 대하여 케이마켓 유한책임회사의 구매안전서비스(에스크로)를 제공하고 있습니다.</span></li>
                        <li><span>케이마켓 유한책임회사의 전자금융거래법에 의해 결제대금예치업 등록번호는 02-006-00008 입니다.</span></li>
                        <li><span>등록여부는 금융감독원 홈페이지(www.fss.or.kr)의 업무자료>인허가업무안내>전자금융업등록현황에서 확인하실수 있습니다.</span></li>
                    </ul>
                </article>
                </form>
            </section>
            <!-- 주문 페이지 끝-->
                <!-- 상단 이동 버튼 -->
                <button type="button" id="top">상단이동</button>
        </main>
    </div>
<%@ include file="./footer.jsp" %>
</body>
</html>