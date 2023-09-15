<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="./_header.jsp" %>
    <script>
	function checkCapsLock(event)  {
		  if (event.getModifierState("CapsLock")) {
		    document.getElementById("pass").innerText 
		      = "Caps Lock이 켜져 있습니다."
		  }else {
		    document.getElementById("pass").innerText 
		      = ""
		  }//capslock on/off 구분용도 
		}
</script>
        <main id ="member">
            <div class="login">
                <nav>
                    <h1>로그인</h1>
                </nav>
                <form action="/Kmarket/member/login.do" method="post">
                    <table>
                        <tr>
                            <td>아이디</td>
                            <td>
                                <input type="text" name="uid" placeholder="아이디를 입력해주세요">
                                <div></div>
                            </td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td>
                                <input type="password" name="pass" placeholder="비밀번호를 입력해주세요">
                            </td>
                        </tr>
                    </table>
                    <input type="submit" value="로그인">
                    <span>
                        <label>
                            <input type="checkbox" name="autologin">
                            자동로그인
                        </label>
                        <a href="#">아이디 찾기</a>
                        <a href="#">비밀번호 찾기</a>
                        <a href="./join.do">회원가입</a>
                    </span>
                    <a href="#" class="banner">
                        <img src="./images/member_login_banner.jpg" alt="1만원 쿠폰 할인">
                    </a>
                </form>
                <img src="./images/member_certifi_logo.gif" alt="banner">
            </div>
        </main>
<%@ include file="./_footer.jsp" %>