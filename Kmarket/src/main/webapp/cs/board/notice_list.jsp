<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<c:import url="./aside${group}.jsp" />
                    <article>
                        <nav>
                            <h1>전체</h1>
                            <h2>공지사항 전체 내용입니다.</h2>
                        </nav>
                        <table>
                            <tbody>
                                <tr>
                                    <td><a href="./view.do?group=${group}">[안내] 해외결제 사칭 문자 주의</a></td>
                                    <td>2022.11.21</td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="page">
                            <a href="#" class="prev">이전</a>
                            <a href="#" class="num on">1</a>
                            <a href="#" class="num">2</a>
                            <a href="#" class="num">3</a>
                            <a href="#" class="next">다음</a>
                        </div>
                    </article>
                </section>
            </div>
        </section>
<%@ include file="../_footer.jsp" %>