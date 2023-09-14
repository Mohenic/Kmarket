<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../_header.jsp" %>
<jsp:include page="./_aside${group}.jsp"/>
                    <article>
                        <nav>
                            <h1>회원</h1>
                            <h2>회원관련 문의 내용입니다.</h2>
                        </nav>
                        <table>
                            <tbody>
                            <c:forEach var="article" items="${articles}">
                                <tr>
                                    <td><a href="./view.do?group=${group}">${article.title}</a></td>
                                    <td>${article.writer}</td>
                                    <td>${article.rdate}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="page">
                            <a href="#" class="prev">이전</a>
                            <a href="#" class="num on">1</a>
                            <a href="#" class="num">2</a>
                            <a href="#" class="num">3</a>
                            <a href="#" class="next">다음</a>
                        </div>
                        <a href="/Kmarket/cs/qna/write.do?group=Qna&cate=${cate}" class="btnWrite">문의하기</a>
                    </article>
                </section>
            </div>
        </section>
<%@ include file="../_footer.jsp" %>