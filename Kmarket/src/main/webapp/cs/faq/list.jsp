<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<c:import url="./aside${group}.jsp" />

                        <div>
                            <h3>가입</h3>
                            <ul>
                            <c:forEach var="article" items="${articles}">
                                <li>
                                    <a href="./view.do?group=${group}&cate=${cate}">
                                    <span>Q.</span>${article.title}
                                    </a>
                                </li>
                            </c:forEach>  
                                <li class="more">
                                    <a href="#">더보기</a>
                                </li>
                            </ul>
                        </div>
                        <div>
                            <h3>탈퇴</h3>
                            <ul>
                                <li>
                                    <a href="./view.html">
                                    <span>Q.</span>회원탈퇴 후 재가입이 가능한가요?
                                    </a>
                                </li>
                                <li>
                                    <a href="./view.html">
                                    <span>Q.</span>회원탈퇴 후 재가입이 가능한가요?
                                    </a>
                                </li>
                                <li>
                                    <a href="./view.html">
                                    <span>Q.</span>회원탈퇴 후 재가입이 가능한가요?
                                    </a>
                                </li>
                                <li>
                                    <a href="./view.html">
                                    <span>Q.</span>회원탈퇴 후 재가입이 가능한가요?
                                    </a>
                                </li>
                                <li>
                                    <a href="./view.html">
                                    <span>Q.</span>회원탈퇴 후 재가입이 가능한가요?
                                    </a>
                                </li>
                                <li class="more">
                                    <a href="#">더보기</a>
                                </li>
                            </ul>
                        </div>
                        <div>
                            <h3>회원정보</h3>
                            <ul>
                                <li>
                                    <a href="./view.html">
                                    <span>Q.</span>회원정보를 수정하고 싶어요.
                                    </a>
                                </li>
                                <li>
                                    <a href="./view.html">
                                    <span>Q.</span>회원정보를 수정하고 싶어요.
                                    </a>
                                </li>
                                <li>
                                    <a href="./view.html">
                                    <span>Q.</span>회원정보를 수정하고 싶어요.
                                    </a>
                                </li>
                                <li>
                                    <a href="./view.html">
                                    <span>Q.</span>회원정보를 수정하고 싶어요.
                                    </a>
                                </li>
                                <li>
                                    <a href="./view.html">
                                    <span>Q.</span>회원정보를 수정하고 싶어요.
                                    </a>
                                </li>
                                <li class="more">
                                    <a href="#">더보기</a>
                                </li>
                            </ul>
                        </div>
                        <div>
                            <h3>로그인</h3>
                            <ul>
                                <li>
                                    <a href="./view.html">
                                    <span>Q.</span>로그인에 문제가 있어요.
                                    </a>
                                </li>
                                <li>
                                    <a href="./view.html">
                                    <span>Q.</span>로그인에 문제가 있어요.
                                    </a>
                                </li>
                                <li>
                                    <a href="./view.html">
                                    <span>Q.</span>로그인에 문제가 있어요.
                                    </a>
                                </li>
                                <li>
                                    <a href="./view.html">
                                    <span>Q.</span>로그인에 문제가 있어요.
                                    </a>
                                </li>
                                <li>
                                    <a href="./view.html">
                                    <span>Q.</span>로그인에 문제가 있어요.
                                    </a>
                                </li>
                                <li class="more">
                                    <a href="#">더보기</a>
                                </li>
                            </ul>
                        </div>
                    </article>
                </section>
            </div>
        </section>
<%@ include file="../_footer.jsp" %>