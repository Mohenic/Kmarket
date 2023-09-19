<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
 <section id="cs">
<c:import url="./aside${group}.jsp" />
    
                        <nav>
                            <h2 class="title">[${article.typeName}] ${article.title}</h2>
                        </nav>
                        <div class="content">
                            <p>
                             	${article.content}
                            </p>
                        </div>
                      
                        <nav>[답변]가입문의 내용</nav>
                        <div>
                        	<p>
                        		안녕안녕
                        	</p>
                        </div>
                        
                        <a href="./list.do?group=${group}&cate=${cate}" class="btnList">목록보기</a>
                    </article>
                </section>
            </div>
        </section>
<%@ include file="../_footer.jsp" %>