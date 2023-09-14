package kr.co.kmarket.db;

public class SQL_cs {

	/* faq Article */
	
	public static final String SELECT_FAQ_ARTICLE = "SELECT * FROM `km_faq` WHERE `faqNo` = ?";
	public static final String SELECT_FAQ_ARTICLES = "SELECT * FROM `km_faq`"
												   + "WHERE `cate1` = ? "
												   + "ORDER BY `no` DESC "
												   + "LIMIT ?,10";
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(*) FROM `km_faq` WHERE `cate1` = ?";
	
}
