
 /**
 * 
 */

 


	//폼데이터 검증결과 상태 변수
	
	let isUidOk =false;
	let isPassOk =false;
	let isNameOk =false;
	let isNickOk =false;
	let isEmailOk =false;
	let isHpOk =false;
	
	let reUid   = /^[a-z]+[a-z0-9]{4,19}$/g;
	let rePass  = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{5,16}$/;
	let reName  = /^[가-힣]{2,10}$/ 
	let reNick  = /^[a-zA-Zㄱ-힣0-9][a-zA-Zㄱ-힣0-9]*$/;
	let reEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	let reHp    = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;


	//유효성검증(Valiation)
	$(function (){
		
		//비밀번호검사
		$('input[name=pass2]').focusout(function(){
			
			const pass1 =$('input[name=pass1]').val();
			const pass2 =$('input[name=pass2]').val();
			
			if(pass1 == pass2 ){
				
				isPassOk=true;
				
				if(pass1.match(rePass)){
					$('.resultPass').css('color','blue').text('사용할수 있는 비밀번호입니다');	
					isPassOk=true;
				}else{
					$('.resultPass').css('color','red').text('비밀번호는 숫자,영문,특수문자 조합 5자리 이상이여야 합니다');
					isPassOk=false;
				}
				
				
			}else{
				$('.resultPass').css('color','red').text('비밀번호가 일치하지 않습니다');
				isPassOk =false;
			}
			
		})
		
		
		
		
		//이름검사
		$('input[name=name]').focusout(function(){
			const name =$('input[name=name]').val();
			
			if(!name.match(reName)){
				$('.resultName').css('color','red').text('유효하지않는 이름입니다');
				isNameOk=false;
			}else{
				$('.resultName').text('');
				isNameOk=true;
			}
		
		})
		
		
		//이메일검사
		$('input[name=email]').focusout(function(){
			const email =$('input[name=email').val();
			
			if(!email.match(reEmail)){
				$('.resultEmail').css('color','red').text('유효하지않는 이메일입니다');
				isEmailOk=false;
			}else{
				$('.resultEmail').text('');
				isEmailOk=true;
			}
		})
		
		 /* $('input[name=hp]').focusout(function(){

            //입력데이터 받기
            const resultHp = $("#resultHp").val();
            console.log("resultHp = " + resultHp); // 값을 받아 오질 못함

            if(!resultHp.match(reHp)){
                $("#resultHp").css("color","red").text('유효한 휴대폰 번호가 아닙니다');
                isHpOk = false;
                return;
            }*/
	
		//휴대폰검사
		$('input[name=hp]').focusout(function(){
			const hp =$('input[name=hp').val();
			
			if(!hp.match(reHp)){
				$('.resultHp').css('color','red').text('유효하지않는 번호');
				isHpOk=false;
			}else{
				$('.resultHp').text('');
				isHpOk=true;
			}
		})
				
		//최종전송
		$('#formUser').submit(function(e){
			
			//alert('전송');
			
			if(!isUidOk){
				alert('이름을 확인하세요.');
				return false;
			} 
				
			if(!isPassOk){
				alert('비밀번호을 확인하세요.');
				return false;
			}
			
			if(!isNameOk){
				alert('이름을 확인하세요.');
				return false;	
			}
			
			if(!isNickOK){
				alert('별명을 확인하세요.');
				return false;
			}
			
			if(!isEmailOk){
				alert('이메일을 확인하세요.');
				return false;
			}
			
			if(!isHpOk){
				alert('전화번호을 확인하세요.');
				return false;
			}
	
			return true;
		});
		
	})//jquery end
