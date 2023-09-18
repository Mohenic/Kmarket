/**
 * 작업자 : 손영우
 * 작업시작일 : 2023/09/17
 * 작업종료일 : 2023/09/17
 */

	// 1차 카테고리 선택시 2차 불러오게하는 스크립트
	
	window.addEventListener('load', function() {
		function updateProdCate2Options() {
		    var prodCate1Select = document.querySelector('select[name="prodCate1"]');
		    var prodCate2Select = document.querySelector('select[name="prodCate2"]');
		    
		    // 1차 카테값 가져오기
		    var selectedCate1Value = prodCate1Select.value;

		    // 2차 카테값 초기화
		    prodCate2Select.innerHTML = '';

		    // 1차 카테값에 따라 options 초기화
		    var options;
		    if (selectedCate1Value === '10') { 
		        options = [
		            { text: '2차 분류 선택', value: '' },
		            { text: '브랜드 여성의류', value: '10' },
		            { text: '브랜드 남성의류', value: '11' },
		            { text: '브랜드 진/캐쥬얼', value: '12' },
		            { text: '브랜드 신발/가방', value: '13' },
		            { text: '브랜드 쥬얼리/시계', value: '14' },
		            { text: '브랜드 아웃도어', value: '15' }
		        ];
		    } else if (selectedCate1Value === '11') {
		        options = [
		            { text: '2차 분류 선택', value: '' },
		            { text: '여성의류', value: '10' },
		            { text: '남성의류', value: '11' },
		            { text: '언더웨어', value: '12' },
		            { text: '신발', value: '13' },
		            { text: '가방/잡화', value: '14' },
		            { text: '쥬얼리/시계', value: '15' },
		            { text: '화장품/향수', value: '16' },
		            { text: '바디/헤어', value: '17' }
		        ];
		    } else if (selectedCate1Value === '12') {
		        options = [
		            { text: '2차 분류 선택', value: '' },
		            { text: '출산/육아', value: '10' },
		            { text: '장난감/완구', value: '11' },
		            { text: '유아동 의류', value: '12' },
		            { text: '유아동 신발/잡화', value: '13' }
		        ];
		    } else if (selectedCate1Value === '13') {
		        options = [
		            { text: '2차 분류 선택', value: '' },
		            { text: '신선식품', value: '10' },
		            { text: '가공식품', value: '11' },
		            { text: '건강식품', value: '12' },
		            { text: '커피/음료', value: '13' },
		            { text: '생필품', value: '14' },
		            { text: '바디/헤어', value: '15' }
		        ];
		    } else if (selectedCate1Value === '14') {
		        options = [
		            { text: '2차 분류 선택', value: '' },
		            { text: '가구/DIY', value: '10' },
		            { text: '침구/커튼', value: '11' },
		            { text: '조명/인테리어', value: '12' },
		            { text: '생활용품', value: '13' },
		            { text: '주방용품', value: '14' },
		            { text: '문구/사무용품', value: '15' },
		            { text: '사무기기', value: '16' },
		            { text: '악기/취미', value: '17' },
		            { text: '반려동물용품', value: '18' }
		        ];
		    } else if (selectedCate1Value === '15') {
		        options = [
		            { text: '2차 분류 선택', value: '' },
		            { text: '노트북/PC', value: '10' },
		            { text: '모니터/프린터', value: '11' },
		            { text: 'PC주변기기', value: '12' },
		            { text: '모바일/태블릿', value: '13' },
		            { text: '카메라', value: '14' },
		            { text: '게임', value: '15' },
		            { text: '영상가전', value: '16' },
		            { text: '주방가전', value: '17' },
		            { text: '계절가전', value: '18' },
		            { text: '생활/미용가전', value: '19' },
		            { text: '음향가전', value: '20' },
		            { text: '건강가전', value: '21' }
		        ];
		    } else if (selectedCate1Value === '16') {
		        options = [
		            { text: '2차 분류 선택', value: '' },
		            { text: '스포츠의류/운동화', value: '10' },
		            { text: '휘트니스/수영', value: '11' },
		            { text: '구기/라켓', value: '12' },
		            { text: '골프', value: '13' },
		            { text: '자전거/보드/기타레저', value: '14' },
		            { text: '캠핑/낚시', value: '15' },
		            { text: '등산/아웃도어', value: '16' },
		            { text: '건강/의료용품', value: '17' },
		            { text: '건강식품', value: '18' },
		            { text: '렌탈서비스', value: '19' }
		        ];
		    } else if (selectedCate1Value === '17') {
		        options = [
		            { text: '2차 분류 선택', value: '' },
		            { text: '자동차용품', value: '10' },
		            { text: '공구/안전/산업용품', value: '11' }
		        ];
		    } else if (selectedCate1Value === '18') {
		        options = [
		            { text: '2차 분류 선택', value: '' },
		            { text: '여행/항공권', value: '10' },
		            { text: '도서/음반/e교육', value: '11' },
		            { text: '공연티켓', value: '12' },
		            { text: 'e쿠폰', value: '13' },
		            { text: '상품권', value: '13' }
		        ];
		    }

		    // 2차 카테 업데이트
		    options.forEach(function(optionData) {
		        var option = document.createElement('option');
		        option.value = optionData.value;
		        option.text = optionData.text;
		        prodCate2Select.appendChild(option);
		    });
		}
		// 1차 카테 바뀔때 업데이트
		document.querySelector('select[name="prodCate1"]').addEventListener('change', updateProdCate2Options);

		// 1차 카테 선택후 2차 업데이트
		updateProdCate2Options();
	});
	
		
	    
	// prodCate1 , prodCate2 값 경로에 저장하는 스크립트
	
	window.addEventListener('load', function() {
	    function updateFormAction() {
	        // prodCate1, prodCate2 값 선택
	        var prodCate1Value = document.querySelector('select[name="prodCate1"]').value;
	        var prodCate2Value = document.querySelector('select[name="prodCate2"]').value;
	        
	        console.log("prodCate1Value: " + prodCate1Value);
	        console.log("prodCate2Value: " + prodCate2Value);
	
	        // form 값 선택
	        var form = document.forms["cateForm"];
	        
	        // action 안에 경로값 변경
	        form.action = '/Kmarket/admin/product/register.do?cate1=' + prodCate1Value + '&cate2=' + prodCate2Value;
	    }
	
	    // 경로값 변경 적용
	    document.querySelector('select[name="prodCate1"]').addEventListener('change', updateFormAction);
	    document.querySelector('select[name="prodCate2"]').addEventListener('change', updateFormAction);
	});