<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../_header.jsp"%>
<%@ include file="../../_aside.jsp" %>
        <section id="admin-cs-notice-view">
            <nav>
                <h3>공지사항 보기</h3>
                <p>
                    HOME &gt; 고객센터 &gt; <strong>공지사항</strong>
                </p>
            </nav>
            <nav></nav>
            <article>
                <div class="content">
                    <table>
                        <tr>
                            <td>유형</td>
                            <td>${article.cate}</td>
                        </tr>
                        <tr>
                            <td>제목</td>
                            <td>${article.title}</td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td>${article.content}</td>
                        </tr>
                        <tr>
                        	<td>답변</td>
                        	<td><textarea class="answerContent" name="answer"></textarea></td>
                        	
                        </tr>
                  </table>
                </div>
                <a href="/Kmarket/admin/cs/qna/list.do" class="btnList">목록</a>
                <a href="/Kmarket/admin/cs/qna/modify.do?group=qna&cate=${article.cate}&no=${article.no}" class="btnModify">답변등록</a>
                <a href="/Kmarket/admin/cs/qna/delete.do" class="btnDelete">삭제</a>
            </article>
        </section>
    </div>
</section>
</main>
<%@ include file="../../_footer.jsp" %>