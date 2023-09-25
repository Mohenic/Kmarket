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
            <article>
                <div class="content">
                    <table>
                        <tr>
                            <td>유형</td>
                            <td>${article.cateName}</td>
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
                <a href="/Kmarket/admin/cs/notice/list.do" class="btnList">목록</a>
                <a href="/Kmarket/admin/cs/notice/modify.do?group=notice&cate=${article.cate}&no=${article.no}" class="btnModify">수정</a>
                <a href="/Kmarket/admin/cs/notice/delete.do" class="btnDelete">삭제</a>
            </article>
        </section>
    </div>
</section>
</main>
<%@ include file="../../_footer.jsp" %>