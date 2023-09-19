<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "../../_header.jsp" %>
<style>
#admin-cs-notice-list >  section > div > select {
    width: 150px;
    padding: 6px;
    border: 1px solid #959595;
    font-size: 13px;
    background-color: #fefefe;
    color: #333;
    box-sizing: border-box;
}

#admin-cs-notice-list > section > div > input {
    width: 200px;
    padding: 7px;
    border: 1px solid rgb(149, 149, 149);
    font-size: 13px;
    background-color: rgb(254, 254, 254);
    color: rgb(51, 51, 51);
    vertical-align: middle;
    box-sizing: border-box;
    margin-bottom: 5px;
}

#admin-cs-notice-list > section > table tr > th {
    padding: 10px 0;
    background: #f6f6f6;
    border-top: 2px solid rgb(135, 152, 163);
}


main table tr > td:nth-child(1) {
    width: 20px;
    border-top: 1px solid #e6e6e6;
    border-bottom: 1px solid #e6e6e6;
    background: #f6f6f6;
    padding: 10px;
    text-align: left;
}

main table tr > td {
    border-top: 1px solid #e6e6e6;
    border-bottom: 1px solid #e6e6e6;
    padding: 10px;
    text-align: left;
}



#admin-cs-notice-list > section > table tr > td {
    background: rgb(255, 255, 255);
    text-align: center;
    box-sizing: border-box;
}

#admin-cs-notice-list > section > table tr > td:nth-child(1) {width: 20px;}
#admin-cs-notice-list > section > table tr > td:nth-child(2) {width: 80px;}
#admin-cs-notice-list > section > table tr > td:nth-child(3) {width: 80px;}
#admin-cs-notice-list > section > table tr > td:nth-child(4) {width: auto;text-align: left;}
#admin-cs-notice-list > section > table tr > td:nth-child(5) {width: 80px;}
#admin-cs-notice-list > section > table tr > td:nth-child(6) {width: 80px;}
#admin-cs-notice-list > section > table tr > td:nth-child(7) {width: 100px;}

#admin-cs-notice-list > section > table img.thumb {
    width: 60px
}

#admin-cs-notice-list > section > table tr > td {
    text-align: center;
}

#admin-cs-notice-list > section input[type=button] {
    width: 100px;
    margin-top: 10px;
    padding: 6px;
    border: 1px solid #959595;
    font-size: 13px;
    background-color: #fefefe;
    color: #333;
}

#admin-cs-notice-list .paging > .num > a {
    display: inline-block;
    min-width: 14px;
    margin: 0 2px;
    padding: 8px 9px;
    border: 1px solid #c4c4c4;
    color: #000;
    font-family: Tahoma;
    font-size: 12px;
    text-align: center;
    text-decoration: none;
}7

#admin-cs-notice-list .paging {
    width: 100%;
    padding: 30px 0;
    text-align: center;
}

#admin-cs-notice-list .paging > span > a {
    color: rgb(119, 119, 119);
    font-family: 돋움, Dotum, Tahoma, sans-serif;
    font-size: 11px;
    letter-spacing: -1px;
}
</style>

<%@ include file = "../../_aside.jsp" %>

        <section id="admin-cs-notice-list">
            <nav>
                <h3>공지사항 목록</h3>
                <p>
                    HOME &gt; 고객센터 &gt; <strong>공지사항</strong>
                </p>
            </nav>
            <section>
                <div>
                    <select name="">
                        <option value="">유형선택</option>
                        <option value="">고객서비스</option>
                        <option value="">이벤트당첨</option>
                        <option value="">안전거래</option>                                    
                    </select>
                </div>
                <table>
                    <tbody>
                        <tr>
                            <th><input type="checkbox" name="all"></th>
                            <th>번호</th>
                            <th>유형</th>
                            <th>제목</th>
                            <th>조회</th>
                            <th>날짜</th>
                            <th>관리</th>
                        </tr>
                        <tr>
                            <td class="chk"><input type="checkbox"></td>
                            <td class="no">1</td>
                            <td class="type">고객서비스</td>
                            <td class="title">[안내] 해외결제 사칭 문자 주의</td>
                            <td class="hit">1</td>
                            <td class="rdate">2023.09.19</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="#">[수정]</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="chk"><input type="checkbox"></td>
                            <td class="no">2</td>
                            <td class="type">안전결제</td>
                            <td class="title">[안내] 해외결제 사칭 문자 주의</td>
                            <td class="hit">12</td>
                            <td class="rdate">2023.09.19</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="#">[수정]</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </section> <!--table end-->
        </section><!--admin-product-list end-->
    </main>
<%@include file ="../../_footer.jsp" %> 