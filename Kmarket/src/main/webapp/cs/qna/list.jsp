<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../_header.jsp" %>
<c:import url="./aside${group}.jsp" />
<%-- <jsp:include page="../board/_aside${group}.jsp"/>  --%>

              
                        <table>
                            <tbody>
                            <c:forEach var="article" items="${articles}">
                                <tr>
                                    <td><a href="/Kmarket/cs/qna/view.do?group=${group}&cate=${article.cate}&no=${article.no}">[${article.typeName}] ${article.title}</a></td>                                    
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
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        
                        <!-- 페이지 네비게이션 -->
				        <div class="page">
				        	<c:if test="${pageGroupStart > 1}">
				            	<a href="/Kmarket/cs/qna/list.do?group=${group}&cate=${cate}&pg=${pageGroupStart - 1}" class="prev">이전</a>
				            </c:if>
				            <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
				            	<a href="/Kmarket/cs/qna/list.do?group=${group}&cate=${cate}&pg=${i}" class="${currentPage == i ? 'on':'off'}">${i}</a>
				            </c:forEach>
				            <c:if test="${pageGroupEnd < lastPageNum}">
				            	<a href="/Kmarket/cs/qna/list.do?group=${group}&cate=${cate}&pg=${pageGroupEnd + 1}" class="next">다음</a>
				            </c:if>
				        </div>
                        <a href="/Kmarket/cs/qna/write.do?group=qna&cate=${cate}" class="btnWrite">문의하기</a>
                        		
                    </article>
                </section>
            </div>
        </section>
<%@ include file="../_footer.jsp" %>