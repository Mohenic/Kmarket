package kr.co.kmarket.db;

public class SQL_cs {

	/* faq Article */
	
	public static final String SELECT_FAQ_ARTICLE = "SELECT * FROM `km_faq` WHERE `faqNo` = ?";
	public static final String SELECT_FAQ_ARTICLES = "SELECT * FROM `km_faq`"
												   + "WHERE `cate1` = ? "
												   + "ORDER BY `faqNo` DESC "
												   + "LIMIT ?,10";
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(*) FROM `km_faq` WHERE `cate1` = ?";
	
	
	
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
	
	
	
	public static final String SELECT_QNA_ARTICLES = "SELECT * FROM `km_qna`"
														   + "WHERE `cate` = ? "
														   + "ORDER BY `qnaNo` DESC "
														   + "LIMIT 0,10";
	
}
