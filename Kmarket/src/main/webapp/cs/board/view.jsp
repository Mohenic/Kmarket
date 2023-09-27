<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 상단에 작성해줍니다. -->
<%
	pageContext.setAttribute("LF", "\n");
	pageContext.setAttribute("BR", "<br/>");
%>
 <section id="cs">
<c:import url="./aside.jsp" />
						
                        <nav>
                        <c:if test="${article.group ne 'notice'}">
                            <h2 class="title">[${article.typeName}] ${article.title}</h2>
                        </c:if>
                          <c:if test="${article.group eq 'notice'}">
                            <h2 class="title"> ${article.title}</h2>
                        </c:if>     
                        	 <p>
                                <span>  <td>
	                                     <c:if test="${article.writer ne null}">
									      <!-- 아이디의 앞 3자리까지 보여 주고 -->
									      ${fn:substring(article.writer,0,3) }
									    </c:if>
									      <!-- 4자리부터 id의 길이만큼 *를 찍어줌 -->
									      <c:forEach begin="4" end="${fn:length(article.writer)}" step="1">
									        *
									      </c:forEach>
										</td>
								</span>
                                <span>${article.rdate}</span>
                            </p>
                        </nav>
                        <div class="content">
                            <p>
                            	<c:out value="${fn:replace(article.content, LF, BR)}" escapeXml="false"/>
                            </p>
                        </div>

                      <c:if test="${article.no == answer.parent}">
                         <div id="qna_answer">
                            <nav>☛ [답변] ${answer.title}</nav>
                            <div>
                                <p>
                                    ${answer.content}
                                </p>
                            </div>
                        </div>
                      
                       </c:if>
                        <a href="/Kmarket/cs/board/${group}/list.do?group=${group}&cate=${cate}" class="btnList">목록보기</a>
                        <c:if test="${article.writer eq sessUser.uid}">
                        <c:if test="${group eq 'qna'}">
                        <a href="/Kmarket/cs/board/${group}Modify.do?group=${group}&cate=${cate}&type=${article.type}&no=${article.no}" class="btnList">수정하기</a>
                        <a href="/Kmarket/cs/board/delete.do?group=${group}&cate=${cate}&no=${article.no}" class="btnList">삭제하기</a>
                    	</c:if>
                    	</c:if>
                    </article>
                </section>
            </div>
        </section>
<%@ include file="../_footer.jsp" %>