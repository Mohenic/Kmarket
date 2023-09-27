<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../_header.jsp"%>
<%@ include file="../../_aside.jsp" %>
        <section id="admin-cs-faq-view">
            <nav>
                <h3>자주묻는질문 보기</h3>
                <p>
                    HOME &gt; 고객센터 &gt; <strong>자주묻는질문</strong>
                </p>
            </nav>
            <nav></nav>
            <article>
                <div class="content">
                    <table>
                        <tr>
                            <td>유형</td>
                            <td>${article.cateName} - ${article.typeName}</td>
                        </tr>
                        <tr>
                            <td>제목</td>
                            <td>${article.title}</td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td>${article.content}</td>
                        </tr>
                  </table>
                </div>
                <a href="/Kmarket/admin/cs/faq/list.do" class="btnList">목록</a>
                <a href="/Kmarket/admin/cs/faq/modify.do?group=faq&cate=${article.cate}&type=${article.type}&no=${article.no}" class="btnModify">수정</a>
                <a href="/Kmarket/admin/cs/faq/delete.do?chk=${article.no}" class="btndelete">삭제</a>
            </article>
        </section>
    </div>
</section>
</main>
<%@ include file="../../_footer.jsp" %>