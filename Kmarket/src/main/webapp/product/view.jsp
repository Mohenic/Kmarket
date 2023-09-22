<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./header.jsp" %>
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
	<script>
	
	$(function(){
		// 장바구니 담기 ajax
		$('#btnCart').click(function(e){
			e.preventDefault();
			
			const uid = $('input[name=uid]').val();
			const prodNo = ${view.prodNo};
			const price = ${view.price};
			const point = ${view.point};
			const discount = ${view.discount};
			const delivery = ${view.delivery};
			const count = $('input[name=num]').val();
			  			
			const jsonData = {
				"uid": uid,
				"prodNo": prodNo,
				"price": price,
				"point": point,
				"discount": discount,
				"delivery": delivery,
				"count": count
				
			};
			console.log(jsonData);
			
			$.ajax({
				url:'/Kmarket/product/cart.do',
				type:'POST',
				data: jsonData,
				dataType:'json',
				success:function(data){
					if(data.result >= 1){
						alert('장바구니에 담았습니다!');			
					}else{
						alert('통신오류 다시 시도해주세요');
					}
				}
			});
			
		});
	})
	</script>
	
	<script>
		//상품 리뷰로 스크롤 이동    
	    document.querySelector('a[href="#productReviews"]').addEventListener('click', function (event) {
	        event.preventDefault();
	
	        const productReviewsSection = document.getElementById('productReviews');
	        if (productReviewsSection) {
	            productReviewsSection.scrollIntoView({ behavior: 'smooth' }); // 부드럽게 스크롤합니다.
	        }
	    });
	</script>
	
	<script>
	    // 상품 수량 감소/증가 버튼
	    // 초기 상품 가격, 할인 및 배송비 가져오기
	    const initialPrice = ${view.price};
	    const initialDiscount = ${view.discount};
	    const initialDelivery = ${view.delivery};
	    let currentQuantity = 1;
	    // 수량을 감소 함수
	    function decreaseValue() {
	        if (currentQuantity > 1) {
	            currentQuantity--;
	            updateQuantityAndTotal();
	        }
	        event.preventDefault();
	    }
	    // 수량 증가 함수
	    function increaseValue() {
	        currentQuantity++;
	        updateQuantityAndTotal();
	        event.preventDefault();
	    }
	    // 총 상품금액 업데이트 함수
	    function updateQuantityAndTotal() {
	        const numInput = document.getElementById("num");
	        numInput.value = currentQuantity;
	
	        const total = getTotalPrice(currentQuantity, initialPrice, initialDiscount, initialDelivery);
	
	        const totalElement = document.querySelector(".total span");
	        totalElement.textContent = total;
	    }
	    // 총 상품금액 계산 함수
	    function getTotalPrice(quantity, price, discount, delivery) {
	        const discountedPrice = price - (price * discount / 100);
	        const totalPrice = (discountedPrice * quantity) + delivery;
	        // 4자리수 "," 추가
	        const formattedTotalPrice = Math.floor(totalPrice).toLocaleString();
	        return formattedTotalPrice;
	    }
	    updateQuantityAndTotal();
	</script>
	
	<script>
		//상단 이동 버튼
		$(document).ready(function(){
		    $("#top").click(function(){
		        $("html, body").animate({scrollTop: 0}, "fast");
		    });
		});
	</script>

    <main id="product">
    	<%@ include file="./category.jsp" %>   
        <section class="view">
		<%@ include file="./menu.jsp" %>   
            
            <form action="/Kmarket/product/order.do" id="formOrder" method="get">
           	<input type="hidden" name="uid" value="${sessUser.uid}">
           	<input type="hidden" name="type" value="order">
           	
            <!-- View 시작 -->       
            <c:if test="${not empty view}">
            <article class="info">
                <div class="image">
                    <img src="/thumb/${view.prodCate1}/${view.prodCate2}/${view.thumb2}" alt="상품이미지"/>
                </div>
                <div class="summary">
                    <nav>
                        <h1>${view.company}</h1>
                        <h2>상품번호&nbsp;:&nbsp;<span>${view.prodNo}</span></h2>
                    </nav>                        
                    <nav>
                        <h3>${view.prodName}</h3>	
                        <p>${view.descript}</p>
                        <h5 class="rating star${view.score}"><a href="#productReviews">상품평보기</a></h5>
                    </nav>
                    <nav>
                        <c:if test="${view.discount != 0}">
                        <div class="org_price">
                            <del>${view.price}</del>
                            <span>${view.discount}%</span>
                        </div>
                        </c:if>
                        <div class="dis_price">
                        	<ins>${view.getDiscount(view.price,view.discount)}</ins>
                        </div>
                    </nav>
                    <nav>
                        <span class="delivery">
                            <c:choose>
						        <c:when test="${view.delivery == 0}">
						            배송비 무료
						        </c:when>
						        <c:otherwise>
						            배송비 ${view.delivery}원
						        </c:otherwise>
					    	</c:choose>
                        </span>
                        
                        <span class="arrival" id="arrivalDate"> 도착예정</span>
						<script>
						    const dt = new Date();
						    dt.setDate(dt.getDate() + 3);
						    const year = dt.getFullYear().toString().substr(2, 4);
						    const month = dt.getMonth() + 1;
						    const date = dt.getDate();
						    const dayOfWeek = ["일", "월", "화", "수", "목", "금", "토"][dt.getDay()];
						    const arrivalDateElement = document.getElementById("arrivalDate");
						    arrivalDateElement.innerHTML = month + "/" + date + " (" + dayOfWeek + ") "+" 도착예정";
						</script>
						
                        <span class="desc">본 상품은 국내배송만 가능합니다.</span>
                    </nav>
                    <nav>
                    <!-- 이미지 파일 없음, 다운로드 예정 -->
                        <span class="card cardfree"><i>아이콘</i>무이자할부</span>&nbsp;&nbsp;
                        <span class="card cardadd"><i>아이콘</i>카드추가혜택</span>
                    </nav>
                    <nav>
                        <span class="origin">원산지 - ${view.origin}</span>
                    </nav>
                    <img src="./images/vip_plcc_banner.png" alt="100원만 결제해도 1만원 적립!" class="banner" />
                    
                    <div class="count">
                        <button class="decrease" onclick="decreaseValue()">-</button>
						<input type="number" id="num" name="num" value="1" readonly/>
						<button class="increase" onclick="increaseValue()">+</button>
                    </div>
                    
                    <div class="total">
                        <span>${view.getTotal(view.price,view.discount,view.delivery)}</span>
                        <em>총 상품금액</em>
                    </div>

                    <div class="button">
                        <input type="button" class="cart" id="btnCart" value="장바구니"/>
                        <input type="submit" class="order" id="btnOrder" value="구매하기"/>
                    </div>
                </div>
            </article>
            </c:if>
            </form>
            <!-- 상품 정보 -->
            <article class="detail">
                <nav>
                    <h1>상품정보</h1>
                </nav>
                <!-- 상품 이미지 -->
                <img src="/thumb/${view.prodCate1}/${view.prodCate2}/${view.thumb3}" alt="상세페이지1">
                <img src="/thumb/${view.prodCate1}/${view.prodCate2}/${view.detail}" alt="상세페이지2">
            </article>

            <!-- 상품 정보 제공 고시 내용 -->
            <article class="notice">
                <nav>
                    <h1>상품 정보 제공 고시</h1>
                    <p>[전자상거래에 관한 상품정보 제공에 관한 고시] 항목에 의거 등록된 정보입니다.</p>
                </nav>
                <table border="0">
                    <tr>
                        <td>상품번호</td>
                        <td>${view.prodNo}</td>
                    </tr>
                    <tr>
                        <td>상품상태</td>
                        <td>${view.status}</td>
                    </tr>
                    <tr>
                        <td>부가세 면세여부</td>
                        <td>${view.duty}</td>
                    </tr>
                    <tr>
                        <td>영수증발행</td>
                        <td>${view.receipt}</td>
                    </tr>
                    <tr>
                        <td>사업자구분</td>
                        <td>${view.bizType}</td>
                    </tr>
                    <tr>
                        <td>브랜드</td>
                        <td>${view.company}</td>
                    </tr>
                    <tr>
                        <td>원산지</td>
                        <td>${view.origin}</td>
                    </tr>
                </table>
                <table border="0">
                    <tr>
                        <td>제품소재</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>색상</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>치수</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>제조자/수입국</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>제조국</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>취급시 주의사항</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>제조연월</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>품질보증기준</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>A/S 책임자와 전화번호</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>주문후 예상 배송기간</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                    <td colspan="2">구매, 교환, 반품, 배송, 설치 등과 관련하여 추가비용, 제한조건 등의 특이사항이 있는 경우</td>
                    </tr>
                </table>
                <p class="notice">
                    소비자가 전자상거래등에서 소비자 보호에 관한 법률 제 17조 제1항 또는 제3항에 따라 청약철회를 하고
                    동법 제 18조 제1항 에 따라 청약철회한 물품을 판매자에게 반환하였음에도 불구 하고 결제 대금의
                    환급이 3영업일을 넘게 지연된 경우, 소비자 는 전자상거래등에서 소비자보호에 관한 법률 제18조
                    제2항 및 동법 시행령 제21조 2에 따라 지연일수에 대하여 전상법 시행령으로 정하는 이율을 곱하여
                    산정한 지연이자(“지연배상금”)를 신청할 수 있습니다. 아울러, 교환∙반품∙보증 및 결제대금의
                    환급신청은 [나의쇼핑정보]에서 하실 수 있으며, 자세한 문의는 개별 판매자에게 연락하여 주시기 바랍니다.
                </p>
            </article>
            <!-- 상품 리뷰 내용 -->
    <article class="review" id="productReviews">
    <nav>
        <h1>상품리뷰</h1>
    </nav>
    <ul>
        <script>
            const sampleReviews = [
                {
                    rating: "star4",
                    author: "seo******",
                    date: "2018-07-10",
                    productName: "상품명1/BLUE/L",
                    content: "가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요. 아주 약간 루즈한정도...?그래도 이만한 옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는 제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~"
                },
                
                // 나머지 샘플 리뷰 데이터를 추가할 수 있습니다.
            ];

            for (let i = 0; i < 5; i++) {
                const review = sampleReviews[i];
                document.write(`
                    <li>
                        <div>
                            <h5 class="rating star4">상품평</h5>
                            <span>"seo******" "2018-07-10"</span>
                        </div>
                        <h3>"상품명1/BLUE/L"</h3>
                        <p>"가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요. 아주 약간 루즈한정도...?그래도 이만한 옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는 제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~"
                        </p>
                    </li>
                `);
            }
        </script>
    </ul>
</article>
            <!-- 번호 버튼 -->
            <div class="paging">
                <span class="prev">
                    <a href="#">< 이전</a>
                </span>
                <span class="num">
                    <a href="#" class="on">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>	
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">6</a>
                    <a href="#">7</a>
                </span>
                <span class="next">
                    <a href="#">다음 ></a>
                </span>
            </div>
            <!-- 상단 이동 버튼 -->
            <button type="button" id="top">상단이동</button>
        </section>
    </main>
    </div>
<%@ include file="./footer.jsp" %>
</body>
</html>