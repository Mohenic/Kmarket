<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="./_header.jsp" %>
<script type="text/javascript">
    	window.onload=function(){
    		
    		const agree1=document.getElementsByName('agree1')[0];
    		const agree2=document.getElementsByName('agree2')[0];
    		const agree3=document.getElementsByName('agree3')[0];
    		
    		const agree=document.querySelector('.agree');
    		const type=${type};
    		agree.addEventListener('click',function(e){
    			e.preventDefault();
    			
    		if(type==1){	
    			if(agree1.checked==false){
    				alert('이용약관에 동의하셔야합니다')
    				return;
    			}else if(agree2.checked==false){
    				alert('전자금융거래 이용약관에 동의하셔야 합니다')
    				return;
    			}else if(agree3.checked==false){
    				alert('개인정보 취급방침에 동의하셔야 합니다')
    				return;
    			}else {
    				location.href='/Kmarket/member/register.do?type=1'
    			}
    		}else if (type==2){
    			if(agree1.checked==false){
    				alert('이용약관에 동의하셔야합니다')
    				return;
    			}else if(agree2.checked==false){
    				alert('전자금융거래 이용약관에 동의하셔야 합니다')
    				return;
    			}else if(agree3.checked==false){
    				alert('개인정보 취급방침에 동의하셔야 합니다')
    				return;
    			}else {
    				location.href='/Kmarket/member/registerSeller.do?type=2'
    			}
    			
    			
    			
    		}
    			
    		})
    	}
    
</script>

        <main id ="member">
            <div class ="signup"> 
                <nav>
                    <h1>약관동의</h1>
                </nav>
                <section>
                    <h3>
                        <span class="essential">(필수)</span>
                        케이마켓 이용약관
                    </h3>
                    <c:if test="${type eq '1' }">
                    	<textarea class="terms" readonly>${dto.terms }</textarea>
                    </c:if>
                    <c:if test="${type eq '2' }">
                    	<textarea class="terms" readonly>${dto.tax }</textarea>
                    </c:if>
                    <label>
                        <input type="checkbox" name="agree1">
                        동의합니다
                    </label>
                    <h3>
                        <span class="essential">(필수)</span>
                        전자금융거래 이용약관
                    </h3>
                    <textarea class="financial" readonly>${dto.finance }</textarea>
                    <label>
                        <input type="checkbox" name="agree2">
                        동의합니다
                    </label>
                    <h3>
                        <span class="essential">(필수)</span>
                        개인정보 수집동의
                    </h3>
                    <textarea class="privacy" readonly>${dto.privacy }</textarea>
                    <label>
                        <input type="checkbox" name="agree3">
                        동의합니다
                    </label>
                </section>
                <c:if test="${type eq '1' }">
                <section>
                    <h3>
                        <span class="option">(선택)</span>
                        위치정보 이용약관
                    </h3>
                    <textarea class="location" readonly>${dto.location }</textarea>
                    <label>
                        <input type="checkbox" name="agree4">
                        동의합니다
                </section>
                </c:if>
                <div>
                    <input type="submit" class="agree" name="agree" value="동의하기">
                </div>
            </div>
        </main>
<%@ include file="./_footer.jsp" %>