<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<script>
$(document).ready(function() {
	$(".check").click(function(e){

		const writer = this.classList[2];
		const type = '${sessUser.type}'
        const uid = '${sessUser.uid}'
    	//debugger;
        
        if(type != 2 && uid != writer){
        	e.preventDefault();
        }
	})
  
   
});
</script>

        <section id="cs">
            <div class="main">
                <h1 class="title">
                    <strong>케이마켓</strong>이 도와드릴게요!
                </h1>
                <section class="notice">
                    <h1>
                        공지사항
                        <a href="/Kmarket/cs/board/notice/list.do?group=notice&cate=0">전체보기</a>
                    </h1>
                    <ul>
                    <c:forEach var="noticeLate" items="${noticeLates}">
                        <li>
                            <a href="/Kmarket/cs/board/view.do?group=notice&cate=${noticeLate.cate}&no=${noticeLate.no}" class="title">${noticeLate.title}</a>
                            <span class="date">${noticeLate.rdate}</span>
                        </li>
                    </c:forEach>
                    </ul>
                </section>
                <section class="faq">
                    <h1>
                        자주 묻는 질문			
                        <a href="/Kmarket/cs/board/faq/list.do?group=faq&cate=member">전체보기</a>
                    </h1>				
                    <ol>
                        <li>
                            <a href="/Kmarket/cs/board/faq/list.do?group=faq&cate=member">
                                <span>회원</span>
                            </a>
                        </li>
                        <li>
                            <a href="/Kmarket/cs/board/faq/list.do?group=faq&cate=event">
                                <span>쿠폰/이벤트</span>
                            </a>
                        </li>
                        <li>
                            <a href="/Kmarket/cs/board/faq/list.do?group=faq&cate=pay">
                                <span>주문/결제</span>
                            </a>
                        </li>
                        <li>
                            <a href="/Kmarket/cs/board/faq/list.do?group=faq&cate=delivery">
                                <span>배송</span>
                            </a>
                        </li>
                        <li>
                            <a href="/Kmarket/cs/board/faq/list.do?group=faq&cate=cancel">
                                <span>취소/반품/교환</span>
                            </a>
                        </li>
                        <li>
                            <a href="/Kmarket/cs/board/faq/list.do?group=faq&cate=travel">
                                <span>여행/숙박/항공</span>
                            </a>
                        </li>
                        <li>
                            <a href="/Kmarket/cs/board/faq/list.do?group=faq&cate=safe">
                                <span>안전거래</span>
                            </a>
                        </li>
                    </ol>
                </section>
                <section class="qna">
                    <h1>
                        문의하기			 
                        <a href="/Kmarket/cs/board/qna/list.do?group=qna&cate=member">전체보기</a>
                    </h1>
                    <ul>
                    <c:forEach var="qanLate" items="${qnaLates}">
                        <li>
                            <a href="/Kmarket/cs/board/view.do?group=qna&cate=${qanLate.cate}&no=${qanLate.no}" class="title check ${qanLate.writer}">[${qanLate.typeName}] ${qanLate.title} </a>
                            <p>
                                <span class="uid">   
                                	<c:if test="${article.writer ne null}">
								      <!-- 아이디의 앞 3자리까지 보여 주고 -->
								      ${fn:substring(article.writer,0,3) }
								    </c:if>
								      <!-- 4자리부터 id의 길이만큼 *를 찍어줌 -->
								    <c:forEach begin="4" end="${fn:length(article.writer)}" step="1">
								        *
								    </c:forEach></span>
                                <span class="date">${qanLate.rdate}</span>
                            </p>
                        </li>
                     </c:forEach>   
                    </ul>
                    <a href="/Kmarket/cs/board/qna/write.do?group=qna" class="ask">문의글 작성 ></a>
                </section>
                <section class="tel">
                    <h1>1:1 상담이 필요하신가요? </h1>
                    <article>
                        <div>
                            <h3>고객센터 이용안내</h3>
                            <p>
                                <span>일반회원/비회원</span>
                                <br>
                                <strong>1566-0001</strong>
                                <span>(평일 09:00 ~ 18:00)</span>
                            </p>
                            <p>
                                <span>스마일클럽 전용</span>
                                <br>
                                <strong>1566-0002</strong>
                                <span>(365일 09:00 ~ 18:00)</span>
                            </p>
                        </div>
                    </article>
                    <article>
                        <div>
                            <h3>판매상담 이용안내</h3>
                            <p>
                                <span>판매고객</span>
                                <br>
                                <strong>1566-5700</strong>
                                <span>(평일 09:00 ~ 18:00)</span>
                            </p>
                            <p>
                                <a href="#">판매자 가입 및 서류 접수 안내 ></a>
                            </p>
                        </div>
                    </article>
                </section>
            </div>
        </section>
<%@ include file="./_footer.jsp" %>