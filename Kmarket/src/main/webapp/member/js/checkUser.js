/**
 * 
 */

 /**
 * 사용자 개인정보 중복체크
 */
$(function(){
	
	// 아이디 중복체크
	$('#btnCheckUid').click(function(){
		
		const uid = $('input[name=uid]').val();
		
		if(!uid.match(reUid)){
			$('.resultUid').css('color', 'red').text('유효한 아이디가 아닙니다.');
			isUidOk = false;
			return; // 종료
		}
		    			
		const jsonData = {
			"uid": uid
			
		};
		console.log(jsonData);
		
		$.ajax({
			url:'/Kmarket/member/checkUid.do',
			type:'GET',
			data: jsonData,
			dataType:'json',
			success:function(data){
				if(data.result >= 1){
					$('.resultUid').css('color', 'red').text('이미 사용중인 아이디 입니다.');
					isUidOk = false;
				}else{
					$('.resultUid').css('color', 'green').text('사용 가능한 아이디 입니다.');
					isUidOk = true;
				}
			}
		});
		
	}); // 아이디 중복체크 끝
	
	
	// 이메일 중복체크
	document.getElementsByName('email')[0].onfocusout = function(){
		
		const resultEmail = document.getElementById('resultEmail');
		
		// 입력 데이터 가져오기
		const email = this.value;
		
		if(!email.match(reEmail)){
			resultEmail.innerText = '유효한 이메일이 아닙니다.';
			resultEmail.style.color = 'red';
			isEmailOk = false;
			return;
		}

		// 데이터 전송
		const xhr = new XMLHttpRequest();
		xhr.open('GET', '/Kmarket/member/checkEmail.do?email='+email);
		xhr.send();
		
		// 응답 결과
		xhr.onreadystatechange = function(){    				
			if(xhr.readyState == XMLHttpRequest.DONE){						
				if(xhr.status == 200){
					const data = JSON.parse(xhr.response);
					console.log('data : ' + data);
					
					if(data.result4 >= 1){
						resultEmail.innerText = '이미 사용중인 이메일 입니다.';
						resultEmail.style.color = 'red';
						isEmailOk = false;
					}else{
						resultEmail.innerText = '사용 가능한 이메일 입니다.';
						resultEmail.style.color = 'green';
						isEmailOk = true;
					}
				}
			}    				
		}// onreadystatechange end
	} // 이메일 중복체크 끝
	
	// 휴대폰 중복체크
	document.getElementsByName('hp')[0].addEventListener('focusout', function(){
		
		const resultHp = document.getElementById('resultHp');
		const hp = this.value;
		
		if(!hp.match(reHp)){
			resultHp.innerText = '유효한 휴대폰번호가 아닙니다.';
			resultHp.style.color = 'red';
			isHpOk = false;
			return;
		}
		
		const url = '/Kmarket/member/checkHp.do?hp='+this.value;
		
		fetch(url)
			.then(response => response.json())
			.then(data => {
				console.log(data);
				
				if(data.result3 >= 1){
					resultHp.innerText = '이미 사용중인 휴대폰번호 입니다.';
					resultHp.style.color = 'red';
					isHpOk = false;
				}else{
					resultHp.innerText = '사용 가능한 휴대폰번호 입니다.';
					resultHp.style.color = 'green';
					isHpOk = true;
				}
			});
		
	}); // 휴대폰 중복체크 끝
	
}); // 사용자 개인정보 중복체크 끝