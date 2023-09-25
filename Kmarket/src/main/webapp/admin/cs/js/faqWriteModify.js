// 1차 카테고리 선택시 2차 불러오게하는 스크립트

window.addEventListener('load', function() {
	function updateTypeOptions() {
	    var cateSelect = document.querySelector('select[name="cate"]');
	    var typeSelect = document.querySelector('select[name="type"]');
	    
	    // 1차 카테값 가져오기
	    var selectedCateValue = cateSelect.value;

	    // 2차 카테값 초기화
	    typeSelect.innerHTML = '';

	    // 1차 카테값에 따라 options 초기화
	    var options;
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
	}
	// 1차 카테 바뀔때 업데이트
	document.querySelector('select[name="cate"]').addEventListener('change', updateTypeOptions);

	// 1차 카테 선택후 2차 업데이트
	updateTypeOptions();
});

