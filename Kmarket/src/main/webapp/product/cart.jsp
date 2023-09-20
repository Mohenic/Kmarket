<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./header.jsp" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <main id="product">
        <%@ include file="./category.jsp" %>
    <!-- 장바구니 페이지 -->
    <script>
    	$(function(){
			$('input[name=all]').change(function(){
				
				const isChecked =$(this).is(':checked');
				
				if(isChecked){
					$('input[name=chk]').prop('checked',true)
				}else {
					$('input[name=chk]').prop('checked',false)
				}
				
			});
		})
    
    
    	$(function(){
			var itemCount=0;
			var itemPrice=0;
			var itemDiscount=0;
			var itemDelivery=0;
			var itemPoint=0;
			var itemTotal=0;
			const seller =[];
    		//체크시 하단 주문정보변경
    		$('input[name=chk]').on("change",function(){
    			const tr =$(this).parent().parent();

	    			if($(this).prop('checked')==true){
	    				
	    				itemCount += parseInt(tr.find('.count').text());
	    				itemPrice += parseInt(tr.find('.price').text());
	    				itemDiscount += parseInt(parseInt(tr.find('.price').text())*(parseInt(tr.find('.discount').text())*0.01));
	    				
	    				if(!seller.includes(tr.find('.seller').text())){
	    					seller.push(tr.find('.seller').text());
	    					itemDelivery += parseInt(tr.find('.delivery').text());
	    					console.log(seller)
	    				}else {
	    					seller.push(tr.find('.seller').text());
	    				}
	    				itemPoint += parseInt(tr.find('.point').text());
	    				itemTotal += parseInt(tr.find('.total').text());
	    				
	    			}else if($(this).prop('checked')==false){
	    				const findindex =seller.indexOf(tr.find('.seller').text());
	    				console.log(findindex)
	    				seller.splice(findindex, 1);
	    				console.log(seller);
	    				itemCount -= parseInt(tr.find('.count').text());
	    				itemPrice -= parseInt(tr.find('.price').text());
	    				itemDiscount -= parseInt(tr.find('.price').text())-(parseInt(tr.find('.price').text())*(parseInt(tr.find('.discount').text())*0.01));
	    				if(!seller.includes(tr.find('.seller').text())){
	    					
	    					itemDelivery -= parseInt(tr.find('.delivery').text());

	    				}  				
	    				itemPoint -= parseInt(tr.find('.point').text());
	    				itemTotal -= parseInt(tr.find('.total').text());
	    				
	    			}
    			$('.itemCount').text(itemCount);
    			$('.itemPrice').text(itemPrice);
    			$('.itemDiscount').text(itemDiscount);
    			$('.itemDelivery').text(itemDelivery);
    			$('.itemDelivery2').val(itemDelivery);
    			$('.itemPoint').text(itemPoint);
    			$('.itemTotal').text(itemTotal);
    			$('.itemseller').text(seller);
    		})
    		

    		
    	
    	
    	})

    	
	$(function(){
		$('#del').click(function(e){
			e.preventDefault();
			
			var cartNo =[];
			
			$('input[name=chk]:checked').each(function(i){//체크된 리스트 저장
				cartNo.push($(this).val());
				console.log($(this).val());
            });
			
			console.log(cartNo)
			
			const jsonData = {
					"cartNo": cartNo
				};
				console.log(jsonData);
				
				$.ajax({
					url:'/Kmarket/product/delete.do',
					type:'GET',
					data: jsonData,
					dataType:'json',
					 traditional: true, //배열로 넘길때에는 반드시 이값을 줘야함
					success:function(data){
						if(data.result >=1){
							alert("장바구니에서 삭제했습니다")
							location.reload(true);//새로고침
						}else{
							alert("통신오류")
						}
					
					},
					error:function(request,error){
						alert("통신오류")
						alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					}
				});
			
		})
		
	})
    	

    	
    	
    </script>
            <section class="cart">
                <nav>
                <h1>장바구니</h1>
                <p>
                    HOME > <span>패션·의류·뷰티</span> > <strong>장바구니</strong>
                </p>
                </nav>
                <form action="/Kmarket/product/order.do" id="formOrder" method="get">
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
                    <c:if test="${list eq null }">
                    <tr class="empty">
                        <td colspan="7">장바구니에 상품이 없습니다.</td>
                    </tr>
                    </c:if>
                    <c:forEach var="list1" items="${requestScope.list}">
		            <tr class ="info">
		              <td><input type="checkbox" name="chk" value="${list1.cartNo}"></td>
		              <td>
		                <article>
		                  <a href="/Kmartek/product/list.do"><img src="/Kmarket/thumb/${list1.prodCate1}/${list1.prodCate2}/${lsit1.thumb1}" alt="상품 썸네일 1"></a>
		                  <div>
		                    <h2><a href="/Kmartek/product/list.do"></a>${list1.prodName }</h2>
		                    <p>${list1.descript}</p>
		                  </div>
		                </article>
		              </td>
		              <td class="hidden seller">${list1.seller}</td>
		              <td class="count">${list1.count}</td>
		              <td class="price">${list1.price}</td>
		              <td class="discount">${list1.discount}%</td>
		              <td class="point">${list1.point}</td>
		              <td class="delivery">${list1.delivery}</td>
		              <td class="total">${list1.total}</td>
					<input type="hidden" name="type" value="cart"/>
					<input type="hidden" name="uid" value="${list1.uid}"/>
					<input type="hidden" name="cartNo" value="${list1.cartNo}"/>
		            </tr>
		          	</c:forEach>
                    </tbody>
                </table>
                <input type="button" name="del" id="del" value="선택삭제">
				<!-- 장바구니 전체합계 -->
				<div class="total">
				    <h2>전체합계</h2>
				    <table border="0">
				    	<tr class="hidden">
				    		<td class="hidden itemseller"></td>
				    		<td class="hidden itemprodNo"></td>
				    	</tr>
				        <tr>
				            <td>상품수</td>
				            <td class="itemCount">선택된 상품이 없습니다</td>
				        </tr>
				        <tr>
				            <td>상품금액</td>
				            <td class="itemPrice">선택된 상품이 없습니다</td>
				        </tr>
				        <tr>
				            <td>할인금액</td>
				            <td class="itemDiscount">선택된 상품이 없습니다</td>
				        </tr>
				        <tr>
				            <td>배송비</td>
				            <td class="itemDelivery">선택된 상품이 없습니다</td>
				        </tr>
				        <tr>
				            <td>포인트</td>
				            <td class="itemPoint">선택된 상품이 없습니다</td>
				        </tr>
				        <tr>
				            <td>전체주문금액</td>
				            <td class="itemTotal">선택된 상품이 없습니다</td>
				        </tr>
				    </table>
				    <input type="hidden" name="delivery" class="itemDelivery2"/>
				    <input type="submit" name="btnOrder" value="주문하기">    
				</div>
                </form>
                
                <!-- 상단이동 버튼 -->
                <button type="button" id="top">상단이동</button>
            </section>
        </main>
<%@ include file="./footer.jsp" %>
</body>
</html>
