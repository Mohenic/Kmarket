<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="/Kmarket/admin/product/js/cateValue.js"></script>
<%@ include file = "../_header.jsp" %>
<%@ include file = "../_aside.jsp" %>
<!-- 
	작업자 : 손영우
	작업시작일 : 2023/09/13
	작업종료일 : 2023/09/14
 -->
            <section id="admin-product-register">
                <nav>
                    <h3>상품등록</h3>
                    <p>
                        HOME &gt; 상품관리 &gt; <strong>상품등록</strong>
                    </p>
                </nav>
                <!-- 상품등록 컨텐츠 시작 -->
                <article>
                        <!-- 상품분류 -->
		                <form action="/Kmarket/admin/product/register.do" name="cateForm"method="post" enctype="multipart/form-data">
		                <input type="text" name="seller" value="${sessUser.uid}">
                        <section>
                            <h4>상품분류</h4>
                            <p>
                                기본분류는 반드시 선택하셔야 합니다. 하나의 상품에 1개의 분류를 지정 합니다.
                            </p>
                            <table>
                                <tbody>
                                
                                    <tr>
                                        <td>1차 분류</td>
                                        <td>
                                            <select name="prodCate1">
                                                <option>1차 분류 선택</option>
                                                <option value="10">브랜드패션</option>
                                                <option value="11">패션의류/잡화/뷰티</option>
                                                <option value="12">유아동</option>
                                                <option value="13">식품/생필품</option>                                              
                                                <option value="14">홈데코/취미/반려</option>                                             
                                                <option value="15">컴퓨터/디지털/가전</option>                                              
                                                <option value="16">스포츠/건강/렌탈</option>                                              
                                                <option value="17">자동차/공구</option>                                              
                                                <option value="18">여행/도서/티켓/쿠폰</option>                                              
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>2차 분류</td>
                                        <td>
                                            <select name="prodCate2">
                                                <option>2차 분류 선택</option>
                                                <option value="10">남성의류</option>
                                                <option value="11">여성의류</option>
                                                <option value="12">잡화</option>
                                                <option value="13">뷰티</option>                                                
                                            </select>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </section>

                        <!-- 기본정보 -->
                        <section>
                            <h4>기본정보</h4>
                            <p>
                                기본정보는 반드시 입력해야 합니다.
                            </p>
                            <table>
                                <tbody>
                                    <tr>
                                        <td>상품명</td>
                                        <td><input type="text" name="prodName"></td>
                                    </tr>
                                    <tr>
                                        <td>기본설명</td>
                                        <td>
                                        <span>상품명 하단에 상품에 대한 추가적인 설명이 필요한 경우에 입력</span>
                                        <input type="text" name="descript">
                                    </td>
                                    </tr>
                                    <tr>
                                        <td>제조사</td>
                                        <td><input type="text" name="company"></td>
                                    </tr>
                                    <tr>
                                        <td>판매가격</td>
                                        <td><input type="text" name="price">원</td>
                                    </tr>                                    
                                    <tr>
                                        <td>할인율</td>
                                        <td>
                                            <span>0을 입력하면 할인율 없음</span>
                                            <input type="text" name="discount">%
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>포인트</td>
                                        <td>
                                            <span>0을 입력하면 포인트 없음</span>
                                            <input type="text" name="point">점
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>재고수량</td>
                                        <td><input type="text" name="stock">개</td>
                                    </tr>
                                    <tr>
                                        <td>배송비</td>
                                        <td>
                                            <span>0을 입력하면 배송비 무료</span>
                                            <input type="text" name="delivery">원
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>상품 썸네일</td>
                                        <td>
                                            <span>크기 190 x 190, 상품 목록에 출력될 이미지 입니다. </span>
                                            <input type="file" name="thumb1">

                                            <span>크기 230 x 230, 상품 메인에 출력될 이미지 입니다. </span>
                                            <input type="file" name="thumb2">

                                            <span>크기 456 x 456, 상품 상세에 출력될 이미지 입니다. </span>
                                            <input type="file" name="thumb3">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>상세 상품정보</td>
                                        <td>
                                            <span>크기 가로 940px 높이 제약없음, 크기 최대 1MB, 상세페이지 상품정보에 출력될 이미지 입니다.</span>
                                            <input type="file" name="detail">
                                        </td>
                                    </tr>
                                </tbody>
                            </table>                                
                        </section>

                        <!-- 상품정보 제공 고시 -->
                        <section>
                            <h4>상품정보 제공고시</h4>
                            <p>
                                [전자상거래에 관한 상품정보 제공에 관한 고시] 항목에 의거 등록해야 되는 정보입니다.
                            </p>
                            <table>
                                <tbody>
                                    <tr>
                                        <td>상품상태</td>
                                        <td><input type="text" name="status" value="새상품"></td>
                                    </tr>
                                    <tr>
                                        <td>부가세 면세여부</td>
                                        <td><input type="text" name="duty" value="과세상품"></td>
                                    </tr>
                                    <tr>
                                        <td>영수증발행</td>
                                        <td><input type="text" name="receipt" value="발행가능 - 신용카드 전표, 온라인 현금영수증"></td>
                                    </tr>
                                    <tr>
                                        <td>사업자구분</td>
                                        <td><input type="text" name="bizType" value="사업자 판매자"></td>
                                    </tr>                                
                                    <tr>
                                        <td>원산지</td>
                                        <td><input type="text" name="origin" value="국내산"></td>
                                    </tr>                                
                                </tbody>
                            </table>                                
                        </section>
                        
                        <input type="submit" value="등록하기">
                    </form>
                </article>

                <p class="ico alert">
                    <strong>Warning!</strong>
                    전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
                </p>
                <!-- 상품등록 컨텐츠 끝 -->
            </section>
        </main>

<%@include file ="../_footer.jsp" %> 