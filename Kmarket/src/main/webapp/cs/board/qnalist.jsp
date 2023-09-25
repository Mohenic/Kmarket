<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../_header.jsp" %>
<c:import url="./aside.jsp" />
<%-- <jsp:include page="../board/_aside${group}.jsp"/>  --%>
<script>
        $(document).ready(function() {
            // "status" 클래스를 가진 모든 셀을 찾아서 처리
            $('.status').each(function() {
                // 현재 셀의 텍스트 가져오기
                var text = $(this).text();

                // 텍스트에 따라 스타일 변경
                if (text === '검토중') {
                    $(this).css("color","black");
                } else if (text === '답변완료') {
                    $(this).css("color","blue");
                }
            });
        });
    </script>
    
<script>
$(document).ready(function() {
	$(".check").click(function(e){
		const writer = this.classList[1];
		const type = '${sessUser.type}'
        const uid = '${sessUser.uid}'
        
        if(type != 2 && uid != writer){
        	e.preventDefault();
        }
	})
  
   
});
</script>
    
    
              
                        <table>
                            <tbody>
                            <c:forEach var="article" items="${articles}">
                            <c:if test="${article.parent eq 0}"> <%--답변은 보이지 않게 하기 --%>
                                <tr>									
                                 <c:if test="${fn:length(articles)ne 0}">	 
                                    <td><a class="check ${article.writer}" href="/Kmarket/cs/board/view.do?group=${group}&cate=${article.cate}&no=${article.no}" >[${article.typeName}] ${article.title}</a></td>                                    
                                     <c:if test="${article.comment eq 1}">
                                     <td class="status">답변완료</td>
                                     </c:if>
                                     <c:if test="${article.comment eq 0}">
                                     <td class="status">검토중</td>
                                     </c:if>
                                     <td>
	                                     <c:if test="${article.writer ne null}">
									      <!-- 아이디의 앞 3자리까지 보여 주고 -->
									      ${fn:substring(article.writer,0,3) }
									    </c:if>
									      <!-- 4자리부터 id의 길이만큼 *를 찍어줌 -->
									      <c:forEach begin="4" end="${fn:length(article.writer)}" step="1">
									        *
									      </c:forEach>
									</td>
                                    <td>${article.rdate}</td>
                                 </c:if>  
								 <c:if test="${fn:length(articles)eq 0}">
								 	<td>게시글이 없습니다</td>
								 </c:if>

                                </tr>
                                </c:if>
                            </c:forEach>
                            </tbody>
                        </table>
                        
                        <!-- 페이지 네비게이션 -->
				        <div class="page">
				        	<c:if test="${pageGroupStart > 1}">
				            	<a href="/Kmarket/cs/board/qna/list.do?group=${group}&cate=${cate}&pg=${pageGroupStart - 1}" class="prev">이전</a>
				            </c:if>
				            <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
				            	<a href="/Kmarket/cs/board/qna/list.do?group=${group}&cate=${cate}&pg=${i}" class="${currentPage == i ? 'on':'off'}">${i}</a>
				            </c:forEach>
				            <c:if test="${pageGroupEnd < lastPageNum}">
				            	<a href="/Kmarket/cs/board/qna/list.do?group=${group}&cate=${cate}&pg=${pageGroupEnd + 1}" class="next">다음</a>
				            </c:if>
				        </div>
                        <a href="/Kmarket/cs/board/qna/write.do?group=qna&cate=${cate}" class="btnWrite">문의하기</a>
                        		
                    </article>
                </section>
            </div>
        </section>
<%@ include file="../_footer.jsp" %>