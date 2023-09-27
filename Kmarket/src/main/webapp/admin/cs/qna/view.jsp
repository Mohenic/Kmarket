<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../_header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 상단에 작성해줍니다. -->
<%
	pageContext.setAttribute("LF", "\n");
	pageContext.setAttribute("BR", "<br/>");
%>



 <section id="cs">
<%@ include file="../../_aside.jsp" %>
        <section id="admin-cs-qna-view">
            <nav>
                <h3>문의사항 보기</h3>
                <p>
                    HOME &gt; 고객센터 &gt; <strong>문의사항</strong>
                </p>
            </nav>
            <article>
                <div class="content">
                    <table>
                        <tr>
                            <td>유형</td>
                            <td>${article.cateName} - ${article.typeName }</td>
                        </tr>
                        <tr>
                            <td>제목</td>
                            <td>${article.title}</td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td><c:out value="${fn:replace(article.content, LF, BR)}" escapeXml="false"/></td>
                        </tr>
                        <tr>
                        	<td>답변제목</td>
                        	<td>${answer.title}</td>
                        </tr>
                        <tr>
                        	<td>답변내용</td>
                        	<td><c:out value="${fn:replace(answer.content, LF, BR)}" escapeXml="false"/></td>
                        </tr>
                  </table>
                </div>
                <a href="/Kmarket/admin/cs/qna/list.do" class="btnList">목록</a>
                <a href="/Kmarket/admin/cs/qna/write.do?group=qna&cate=${article.cate}&type=${article.type}&no=${article.no}" class="btnModify">답변등록</a>
                <a href="/Kmarket/admin/cs/qna/delete.do?group=qna&chk=${article.no}" class="btndelete">삭제</a>
            </article>
        </section>
    </div>
</section>
</main>
<%@ include file="../../_footer.jsp" %>