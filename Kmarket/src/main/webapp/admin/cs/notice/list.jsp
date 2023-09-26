<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "../../_header.jsp" %>
<%@ include file = "../../_aside.jsp" %>
<script>
window.onload = function(){
	document.getElementById('cateSelect').addEventListener('change', function() {
	    var selectedValue = this.value;
	    // 페이지 리로드
	    window.location.href = "/Kmarket/admin/cs/notice/list.do?group=notice&cate=" + selectedValue;
	});
}
</script>
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
                        <option value="0">유형선택</option>
                        <option value="service" ${cate == 'service' ? 'selected' : ''}>고객서비스</option>
                        <option value="safe" ${cate == 'safe' ? 'selected' : ''}>안전거래</option>                                   
                        <option value="danger" ${cate == 'danger' ? 'selected' : ''}>위해상품</option>                                   
                        <option value="jackpot" ${cate == 'jackpot' ? 'selected' : ''}>이벤트당첨</option>
                    </select>
                </div>
                <form id="formChk" action="/Kmarket/admin/cs/notice/delete.do" method="get">
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
                            <td class="chk"><input type="checkbox" value="${article.no}" name="chk"></td>
                            <td class="no">${article.no}</td>
                            <td class="cateName">${article.cateName}</td>
                            <td class="title"><a href="/Kmarket/admin/cs/notice/view.do?group=notice&cate=${cate}&no=${article.no}">${article.title}</a></td>
                            <td class="hit">${article.hit}</td>
                            <td class="rdate">${article.rdate}</td>
                            <td>
                                <a href="/Kmarket/admin/cs/notice/delete.do?chk=${article.no}">[삭제]</a>
                                <a href="/Kmarket/admin/cs/notice/modify.do?group=notice&cate=${cate}&no=${article.no}">[수정]</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </form>
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
                        <a href="/Kmarket/admin/cs/notice/list.do?group=notice&cate=${cate}&pg=${i}" class="num ${currentPage==i ? 'current' : 'on' }">${i}</a>
                    </span>
                </c:forEach>
                <c:if test="${pageGroupEnd < lastPageNum}">
                    <span class="next">
                        <a href="/Kmarket/admin/cs/notice/list.do?group=notice&cate=${cate}&pg=${pageGroupEnd + 1}">다음&nbsp;&gt;</a>
                    </span>
                </c:if>
                </div>
            </section>
        </section>
    </main>
<%@include file ="../../_footer.jsp" %> 