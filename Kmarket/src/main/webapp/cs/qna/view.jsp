<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
 <section id="cs">
<jsp:include page="./_aside${group}.jsp"/>
                    <article>
                        <nav>
                            <h2 class="title">[${article.type}] ${article.title}</h2>
                            <p>
                                <span>${sessUser.uid}</span>
                                <span>${article.rdate}</span>
                            </p>
                        </nav>
                        <div class="content">
                            <p>
                             	${article.content}
                            </p>
                        </div>
                        <a href="./list.do?group=${group}&cate=${cate}" class="btnList">목록보기</a>
                    </article>
                </section>
            </div>
        </section>
<%@ include file="../_footer.jsp" %>