<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>케이마켓::대한민국 1등 온라인 쇼핑몰</title>
    <link rel="shortcut icon" type="image/x-icon" href="./images/favicon.ico" />
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css"/>
    <link rel="stylesheet" href="./css/common.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <script src="./js/index.js"></script>
    <script src="./js/timeout.js"></script>
    <style>
      #bannerTop {
        display: none;
        width: 100%;
        height: 80px;
        border-bottom: 1px solid #e9e9e9;        
        box-sizing: border-box;
      }

      #bannerTop.on {
        display: block;
      }

      #bannerTop > article {
        position: relative;
        width: 1200px;
        height: 100%;        
        margin: 0 auto;
        overflow: hidden;
      }

      #bannerTop > article > .btnClose {
        position: absolute;
        right: 0px;
        top: 0px;
        width: 40px;
        height: 40px;
        background-image: url('./images/ico_sprite.png');
        background-position: -122px -142px;
        background-color: transparent;
        font-size: 0;
        border: none;
        cursor: pointer;
      }

    </style>
    <script>


    </script>
  </head>
  <body>
    <div id="bannerTop" class="on" style="background: #e4dfdf;">
      <article>
        <a href="#"><img src="./images/topBanner1.png"/></a>
        <button class="btnClose">close</button>
      </article>
    </div>
    <div id="container">      
      <header>
        <div class="top">
          <div>
          <c:if test="${sessUser eq null }">
            <a href="./member/login.do">로그인</a>
            <a href="./member/join.do">회원가입</a>
          </c:if>
          <c:if test="${sessUser ne null }">
          	<c:if test="${sessUser.name ne null}">
          		<a herf="#">${sessUser.name }</a>
          	</c:if>
          	<c:if test="${sessUser.type == 2 }">
          		<a herf="#">${sessUser.company}</a>
          		<a herf="/Kmarket/admin/index.do">관리자</a>
          	</c:if>
            	<a href="#">마이페이지</a>
            	<a href="/Kmarket/member/logout.do">로그아웃</a>
            	<a href="#"
              	><i class="fa fa-shopping-cart" aria-hidden="true"></i
              	>&nbsp;장바구니</a
            	>
          </c:if>  
          </div>
        </div>
        <div class="logo">
          <div>
            <a href="#"><img src="./images/header_logo.png" alt="로고" /></a>
            <form action="#">
              <input type="text" name="search" />
              <button><i class="fa fa-search"></i></button>
            </form>
          </div>
        </div>
        <div class="menu">
          <div>
            <ul>
              <li><a href="#">히트상품</a></li>
              <li><a href="#">추천상품</a></li>
              <li><a href="#">최신상품</a></li>
              <li><a href="#">인기상품</a></li>
              <li><a href="#">할인상품</a></li>
            </ul>
            <ul>
              <li><a href="/Kmarket/cs/notice/list.do?group=Notice&cate=notice">공지사항</a></li>
              <li><a href="/Kmarket/cs/faq/list.do?group=Faq&cate=member">자주묻는질문</a></li>
              <li><a href="/Kmarket/cs/qna/list.do?group=Qna&cate=qna">문의하기</a></li>
              <li><a href="/Kmarket/cs/index.do">고객센터</a></li>
            </ul>
          </div>
        </div>
      </header>
      <main>
        <!-- 카테고리/베스트 상품 영역 -->
        <aside>
          <!-- 카테고리 -->
          <ul class="category">
            <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
            <li>
              <a href="#"
                ><i class="fas fa-tshirt"></i>패션·의류·뷰티<i
                  class="fas fa-angle-right"
                ></i
              ></a>
              <ol>
                <li><a href="#">남성의류</a></li>
                <li><a href="#">여성의류</a></li>
                <li><a href="#">잡화</a></li>
                <li><a href="#">뷰티</a></li>
              </ol>
            </li>
            <li>
              <a href="#"
                ><i class="fas fa-laptop"></i>가전·디지털<i
                  class="fas fa-angle-right"
                ></i
              ></a>
              <ol>
                <li><a href="#">노트북/PC</a></li>
                <li><a href="#">가전</a></li>
                <li><a href="#">휴대폰</a></li>
                <li><a href="#">기타</a></li>
              </ol>
            </li>
            <li>
              <a href="#"
                ><i class="fas fa-utensils"></i>식품·생필품<i
                  class="fas fa-angle-right"
                ></i
              ></a>
              <ol>
                <li><a href="#">신선식품</a></li>
                <li><a href="#">가공식품</a></li>
                <li><a href="#">건강식품</a></li>
                <li><a href="#">생필품</a></li>
              </ol>
            </li>
            <li>
              <a href="#"
                ><i class="fas fa-home"></i>홈·문구·취미<i
                  class="fas fa-angle-right"
                ></i
              ></a>
              <ol>
                <li><a href="#">가구/DIY</a></li>
                <li><a href="#">침구·커튼</a></li>
                <li><a href="#">생활용품</a></li>
                <li><a href="#">사무용품</a></li>
              </ol>
            </li>
          </ul>

          <!-- 베스트상품 배너 -->
          <article class="best">
            <h1><i class="fas fa-crown"></i>베스트상품</h1>
            <ol>
              <li>
                <a href="#">
                  <div class="thumb">
                    <i>1</i>
                    <img src="https://via.placeholder.com/230" alt="item1" />
                  </div>
                  <h2>상품명</h2>
                  <div class="org_price">
                    <del>30,000</del>
                    <span>10%</span>
                  </div>
                  <div class="dis_price">
                    <ins>27,000</ins>
                  </div>
                </a>
              </li>
              <li>
                <a href="#">
                  <div class="thumb">
                    <i>2</i>
                    <img src="https://via.placeholder.com/50" alt="item1" />
                  </div>
                  <article>
                    <h2>상품명</h2>
                    <div class="org_price">
                      <del>30,000</del>
                      <span>10%</span>
                    </div>
                    <div class="dis_price">
                      <ins>27,000</ins>
                    </div>
                  </article>
                </a>
              </li>
              <li>
                <a href="#">
                  <div class="thumb">
                    <i>3</i>
                    <img src="https://via.placeholder.com/50" alt="item1" />
                  </div>
                  <article>
                    <h2>상품명</h2>
                    <div class="org_price">
                      <del>30,000</del>
                      <span>10%</span>
                    </div>
                    <div class="dis_price">
                      <ins>27,000</ins>
                    </div>
                  </article>
                </a>
              </li>
              <li>
                <a href="#">
                  <div class="thumb">
                    <i>4</i>
                    <img src="https://via.placeholder.com/50" alt="item1" />
                  </div>
                  <article>
                    <h2>상품명</h2>
                    <div class="org_price">
                      <del>30,000</del>
                      <span>10%</span>
                    </div>
                    <div class="dis_price">
                      <ins>27,000</ins>
                    </div>
                  </article>
                </a>
              </li>
              <li>
                <a href="#">
                  <div class="thumb">
                    <i>5</i>
                    <img src="https://via.placeholder.com/50" alt="item1" />
                  </div>
                  <article>
                    <h2>상품명</h2>
                    <div class="org_price">
                      <del>30,000</del>
                      <span>10%</span>
                    </div>
                    <div class="dis_price">
                      <ins>27,000</ins>
                    </div>
                  </article>
                </a>
              </li>
            </ol>
          </article>
        </aside>
        <section>
          <!-- 슬라이더 영역 -->
          <section class="slider">
            <ul>
              <li>
                <a href="#"
                  ><img src="/Kmarket/images/mainBanner11.jpg" alt="item1"
                /></a>
              </li>
              <li>
                <a href="#"
                  ><img src="/Kmarket/images/mainBanner2.jpg" alt="item2"
                /></a>
              </li>
              <li>
                <a href="#"
                  ><img src="/Kmarket/images/mainBanner3.jpg" alt="item3"
                /></a>
              </li>
              <li>
                <a href="#"
                  ><img src="/Kmarket/images/mainBanner4 .jpg" alt="item4"
                /></a>
              </li>
              <li>
                <a href="#"
                  ><img src="/Kmarket/images/mainBanner5 .jpg" alt="item5"
                /></a>
              </li>
            </ul>
          </section>
          <!-- 히트상품 영역 -->
          <section class="hit">
            <h3><span>히트상품</span></h3>
            <c:forEach var ="product1" items="${requestScope.products1 }">
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>${product1.prodName }</h2>
                <p>${product1.descript }</p>
                <div class="org_price">
                  <del>${product1.price }</del>
                  <span>${product1.discount }%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            </c:forEach>
           
          </section>
          <!-- 추천상품 영역 -->
          <section class="recommend">
            <h3><span>추천상품</span></h3>
            <c:forEach var ="product2" items="${requestScope.products2 }">
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>${product2.prodName }</h2>
                <p>${product2.descript }</p>
                <div class="org_price">
                  <del>${product2.price }</del>
                  <span>${product2.discount }%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">${product2.delivery}</span>
                </div>
              </a>
            </article>
            </c:forEach>
          </section>
          <!-- 최신상품 영역 -->
          <section class="new">
            <h3><span>최신상품</span></h3>
            <c:forEach var ="product3" items="${requestScope.products3 }">
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>${product3.prodName }</h2>
                <p>${product3.descript }</p>
                <div class="org_price">
                  <del>${product3.price }</del>
                  <span>${product3.discount }%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">${product3.delivery}</span>
                </div>
              </a>
            </article>
            </c:forEach>
 			</section>
          <!-- 할인상품 영역 -->
          <section class="discount">
            <h3><span>할인상품</span></h3>
           <c:forEach var ="product4" items="${requestScope.products4 }">
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>${product4.prodName }</h2>
                <p>${product4.descript }</p>
                <div class="org_price">
                  <del>${product4.price }</del>
                  <span>${product4.discount }%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">${product4.delivery}</span>
                </div>
              </a>
            </article>
            </c:forEach>
           
          </section>
        </section>
      </main>
      <footer>
        <ul>
          <li><a href="./company/">회사소개</a></li>
          <li><a href="#">서비스이용약관</a></li>
          <li><a href="#">개인정보처리방침</a></li>
          <li><a href="#">전자금융거래약관</a></li>
        </ul>
        <div>
          <p><img src="./images/footer_logo.png" alt="로고" /></p>
          <p>
            <strong>(주)KMARKET</strong><br />
            부산시 강남구 테헤란로 152 (역삼동 강남파이낸스센터)<br />
            대표이사 : 홍길동<br />
            사업자등록번호 : 220-81-83676 사업자정보확인<br />
            통신판매업신고 : 강남 10630호 Fax : 02-589-8842
          </p>
          <p>
            <strong>고객센터</strong><br />
            Tel : 1234-5678 (평일 09:00~18:00)<br />
            스마일클럽/SVIP 전용 : 1522-5700 (365일 09:00~18:00)<br />
            경기도 부천시 원미구 부일로 223(상동) 투나빌딩 6층<br />
            Fax : 051-123-4567 | Mail : kmarket@kmarket.co.kr<br />
          </p>
        </div>
      </footer>
      <button type="button" id="top">상단이동</button>
    </div>
  </body>
</html>
