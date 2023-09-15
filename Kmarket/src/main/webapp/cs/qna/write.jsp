<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
 <jsp:include page="./_aside${group}.jsp"/>
                    <article>
                        <form action="/Kmarket/cs/qna/write.do" method="post">
                        <input type="text" name="writer" value="${sessUser.uid }">
                          
				        <input type="text" name="group" value="${group}">
				        <input type="text" name="cate" value="${cate}">
                            <table>
                                <tbody>
                                    <tr>
                                        <td>문의유형</td>
                                        <td>
                                         <select name="cate">
                                                <option>선택</option>
                                                <option selected>회원</option>
                                                <option>쿠폰/이벤트</option>
                                                <option>주문/결제</option>
                                                <option>배송</option>
                                            </select>
                                            
                                            <select name="type">
                                                <option>선택</option>
                                                <option selected>가입</option>
                                                <option>탈퇴</option>
                                                <option>회원정보</option>
                                                <option>로그인</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>문의제목</td>
                                        <td><input type="text" name="title" placeholder="제목을 입력하세요."></td>
                                    </tr>
                                    <tr>
                                        <td>문의내용</td>
                                        <td>
                                            <textarea type="text" name="content" placeholder="내용을 입력하세요."></textarea>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="qna_button">
                                <a href="./list.do" class="btnList">취소하기</a>
                                <input type="submit" class="btnSubmit" value="등록하기">
                            </div>
                        </form>
                    </article>
                </section>
            </div>
        </section>
<%@ include file="../_footer.jsp" %>