<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "../../_header.jsp" %>
<%@ include file = "../../_aside.jsp" %>
<section id="admin-cs-faq-list">
            <nav>
                <h3>자주묻는질문 목록</h3>
                <p>
                    HOME &gt; 고객센터 &gt; <strong>자주묻는질문</strong>
                </p>
            </nav>
            <section id="admin-faq-list">
                <div>
                    <select name="cate" id="cateSelect">
                        <option value="0">유형선택</option>
                        <option value="service" ${cate == 'service' ? 'selected' : ''}>고객서비스</option>
                        <option value="safe" ${cate == 'safe' ? 'selected' : ''}>안전거래</option>                                   
                        <option value="danger" ${cate == 'danger' ? 'selected' : ''}>위해상품</option>                                   
                        <option value="jackpot" ${cate == 'jackpot' ? 'selected' : ''}>이벤트당첨</option>
                    </select>
                    <select name="type" id="typeSelect">
                        <option value="0">유형선택</option>
                        <option value="service">고객서비스</option>
                        <option value="safe">안전거래</option>                                   
                        <option value="danger">위해상품</option>                                   
                        <option value="jackpot">이벤트당첨</option>
                    </select>
                </div>
                <form id="formFaqCheck" action="/Kmarket/admin/cs/faq/delete.do" method="get">
                <table>
                    <tbody>
                        <tr>
                            <th><input type="checkbox" name="all"></th>
                            <th>번호</th>
                            <th>1차유형</th>
                            <th>2차유형</th>
                            <th>제목</th>
                            <th>조회</th>
                            <th>날짜</th>
                            <th>관리</th>
                        </tr>
                        <c:forEach var="article" items="${article}">
                        <tr>
                            <td class="chk"><input type="checkbox" value="${article.no}" name="chk"></td>
                            <td class="no">${article.no}</td>
                            <td class="cateName">${article.cateName}</td>
                            <td class="type">${article.type}</td>
                            <td class="title"><a href="/Kmarket/admin/cs/faq/view.do?group=faq&cate=${cate}&no=${article.no}">${article.title}</a></td>
                            <td class="hit">${article.hit}</td>
                            <td class="rdate">${article.rdate}</td>
                            <td>
                                <a href="/Kmarket/admin/cs/faq/delete.do?chk=${article.no}">[삭제]</a>
                                <a href="/Kmarket/admin/cs/faq/modify.do?group=faq&cate=${cate}&no=${article.no}">[수정]</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </form>
                <a href="#" class="btnDelete">선택삭제</a>
                <a href="/Kmarket/admin/cs/faq/write.do?group=faq" class="btnWrite">작성하기</a>
                <div class="paging">
                <c:if test="${pageGroupStart > 1}">
                    <span class="prev">
                        <a href="/Kmarket/admin/cs/faq/list.do?group=faq&cate=${cate}&pg=${pageGroupStart - 1}">&lt;&nbsp;이전</a>
                    </span>
                </c:if>
                <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
                    <span class="num">
                        <a href="/Kmarket/admin/cs/faq/list.do?group=faq&cate=${cate}&pg=${i}" class="num ${currentPage==i ? 'current' : '' }">${i}</a>
                    </span>
                </c:forEach>
                <c:if test="${pageGroupEnd < lastPageNum}">
                    <span class="next">
                        <a href="/Kmarket/admin/cs/faq/list.do?group=faq&cate=${cate}&pg=${pageGroupEnd + 1}">다음&nbsp;&gt;</a>
                    </span>
                </c:if>
                </div>
            </section> <!--table end-->
        </section><!--admin-product-list end-->
    </main>
<%@include file ="../../_footer.jsp" %> 