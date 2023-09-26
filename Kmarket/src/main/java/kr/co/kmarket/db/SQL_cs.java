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
	//게시글 수정하기
	public static final String UPDATE_ARTICLE = "UPDATE `km_article` SET `cate` = ? ,`type` = ? ,`title`= ? ,`content` = ? "
												+ "WHERE `no` = ? ";

	//글 지우기
	public static final String DELETE_ARTICLE = "DELETE FROM `km_article` WHERE `no`=? OR `parent` = ?";
	
	//게시글 보기
	public static final String SELECT_ARTICLE = "SELECT a.* , b.`typeName`, c.`cateName` "
												+ "FROM `km_article`  AS a "
												+ "LEFT JOIN `km_article_type` AS b "
												+ "ON a.cate = b.cate  AND a.`type` = b.`type` "
												+ "LEFT JOIN `km_article_cate` AS c "
												+ "ON a.cate = c.cate "
												+ "WHERE `no` = ? ";
	
	//게시글 출력하기(1차...진행중(페이지 처리할 때 부분 수정이 필요할 거 같음.)) 
	public static final String SELECT_ARTICLES = "SELECT a.* , b.`typeName` "
													+ "FROM `km_article` AS a "
													+ "JOIN `km_article_type` AS b  "
													+ "ON a.cate = b.cate  AND a.`type` = b.`type` "
													+ "WHERE `group` = ? AND a.`cate` = ?  AND a.`parent` = 0 "
													+ "ORDER BY `no` DESC "
													+ "LIMIT ?,10 ";
	
	
	//faq type별 리스트 출력 
	public static final String SELECT_Faq_ARTICLES = "SELECT a.* , b.`typeName` "
															+ "FROM `km_article` AS a "
															+ "JOIN `km_article_type` AS b " 
															+ "ON a.cate = b.cate  AND a.`type` = b.`type` "
															+ "WHERE `group` = ? AND a.`cate` = ?  "
															+ "ORDER BY `type` DESC, `no` DESC "
															+ "LIMIT 0,10 " ;
	
	
	public static final String select_Faq_ArticleList = "SELECT * FROM `km_article_type` "
															+ "WHERE `cate` = ? "
															+ "ORDER BY `type` ";
	
	
	//notice 전체게시글 출력
	public static final String SELECT_COUNT_NOTICE_TOTAL = "SELECT COUNT(*) FROM `km_article` WHERE `group`= ?";
	
	//cate별 전체 게시글 총 갯수 출력(페이지 처리)
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(*) FROM `km_article` WHERE `group`= ? AND `cate` = ? AND `parent` = 0";

	//최신글 조회
	public static final String SELECT_ARTICLE_LATEST = "SELECT `no`, a.`cate` ,b.`typeName`, a.`title`, a.`writer`,a.`rdate` "
															+ "FROM `km_article` AS a "
															+ "LEFT JOIN `km_article_type` AS b "
															+ "ON a.`cate` = b.`cate` AND b.`type` = a.`type` "
															+ "WHERE `parent` = 0 AND a.`group` = ? "
															+ "Order BY `no` DESC LIMIT 0, ? " ;
	

	
	
	//공지사항 전체 출력
	public static final String SELECT_NOTICE_Article_ALL = "SELECT a.* , b.`cateName` "
															+ "FROM `km_article` AS a "
															+ "JOIN `km_article_cate` AS b "
															+ "ON a.cate = b.cate  "
															+ "WHERE `group` = ? "
															+ "ORDER BY `no` DESC "
															+ "LIMIT ?,10 ";
	
	//공지사항 카테별 출력
	public static final String SELECT_NOTICE_Article_TYPE = "SELECT a.* , b.`cateName` "
															+ "FROM `km_article` AS a "
															+ "JOIN `km_article_cate` AS b "
															+ "ON a.cate = b.cate  "
															+ "WHERE a.`group` = ? AND a.`cate` = ? "
															+ "ORDER BY `no` DESC "
															+ "LIMIT ?,10 ";		

	public static final String SELECT_ANSWER_ARTICLE_ = "SELECT * FROM `km_article` WHERE parent = ? ";
	
	//관리자 뽑기
	public static final String SELECT_TYPE_MEMBER = "SELECT `type` FROM `km_member` WHERE `uid` = ?";
	
	
	public final static String INSERT_COMMENT = "INSERT INTO `Article` SET "
														+ "`parent`=?, "
														+ "`content`=?,"
														+ "`writer`=?,"
														+ "`regip`=?,"
														+ "`rdate`=NOW()";
	
	//답변이 달리면 comment 1이 증가
	public final static String UPDATE_COMMENT_PLUS = "UPDATE `km_article` SET `comment` = `comment` + 1 WHERE `no` = ? ";
	public final static String UPDATE_COMMENT_MINUS = "UPDATE `km_article` SET `comment` = `comment` - 1 WHERE `no` = ? ";
	
}
