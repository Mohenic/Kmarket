<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "../../_header.jsp" %>
<%@ include file = "../../_aside.jsp" %>
<section id="admin-cs-notice-list">
            <nav>
                <h3>공지사항 목록</h3>
                <p>
                    HOME &gt; 고객센터 &gt; <strong>공지사항</strong>
                </p>
            </nav>
            <section id="admin-notice-list">
                <div>
                    <select name="cate" id="cateSelect">
                        <option value="">유형선택</option>
                        <option value="service">고객서비스</option>
                        <option value="safe">안전거래</option>                                   
                        <option value="danger">위해상품</option>                                   
                        <option value="jackpot">이벤트당첨</option>
                    </select>
                </div>
                <table>
                    <tbody>
                        <tr>
                            <th><input type="checkbox" name="all"></th>
                            <th>번호</th>
                            <th>유형</th>
                            <th>제목</th>
                            <th>조회</th>
                            <th>날짜</th>
                            <th>관리</th>
                        </tr>
                        <c:forEach var="article" items="${article}">
                        <tr>
                            <td class="chk" value ="${article.no}"><input type="checkbox"></td>
                            <td class="no">${article.no}</td>
                            <td class="cateName">${article.cateName}</td>
                            <td class="title"><a href="/Kmarket/admin/cs/notice/view.do?group=notice&cate=${cate}&no=${article.no}">${article.title}</a></td>
                            <td class="hit">${article.hit}</td>
                            <td class="rdate">${article.rdate}</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="#">[수정]</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a href="#" class="btnDelete">선택삭제</a>
                <a href="/Kmarket/admin/cs/notice/write.do?group=notice" class="btnWrite">작성하기</a>
                <div class="paging">
                <c:if test="${pageGroupStart > 1}">
                    <span class="prev">
                        <a href="/Kmarket/admin/cs/notice/list.do?group=notice&cate=${cate}&pg=${pageGroupStart - 1}">&lt;&nbsp;이전</a>
                    </span>
                </c:if>
                <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
                    <span class="num">
                        <a href="/Kmarket/admin/cs/notice/list.do?group=notice&cate=${cate}&pg=${i}" class="num ${currentPage==i ? 'current' : '' }">${i}</a>
                    </span>
                </c:forEach>
                <c:if test="${pageGroupEnd < lastPageNum}">
                    <span class="next">
                        <a href="/Kmarket/admin/cs/notice/list.do?group=notice&cate=${cate}&pg=${pageGrouEnd + 1}">다음&nbsp;&gt;</a>
                    </span>
                </c:if>
                </div>
            </section> <!--table end-->
        </section><!--admin-product-list end-->
    </main>
<%@include file ="../../_footer.jsp" %> 