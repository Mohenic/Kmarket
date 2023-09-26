<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "../../_header.jsp" %>
<%@ include file = "../../_aside.jsp" %>

<script>
//1차 카테고리 선택시 2차 불러오게하는 스크립트
window.addEventListener('load', function() {
	function updateCateOptions() {
	    var CateSelect = document.querySelector('select[name="cate"]');
	    var typeSelect = document.querySelector('select[name="type"]');
	   
	    // 1차 카테값 가져오기
	    var selectedCateValue = CateSelect.value;
	   
        // 이전에 선택한 2차 카테고리 값과 텍스트 가져오기
        var selectedTypeValue = localStorage.getItem('selectedTypeValue');
        var selectedTypeText = localStorage.getItem('selectedTypeText');
	    // 2차 카테값 초기화
	    typeSelect.innerHTML = '';
	    // 1차 카테값에 따라 options 초기화
	    var options = []; // options 배열 초기화
	   
	    if (selectedCateValue === 'member') {
	        options = [
	            { text: '2차 분류 선택', value: '0' },
	            { text: '가입', value: '101' },
	            { text: '탈퇴', value: '102' },
	            { text: '회원정보', value: '103' },
	            { text: '로그인', value: '104' },
	        ];
	    } else if (selectedCateValue === 'event') {
	        options = [
	            { text: '2차 분류 선택', value: '0' },
	            { text: '쿠폰/할인혜택', value: '201' },
	            { text: '포인트', value: '202' },
	            { text: '제휴', value: '203' },
	            { text: '이벤트', value: '204' },
	        ];
	    } else if (selectedCateValue === 'pay') {
	        options = [
	            { text: '2차 분류 선택', value: '0' },
	            { text: '상품', value: '301' },
	            { text: '결제', value: '302' },
	            { text: '구매내역', value: '303' },
	            { text: '영수증/증빙', value: '304' },
	        ];
	    } else if (selectedCateValue === 'delivery') {
	        options = [
	            { text: '2차 분류 선택', value: '0' },
	            { text: '배송상태/기간', value: '401' },
	            { text: '배송정보확인/변경', value: '402' },
	            { text: '해외배송', value: '403' },
	            { text: '당일배송', value: '404' },
	            { text: '해외직구', value: '405' },
	        ];
	    } else if (selectedCateValue === 'cancel') {
	        options = [
	            { text: '2차 분류 선택', value: '0' },
	            { text: '반품신청/철회', value: '501' },
	            { text: '반품정보확인/변경', value: '502' },
	            { text: '교환 AS신청/철회', value: '503' },
	            { text: '교환신청/철회', value: '504' },
	            { text: '취소신청/철회', value: '505' },
	            { text: '취소확인/환불정보', value: '506' },
	        ];
	    } else if (selectedCateValue === 'travel') {
	        options = [
	            { text: '2차 분류 선택', value: '0' },
	            { text: '여행/숙박', value: '601' },
	            { text: '항공', value: '602' },
	        ];
	    } else if (selectedCateValue === 'safe') {
	        options = [
	            { text: '2차 분류 선택', value: '0' },
	            { text: '서비스 이용규칙 위반', value: '701' },
	            { text: '지식재산권침해', value: '702' },
	            { text: '법령 및 정책위반 상품', value: '703' },
	            { text: '게시물 정책위반', value: '704' },
	            { text: '직거래/외부거래유도', value: '705' },
	            { text: '표시광고', value: '706' },
	            { text: '청소년 위해상품/이미지', value: '707' },
	        ];
	    }
	   
        // 2차 카테 업데이트
        options.forEach(function(optionData) {
            var option = document.createElement('option');
            option.value = optionData.value;
            option.text = optionData.text;
            typeSelect.appendChild(option);
        });
        // 이전에 선택한 2차 카테고리 값과 텍스트 복원
        if (selectedTypeValue && selectedTypeText) {
            typeSelect.value = selectedTypeValue;
            typeSelect.options[typeSelect.selectedIndex].text = selectedTypeText;
        }
    }
    // 1차 카테 바뀔때 업데이트
    document.querySelector('select[name="cate"]').addEventListener('change', updateCateOptions);
    // 2차 카테고리 선택 시 localStorage에 저장
    document.querySelector('select[name="type"]').addEventListener('change', function() {
        var selectedTypeValue = this.value;
        var selectedTypeText = this.options[this.selectedIndex].text;
        // 선택한 2차 카테고리 값을 localStorage에 저장
        localStorage.setItem('selectedTypeValue', selectedTypeValue);
        localStorage.setItem('selectedTypeText', selectedTypeText);
        var selectedCateValue = document.querySelector('select[name="cate"]').value;
        // 페이지 리로드
        window.location.href = "/Kmarket/admin/cs/qna/list.do?group=qna&cate=" + selectedCateValue + "&type=" + selectedTypeValue;
    });
    // 초기화 시 1차 카테고리 선택에 따른 2차 카테고리 업데이트
    updateCateOptions();
});

