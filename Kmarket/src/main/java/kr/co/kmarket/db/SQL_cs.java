package kr.co.kmarket.db;

public class SQL_cs {

	/* faq Article */
	
	public static final String SELECT_FAQ_ARTICLE = "SELECT * FROM `km_faq` WHERE `faqNo` = ?";
	public static final String SELECT_FAQ_ARTICLES = "SELECT * FROM `km_faq`"
												   + "WHERE `cate1` = ? "
												   + "ORDER BY `faqNo` DESC "
												   + "LIMIT ?,10";
	
	
	
	
	
	
	public static final String INSERT_FAQ_ARTICLE = "INSERT INTO `km_faq` SET "
															+ "`cate1` = ? ,"
															+ "`cate2` = ? ,"
															+ "`title` = ? , "
															+ "`content` = ? ,"
															+ "`writer` = ? , "
															+ "`regip` = ? ,"
															+ "`rdate` = NOW()";
	
	
	public static final String INSERT_QNA_ARTICLE = "INSERT INTO `km_qna` SET "
															+ "`cate` = ? ,"
															+ "`type` = ? ,"
															+ "`title` = ? , "
															+ "`content` = ? ,"
															+ "`writer` = ? , "
															+ "`regip` = ? ,"
															+ "`rdate` = NOW()";
	
	//게시글 보기
	public static final String SELECT_QNA_ARTICLE = "SELECT * FROM `km_qna` WHERE `qnaNo` = ?";
	
	//게시글 출력하기(1차...진행중(페이지 처리할 때 부분 수정이 필요할 거 같음.)) 
	public static final String SELECT_QNA_ARTICLES = "SELECT * FROM `km_qna`"
														   + "WHERE `cate` = ? "
														   + "ORDER BY `qnaNo` DESC "
														   + "LIMIT ?,10";
	//cate별 전체 게시글 총 갯수 출력(페이지 처리)
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(*) FROM `km_qna` WHERE `cate` = ?";
}
