<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "../_header.jsp" %> 
<%@ include file = "../_aside.jsp" %>

        <section id="admin-product-list">
            <nav>
                <h3>상품목록</h3>
                <p>
                    HOME &gt; 상품관리 &gt; <strong>상품목록</strong>
                </p>
            </nav>
            <section>
                <div>
                    <select name="search">
                        <option value="proName">상품명</option>
                        <option value="prodNo">상품코드</option>
                        <option value="company">제조사</option>
                        <option value="seller">판매자</option>                                    
                    </select>
                    <input type="text" name="search">
                </div>
	            <form id="formCheck" action="/Kmarket/admin/product/delete.do" method="get">
                <table>
                    <tbody>
                        <tr>
                            <th><input type="checkbox" name="all"></th>
                            <th>이미지</th>
                            <th>상품코드</th>
                            <th>상품명</th>
                            <th>판매가격</th>
                            <th>할인율</th>
                            <th>포인트</th>
                            <th>재고</th>
                            <th>판매자</th>
                            <th>조회</th>
                            <th>관리</th>
                        </tr>
                        
                        <c:forEach var="product" items="${requestScope.products}">
                        <tr>
                            <td class="chk"><input type="checkbox" name ="chk" value="${product.prodNo}"></td>
                            <td><img src="/Kmarket/thumb/${product.prodCate1}/${product.prodCate2}/${product.thumb1}" class="thumb"></td>
                            <td class="prodNo">${product.prodNo}</td>
                            <td class="prodName">${product.prodName}</td>
                            <td class="price">${product.price}</td>
                            <td class="discount">${product.discount}</td>
                            <td class="point">${product.point}</td>
                            <td class="stock">${product.stock}</td>
                            <td class="seller">${product.seller}</td>
                            <td class="hit">${product.hit}</td>
                            <td>
                                <a href="/Kmarket/admin/product/delete.do?chk=${product.prodNo}">[삭제]</a>
                                <a href="#">[수정]</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </form>
                <input type="button" class="productDelete" value="선택삭제">
                <div class="paging">
                <c:if test="${pageGroupStart > 1}">
                    <span class="prev">
                        <a href="/Kmarket/admin/product/list.do?pg=${pageGroupStart - 1}">&lt;&nbsp;이전</a>
                    </span>
                </c:if>
                <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
                    <span class="num">
                        <a href="/Kmarket/admin/product/list.do?pg=${i}" class="num ${currentPage==i ? 'current' : '' }">${i}</a>
                    </span>
                </c:forEach>
                <c:if test="${pageGroupEnd < lastPageNum}">
                    <span class="next">
                        <a href="/Kmarket/admin/product/list.do?pg=${pageGrouEnd + 1}">다음&nbsp;&gt;</a>
                    </span>
                </c:if>
                    </div>
            </section> <!--table end-->
            <p class="ico info">
                <strong>Tip!</strong>
                전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
            </p>
        </section><!--admin-product-list end-->
    </main>
<%@include file ="../_footer.jsp" %> 