</script>
<section id="admin-cs-faq-list">
            <nav>
                <h3>문의사항 목록</h3>
                <p>
                    HOME &gt; 고객센터 &gt; <strong>문의사항</strong>
                </p>
            </nav>
            <section id="admin-faq-list">
                <div>
                    <select name="cate" id="cateSelect">
                        <option value="0">유형선택</option>
                        <option value="member" ${cate == 'member' ? 'selected' : ''}>회원</option>
                        <option value="event" ${cate == 'event' ? 'selected' : ''}>쿠폰/이벤트</option>
                        <option value="pay" ${cate == 'pay' ? 'selected' : ''}>주문/결제</option>
                        <option value="delivery" ${cate == 'delivery' ? 'selected' : ''}>배송</option>
                        <option value="cancel" ${cate == 'cancel' ? 'selected' : ''}>취소/반품/교환</option>
                        <option value="travel" ${cate == 'travel' ? 'selected' : ''}>여행/숙박/항공</option>
                        <option value="safe" ${cate == 'safe' ? 'selected' : ''}>안전거래</option>
                    </select>
                    <select name="type" id="typeSelect">
                        <option value="0">유형선택</option>
                        <option value="service">고객서비스</option>
                        <option value="safe">안전거래</option>                                   
                        <option value="danger">위해상품</option>                                   
                        <option value="jackpot">이벤트당첨</option>
                    </select>
                </div>
                <form id="formFaqCheck" action="/Kmarket/admin/cs/qna/delete.do" method="get">
                <table>
                    <tbody>
                        <tr>
                            <th><input type="checkbox" name="all"></th>
                            <th>번호</th>
                            <th>1차유형</th>
                            <th>2차유형</th>
                            <th>제목</th>
                            <th>조회</th>
                            <th>날짜</th>
                            <th>관리</th>
                        </tr>
                        <c:forEach var="article" items="${article}">
                        <tr>
                            <td class="chk"><input type="checkbox" value="${article.no}" name="chk"></td>
                            <td class="no">${article.no}</td>
                            <td class="cateName">${article.cateName}</td>
                            <td class="type">${article.typeName}</td>
                            <td class="title"><a href="/Kmarket/admin/cs/qna/view.do?group=qna&cate=${cate}&no=${article.no}">${article.title}</a></td>
                            <td class="hit">${article.writer}</td>
                            <td class="rdate">${article.rdate}</td>
                            <td>
                            <c:if test="${article.comment ne 1}">
                            	검토중
                            </c:if>
                             <c:if test="${article.comment eq 1}">
                            	답변완료
                            </c:if>	
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </form>
 				<a href="#" class="btnDelete">선택삭제</a>
                <div class="paging">
                <c:if test="${pageGroupStart > 1}">
                    <span class="prev">
                        <a href="/Kmarket/admin/cs/qna/list.do?group=qna&cate=${cate}&pg=${pageGroupStart - 1}">&lt;&nbsp;이전</a>
                    </span>
                </c:if>
                <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
                    <span class="num">
                        <a href="/Kmarket/admin/cs/qna/list.do?group=qna&cate=${cate}&pg=${i}" class="num ${currentPage==i ? 'current' : 'on' }">${i}</a>
                    </span>
                </c:forEach>
                <c:if test="${pageGroupEnd < lastPageNum}">
                    <span class="next">
                        <a href="/Kmarket/admin/cs/qna/list.do?group=qna&cate=${cate}&pg=${pageGroupEnd + 1}">다음&nbsp;&gt;</a>
                    </span>
                </c:if>
                </div>
            </section> <!--table end-->
        </section><!--admin-product-list end-->
    </main>
<%@include file ="../../_footer.jsp" %> 