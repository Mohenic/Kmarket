<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../_header.jsp"%>
<%@ include file="../../_aside.jsp" %>
            <section id="admin-cs-notice-write">
                <nav>
                    <h3>공지사항 작성<h3></h3>
                    <p>
                        HOME &gt; 고객센터 &gt; <strong>공지사항</strong>
                    </p>
                </nav>
                <nav></nav>
                <section class="write">
                    <article>
                    <form action="/Kmarket/admin/cs/notice/modify.do" name="modifyForm" method="post">
                    <input type="hidden" name="no" value="${article.no}">
                        <table>
                            <tr>
                                <td>유형</td>
                                <td>
                                <select name="cate">
                                    <option value="">유형선택</option>
                                    <option value="service" ${article.cate == 'service' ? 'selected' : ''}>고객서비스</option>
                                    <option value="safe" ${article.cate == 'safe' ? 'selected' : ''}>안전거래</option>
                                    <option value="danger" ${article.cate == 'danger' ? 'selected' : ''}>위해상품</option>
                                    <option value="jackpot" ${article.cate == 'jackpot' ? 'selected' : ''}>이벤트당첨</option>
                                </select>
                                </td>
                            </tr>
                            <tr>
                                <td>제목</td>                  
                                <td>
                                <input type="text" name="title" value="${article.title}" placeholder="제목을 입력합니다."/>
                                </td>
                            </tr>                
                            <tr>
                                <td>내용</td>                  
                                <td>
                                <textarea name="content" placeholder="내용을 입력합니다.">${article.content}</textarea>
                                </td>
                            </tr>
                        </table>
                        <div>
                            <a href="/Kmarket/admin/cs/notice/list.do" class="btnList">취소하기</a>
                            <input type="submit" class="btnSubmit" value="등록하기"/>
                        </div>
                    </form>
                    </article>
                </section>
            </section>
          </main>
<%@ include file="../../_footer.jsp" %>