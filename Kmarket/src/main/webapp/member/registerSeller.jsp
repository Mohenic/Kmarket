<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="./_header.jsp" %>
<script src="/Kmarket/member/js/checkUser.js"></script>
<script src="/Kmarket/member/js/validation.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="/Kmarket/member/js/zipcode.js"></script>

        <main id ="member">
            <div class ="registerSeller">
                <nav>
                    <h1>
                        판매자 회원가입
                    </h1>
                </nav> 
                
                <form action="/Kmarket/member/registerSeller.do" id="formSeller" method="post">
                	<input type ="hidden" name="type" value="${type}">
                    <section>
                        <table>
                            <caption>필수 정보입력</caption>
                            <tr>
                                <th>
                                    <span class="essential">*</span>
                                    아이디
                                </th>
                                <td>
                                    <input type="text" name="uid" placeholder="아이디를 입력해 주세요" required>
                                     <button type="button" id="btnCheckUid"><img src="/Kmarket/member/images/chk_id.gif" alt="중복확인"></button>
                                    <span class="mId">영문, 숫자로 4~12자까지 설정해 주세요.</span>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="essential">*</span>
                                    비밀번호
                                </th>
                                <td>
                                    <input type="password" name="pass1" placeholder="비밀번호를 입력해 주세요" required>
                                    <span class="mPass">영문, 숫자, 특수문자를 조합하여 8~12자까지 설정해 주세요.</span>
                                </td>

                            </tr>
                            <tr>
                                <th>
                                    <span class="essential">*</span>
                                    비밀번호 확인
                                </th>
                                <td>
                                    <input type="password" name="pass2" placeholder="비밀번호 재입력" required>
                                    <span class="mPass">비밀번호 재입력.</span>
                                </td>
                            </tr>

                        </table>
                    	        	<span class ="resultUid"></span><br>
                    	        	<span class ="resultPass"></span>
                    </section>
                    <section>
                        <table>
                            <caption>판매자 정보 입력</caption>
                            <tr>
                                <th>
                                    <span class="essential">*</span>
                                    회사명
                                </th>
                                <td>
                                    <input type="text" name="company" placeholder="회사명을 입력해주세요" required>
                                    <span class="mCompany">(주)포함입력, 예) (주)케이마켓</span>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="essential">*</span>
                                    대표자
                                </th>
                                <td>
                                        <input type="text" name="ceo" placeholder="대표자 입력" required>

                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="essential">*</span>
                                    사업자등록번호
                                </th>
                                <td>
                                    <input type="text" name="corpReg" placeholder="사업자등록번호 입력" required>
                                    <span class="mCorp">-표시 포함 12자리 입력, 예) 123-45-67890</span>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="essential">*</span>
                                    통신판매업신고 번호
                                </th>
                                <td>
                                    <input type="text" name="onlineReg" placeholder="통신판매업신고 입력" required>
                                    <span class="mOnline"> - 표시 포함, 예) 강남-12345, 제 1-01-23-4567호, 2017-경기성남-0011</span>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="essential">*</span>
                                    전화번호
                                </th>
                                <td>
                                    <input type="text" name="tel" placeholder="휴대폰 번호 입력" required>
                                    <span class="mTel">  표시 포함, 지역번호 포함, 예) 02-234-1234</span>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="essential">*</span>
                                    팩스번호
                                </th>
                                <td>
                                    <input type="text" name="fax" placeholder="팩스 번호 입력" required>
                                    <span class="mFax"> - 표시 포함, 지역번호 포함, 예) 02-234-1234</span>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="essential">*</span>
                                    EMAIL
                                </th>
                                <td>
                                    <input type="email" name="email" placeholder="이메일 입력" required>
                                </td>
                            </tr>
                            <tr class="addr">
                                <th>회사주소</th>
                                <td>
                                    <div>
                                        <input type="text" name="zip" id="zip" placeholder="우편번호 입력 클릭" readonly>
                                        <button type="button" class="btnZip" onclick="zipcode()"><img src="./images/btn_post_search.gif" alt="가나다"></button>
                                    </div>
                                    <div>
                                        <input type="text" name="addr1" id="addr1" size="50" placeholder="주소를 검색하세요" readonly>
                                    </div>
                                    <div>
                                        <input type="text" name="addr2" id="addr2" size="50" placeholder="상세주소를 입력하세요">
                                    </div>
                                </td>
                            </tr>                           
                        </table>
						<span class ="resultCeo"></span><br>
						<span class ="resultTel"></span><br>
						<span class ="resultFax"></span><br>
						<span id ="resultEmail"></span>
                    </section>
                    <section>
                        <table>
                            <caption>담당자 정보입력</caption>
                            <tr>
                                <th>
                                    <span class="essential">*</span>
                                    이름
                                </th>
                                <td>
                                    <input type="text" name="name" placeholder="이름 입력" required>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="essential">*</span>
                                    휴대폰
                                </th>
                                <td>
                                    <input type="text" name="hp" placeholder="전화번호 입력" required>
                                    <span class="mHp">- 포함 13자리를 입력하세요.  </span>
                                </td>
                            </tr>
                        </table>
                        <span class ="resultName"></span><br>
                    	<span id ="resultHp"></span>

                    </section>
                    <div>
                        <input type="submit" class="join" value="회원가입">
                    </div>
                </form>




            </div>
        </main>
<%@ include file="./_footer.jsp" %>