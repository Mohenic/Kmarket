<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../_header.jsp" %>
<c:import url="./aside.jsp" />

<script>

$(document).ready(function() {
	  var isOpen = false;

	  $(".list_btn").click(function() {
	    isOpen = !isOpen;
	    if (isOpen) {
	      $("#faq_list li:nth-child(n+4)").show();
	      $(this).text("닫기");
	    } else {
	      $("#faq_list li:nth-child(n+4)").hide();
	      $(this).text("더보기");
	    }
	  });
	});

</script>

                        <div>
                         <c:forEach var="list" items="${lists}">
                            <h3>${list.typeName}</h3>
                            <ul id="faq_list">
                            <c:forEach var="article" items="${articles}">
                                <c:if test="${list.type eq article.type}">
                                <li>
                                    <a href="/Kmarket/cs/board/view.do?group=${group}&cate=${cate}&no=${article.no}">
                                    <span>Q.</span>${article.title}
                                    </a>
                                </li>
                                </c:if>
                          </c:forEach>
                          <c:if test="${fn:length(articles)eq 0}">
                                <li class="more">
                                    <a class="list_btn" href="#">게시글이 없습니다.</a>
                                </li>
                          </c:if>
                           <c:if test="${fn:length(articles)ne 0}">
                                <li class="more">
                                    <a class="list_btn" href="#">더보기</a>
                                </li>
                          </c:if>        
                            </ul>
                         </c:forEach>  
                        </div>
                       
                    </article>
                </section>
            </div>
        </section>
<%@ include file="../_footer.jsp" %>