<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../_header.jsp"%>
<%@ include file="../../_aside.jsp" %>
<script src="/Kmarket/admin/cs/js/faqWriteModify.js"></script>
            <section id="admin-cs-notice-write">
                <nav>
                    <h3>자주묻는질문 수정<h3></h3>
                    <p>
                        HOME &gt; 고객센터 &gt; <strong>자주묻는 질문</strong>
                    </p>
                </nav>
                <nav></nav>
                <section class="write">
                    <article>
                    <form action="/Kmarket/admin/cs/faq/modify.do" name="modifyForm" method="post">
                    <input type="hidden" name="no" value="${article.no}">
                    <input type="hidden" name="group" value="${article.group}">
                        <table>
                            <tr>
                                <td>유형</td>
                                <td>
			                    <select name="cate" id="cateModify">
			                        <option value="0">유형선택</option>
			                        <option value="member" ${article.cate == 'member' ? 'selected' : ''}>회원</option>
			                        <option value="event" ${article.cate == 'event' ? 'selected' : ''}>쿠폰/이벤트</option>                                   
			                        <option value="pay" ${article.cate == 'pay' ? 'selected' : ''}>주문/결제</option>                                   
			                        <option value="delivery" ${article.cate == 'delivery' ? 'selected' : ''}>배송</option>
			                        <option value="cancel" ${article.cate == 'cancel' ? 'selected' : ''}>취소/반품/교환</option>
			                        <option value="travel" ${article.cate == 'travel' ? 'selected' : ''}>여행/숙박/항공</option>
			                        <option value="safe" ${article.cate == 'safe' ? 'selected' : ''}>안전거래</option>
			                    </select>
                                <select name="type" id="typeModify">
			                        <option value="0">유형선택</option>
			                        <option value="service">고객서비스</option>
			                        <option value="safe">안전거래</option>                                   
			                        <option value="danger">위해상품</option>                                   
			                        <option value="jackpot">이벤트당첨</option>
			                    </select>
			                    </td>
                            </tr>
                            <tr>
                                <td>제목</td>                  
                                <td>
                                <input type="text" name="title" value="${article.title}" placeholder="제목을 입력합니다."/>
                                </td>
                            </tr>                
                            <tr>
                                <td>내용</td>                  
                                <td>
                                <textarea name="content" placeholder="내용을 입력합니다.">${article.content}</textarea>
                                </td>
                            </tr>
                        </table>
                        <div>
                            <a href="/Kmarket/admin/cs/faq/list.do" class="btnList">취소하기</a>
                            <input type="submit" class="btnSubmit" value="수정하기"/>
                        </div>
                    </form>
                    </article>
                </section>
            </section>
          </main>
<%@ include file="../../_footer.jsp" %>