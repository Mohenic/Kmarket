<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <section id="cs">
        
          <c:if test="${group eq 'faq'}"> 
          
            <div class="faq">
                <nav>
                    <div>
                        <p>홈<span>></span>자주묻는 질문</p>
                    </div>
                </nav>
                <section class="${index}">
                    <aside>
                        <h2>자주묻는 질문</h2>
                        <ul>
                            <li class="on"><a href="#">회원</a></li>
                            <li><a href="#">쿠폰/이벤트</a></li>
                            <li><a href="#">주문/결제</a></li>
                            <li><a href="#">배송</a></li>
                            <li><a href="#">취소/반품/교환</a></li>
                            <li><a href="#">여행/숙박/항공</a></li>
                            <li><a href="#">안전거래</a></li>
                        </ul>
                    </aside>
   
         </c:if>     
         
         <c:if test="${group eq 'notice'}"> 
            <div class="notice">
                <nav>
                    <div>
                        <p>홈<span>></span>공지사항</p>
                    </div>
                </nav>
                <section class="${index}">
                    <aside>
                        <h2>공지사항</h2>
                        <ul>
                            <li class="on"><a href="#">전체</a></li>
                            <li><a href="#">고객서비스</a></li>
                            <li><a href="#">안전거래</a></li>
                            <li><a href="#">위해상품</a></li>
                            <li><a href="#">이벤트당첨</a></li>
                        </ul>
                    </aside>     
         </c:if>     
         
         
         <c:if test="${group eq 'qna'}"> 
           <div class="qna">
                <nav>
                    <div>
                        <p>홈<span>></span>문의하기</p>
                    </div>
                </nav>
                <section class="${index}">
                    <aside>
                        <h2>문의하기</h2>
                        <ul>
                            <li class="on"><a href="#">회원</a></li>
                            <li><a href="#">쿠폰/이벤트</a></li>
                            <li><a href="#">주문/결제</a></li>
                            <li><a href="#">배송</a></li>
                            <li><a href="#">취소/반품/교환</a></li>
                            <li><a href="#">여행/숙박/항공</a></li>
                            <li><a href="#">안전거래</a></li>
                        </ul>
                    </aside>   
         </c:if>     
                      