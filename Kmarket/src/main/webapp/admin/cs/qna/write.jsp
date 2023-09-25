<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../_header.jsp"%>
<%@ include file="../../_aside.jsp" %>
        <section id="admin-cs-notice-view">
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
                            <td>${article.content}</td>
                        </tr>
                  </table>
                  <form action="/Kmarket/admin/cs/qna/write.do" method="POST">
                  <input type="text" name="writer" value="${sessUser.uid}">
                  <input type="text" name="group" value="qna">
                  <input type="text" name="cate" value="${cate}">
                  <input type="text" name="type" value="${type}">
                  <input type="text" name="no" value="${no}">
	                  <table id="adminAnswer">
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
	                  </table>
		                <a href="/Kmarket/admin/cs/qna/list.do" class="btnList">목록</a>
		                <input type="submit" class="btnWrite" value="답변등록">
		                <a href="/Kmarket/admin/cs/qna/delete.do" class="btnDelete">삭제</a>
                  </form>
                  
                </div>
            </article>
        </section>
    </div>
</section>
</main>
<%@ include file="../../_footer.jsp" %>