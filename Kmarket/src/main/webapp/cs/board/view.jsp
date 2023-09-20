<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
 <section id="cs">
<c:import url="./aside.jsp" />
    
                        <nav>
                            <h2 class="title">[${article.typeName}] ${article.title}</h2>
                        	 <p>
                                <span>${article.writer}</span>
                                <span>${article.rdate}</span>
                            </p>
                        </nav>
                        <div class="content">
                            <p>
                             	${article.content}
                            </p>
                        </div>
                      <c:if test="${article.no == answer.parent}">
                         <div id="qna_answer">
                            <nav>☛ [답변] ${answer.title}</nav>
                            <div>
                                <p>
                                    ${answer.content}<br>
                                </p>
                            </div>
                        </div>
                       </c:if>
                        <a href="./list.do?group=${group}&cate=${cate}" class="btnList">목록보기</a>
                    </article>
                </section>
            </div>
        </section>
<%@ include file="../_footer.jsp" %>