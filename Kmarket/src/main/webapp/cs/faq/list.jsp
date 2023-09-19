<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<c:import url="./aside${group}.jsp" />

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
                                    <a href="./view.do?group=${group}&cate=${cate}&no=${article.no}">
                                    <span>Q.</span>${article.title}
                                    </a>
                                </li>
                                </c:if>
                          </c:forEach>
                                <li class="more">
                                    <a class="list_btn" href="#">더보기</a>
                                </li>
                            </ul>
                         </c:forEach>  
                        </div>
                       
                    </article>
                </section>
            </div>
        </section>
<%@ include file="../_footer.jsp" %>