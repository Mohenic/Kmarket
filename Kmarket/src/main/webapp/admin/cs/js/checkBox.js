	$(function(){
		
		$('input[name=all]').change(function(){
			const isChecked = $(this).is(':checked');
			
			if(isChecked){
				// 전체선택
				$('input[name=chk]').prop('checked', true);
			}else{
				// 전체해제
				$('input[name=chk]').prop('checked', false);
			}
		});
		
		$('.btnDelete').click(function(e){
			e.preventDefault();
			$('#formChk').submit();
		});
	});
