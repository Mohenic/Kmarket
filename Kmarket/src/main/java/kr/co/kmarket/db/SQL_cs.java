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
	
	//문의사항 글쓰기
	public static final String INSERT_ARTICLE = "INSERT INTO `km_article` SET "							
															+ "`group` = ? ,"
															+ "`cate` = ? ,"
															+ "`type` = ? ,"
															+ "`title` = ? , "
															+ "`content` = ? ,"
															+ "`writer` = ? , "
															+ "`regip` = ? ,"
															+ "`rdate` = NOW()";
	
	//게시글 보기
	public static final String SELECT_ARTICLE = "SELECT a.* , b.`typeName` "
													+ "FROM `km_article`  AS a "
													+ "JOIN `km_article_type` AS b "
													+ "ON a.cate = b.cate  AND a.`type` = b.`type` "
													+ "WHERE `no` = ? ";
	
	//게시글 출력하기(1차...진행중(페이지 처리할 때 부분 수정이 필요할 거 같음.)) 
	public static final String SELECT_ARTICLES = "SELECT a.* , b.`typeName` "
													+ "FROM `km_article` AS a "
													+ "JOIN `km_article_type` AS b  "
													+ "ON a.cate = b.cate  AND a.`type` = b.`type` "
													+ "WHERE `group` = ? AND a.`cate` = ?"
													+ "ORDER BY `no` DESC "
													+ "LIMIT ?,10 ";
	
	
	
	public static final String SELECT_NOTICE_ARTICLES = "SELECT a.* , b.`typeName` "
															+ "FROM `km_article` AS a "
															+ "JOIN `km_article_type` AS b " 
															+ "ON a.cate = b.cate  AND a.`type` = b.`type` "
															+ "WHERE `group` = ? AND a.`cate` = ? AND  a.`type` = ? "
															+ "ORDER BY `no` DESC "
															+ "LIMIT 0,10 " ;
	
	
	
	//cate별 전체 게시글 총 갯수 출력(페이지 처리)
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(*) FROM `km_article` WHERE `group`= ? AND `cate` = ?";

	//최신글 조회
	public static final String SELECT_ARTICLE_LATEST = "SELECT `no`, b.`typeName`, a.`title`, a.`writer`,a.`rdate` "
															+ "FROM `km_article` AS a "
															+ "JOIN `km_article_type` AS b "
															+ "ON a.`cate` = b.`cate` AND b.`type` = a.`type` "
															+ "WHERE `parent` = 0 AND a.`group` = ? "
															+ "Order BY `no` DESC LIMIT 0, ? " ;



	
}
