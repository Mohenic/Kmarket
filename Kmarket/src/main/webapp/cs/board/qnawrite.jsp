<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
	날짜 : 2023.09.18
	작성자 : 이성찬
	내용 :  글쓰기(Ajax) 미완료 한 것 처리 중..
	
 -->
<%@ include file="../_header.jsp" %>
<c:import url="./aside.jsp" />
 <script>
 	window.addEventListener('load', function() {
 		//1차 카테고리 선택시 2차 카테고리 불러오는 함수(admin.register 참조...)
		function updateTypeOptions(){
			var cateSelect = document.querySelector('select[name="cate"]');
			var typeSelect = document.querySelector('select[name="type"]');
		
			//1차 카테값 가져오기
			var selectedCateValue = cateSelect.value;
			
			//2차 카테값 초기화
			typeSelect.innerHTML = '';
			
			//1차 카테값에 따라 options 초기화
		 	var options;
			if(selectedCateValue === "member"){
				options = [
					{text : '2차 분류 선택', value : ''},
					{text : '가입', value : '101'},
					{text : '탈퇴', value : '102'},
					{text : '회원정보', value : '103'},
					{text : '로그인', value : '104'},
				];
			}else if(selectedCateValue === "event"){
				options = [
					{text : '2차 분류 선택', value : ''},
					{text : '쿠폰/할인혜택', value : '201'},
					{text : '포인트', value : '202'},
					{text : '제휴', value : '203'},
					{text : '이벤트', value : '204'},
				];
 			}else if(selectedCateValue === "pay"){
 				options = [
					{text : '2차 분류 선택', value : ''},
					{text : '상품', value : '301'},
					{text : '결제', value : '302'},
					{text : '구매내역', value : '303'},
					{text : '영수증/증빙', value : '304'},
				];
 			}else if(selectedCateValue === "delivery"){
 				options = [
					{text : '2차 분류 선택', value : ''},
					{text : '배송상태/기간', value : '401'},
					{text : '배송정보확인/변경', value : '402'},
					{text : '해외배송', value : '403'},
					{text : '당일배송', value : '404'},
					{text : '해외직구', value : '405'},
				];
 			}else if(selectedCateValue === "cancel"){
 				options = [
					{text : '2차 분류 선택', value : ''},
					{text : '반품신청/철회', value : '501'},
					{text : '반품정보확인/변경', value : '502'},
					{text : '교환 AS신청/철회', value : '503'},
					{text : '교환신청/철회', value : '504'},
					{text : '취소신청/철회', value : '505'},
					{text : '취소확인/환불정보', value : '506'},
				];
 			}else if(selectedCateValue === "travel"){
 				options = [
					{text : '2차 분류 선택', value : ''},
					{text : '여행/숙박', value : '601'},
					{text : '항공', value : '602'},
				];
 			}else if(selectedCateValue === "safe"){
 				options = [
					{text : '2차 분류 선택', value : ''},
					{text : '서비스 이용규칙 위반', value : '701'},
					{text : '지적재산권침해', value : '702'},
					{text : '법령 및 정잭위반 상품', value : '703'},
					{text : '게시판 정책위반', value : '704'},
					{text : '직거래/외부거래유도', value : '705'},
					{text : '표시광고', value : '706'},
					{text : '청소년 위해상품/이미지', value : '707'},
				];
 			}
			
			
			
			
			//2차 카테로그 업데이트
			options.forEach(function(optionData){
				var option = document.createElement("option");
				option.value = optionData.value;
				option.text = optionData.text;
				typeSelect.appendChild(option);
			});// updateCateOptions() end
 		}
		// 1차 카테 바뀔때 업데이트
		document.querySelector('select[name="cate"]').addEventListener('change', updateTypeOptions);

		// 1차 카테 선택후 2차 업데이트
		updateTypeOptions();
		
 	});//window.addEventListener end
 		
 	window.addEventListener('load', function(){
 	
 		 function updateFormAction() {
 			//cate, type 값 선택
 	 		var CateValue = document.querySelector('select[name="cate"]').value;
 	 		var TypeValue = document.querySelector('select[name="type"]').value;
 	 		
 	 		console.log("CateValue: " + CateValue);
	        console.log("TypeValue: " + TypeValue);
 	 		
 	 		//form요소 선택
 	 		var form = document.forms["cateForm"];
 	 		
 	 		// action안에 경로값 변경
 	 		form.action = '/Kmarket/cs/qna/write.do?cate=' + CateValue + '&type=' + TypeValue;
 		 }
 		
 		
 		// 경로값 변경 적용
	    document.querySelector('select[name="cate"]').addEventListener('change', updateFormAction);
	    document.querySelector('select[name="type"]').addEventListener('change', updateFormAction);
 		
 	});
 	
 	
</script>
                        <form action="/Kmarket/cs/board/qna/write.do" method="post">
                        <input type="hidden" name="group" value="${group}">
                        <input type="hidden" name="writer" value="${sessUser.uid}">
                            <table>
                                <tbody>
                                    <tr>
                                        <td>문의유형</td>
                                        <td>
                                         <select name="cate">
                                                <option>선택</option>
                                                <option ${cate eq 'member' ? 'selected':''} value="member">회원</option>
                                                <option ${cate eq 'event' ? 'selected':''} value="event">쿠폰/이벤트</option>
                                                <option ${cate eq 'pay' ? 'selected':''} value="pay">주문/결제</option>
                                                <option ${cate eq 'delivery' ? 'selected':''} value="delivery">배송</option>
                                                <option ${cate eq 'cancel' ? 'selected':''} value="cancel">취소/반품/교환</option>
                                                <option ${cate eq 'travel' ? 'selected':''} value="travel">여행/숙박/항공</option>
                                                <option ${cate eq 'safe' ? 'selected':''} value="safe">안전거래</option>
                                            </select>
                                            
                                            <select name="type">
                                                <option>선택</option>
                                                <option selected value="101">가입</option>
                                                <option value="102">탈퇴</option>
                                                <option value="103">회원정보</option>
                                                <option value="104">로그인</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>문의제목</td>
                                        <td><input type="text" name="title" placeholder="제목을 입력하세요."></td>
                                    </tr>
                                    <tr>
                                        <td>문의내용</td>
                                        <td>
                                            <textarea type="text" name="content" placeholder="내용을 입력하세요."></textarea>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="qna_button">
                                <a href="/Kmarket/cs/board/${group}/list.do?group=${group}&cate=${cate}&pg=1" class="btnList">취소하기</a>
                                <input type="submit" class="btnSubmit" value="등록하기">
                            </div>
                        </form>
                    </article>
                </section>
            </div>
        </section>
<%@ include file="../_footer.jsp" %>