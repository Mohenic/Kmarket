<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="./_header.jsp" %>

        <main id ="member">
            <div class ="join"> 
                <img src="./images/member_join_tit_welcome.gif" class="wel" alt="환영문구">
                <div class="type">
                    <div class="nomarl">
                        <img src="./images/member_join_tit_normal.gif" alt="일반회원 가입">
                        <div class="text">
                            <img src="./images/member_join_txt_normal.gif" alt="개인회원">
                            <a href="./signup.do?type=1">
                                <img src="./images/member_join_btn1.gif" alt="회원가입 버튼">
                            </a>
                        </div>
                    </div>
                    <div class="seller">
                        <img src="./images/member_join_tit_seller.gif" alt="판매자회원가입">
                        <div class="text">
                            <img src="./images/member_join_txt_seller.gif" alt="판매회원">
                            <a href="./signup.do?type=2">
                                <img src="./images/member_join_btn2.gif" alt="판매 회원 가입 버튼">
                            </a>
                        </div>
                    </div>                    

                </div>
                <img src="./images/member_join_banner1.jpg" class="banner" alt="banner1">
                <img src="./images/member_join_banner2.jpg" class="banner" alt="banner2">
            </div>
        </main>
<%@ include file="./_footer.jsp" %>