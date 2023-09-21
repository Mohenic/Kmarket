package kr.co.kmarket.db;

public class SQL_admin {

	public final static String SELECT_ARTICLES_ALL ="SELECT a.*, "
												   +"b.`cateName` "
												   +"FROM `km_article` AS a "
												   +"JOIN `km_article_cate` AS b "
												   +"ON a.`cate` = b.`cate` "
												   +"WHERE `group`= ?"
												   +"ORDER BY `no` DESC LIMIT ?, 10";
	
	public final static String SELECT_ARTICLES_CATE ="SELECT a.*, "
												    +"b.`cateName` "
												    +"FROM `km_article` AS a "
												    +"JOIN `km_article_cate` AS b "
												    +"ON a.`cate` = b.`cate` "
												    +"WHERE `group`= ? AND a.`cate`= ?"
												    +"ORDER BY `no` DESC LIMIT ?, 10";
	
	public final static String SELECT_COUNT_ARTICLE_ALL = "SELECT COUNT(*) FROM `km_article` WHERE `group`=?";
	public final static String SELECT_COUNT_ARTICLE_CATE = "SELECT COUNT(*) FROM `km_article` WHERE `group`=? AND `cate`=?";
	
	//상품선택
	public final static String SELECT_ARTICLE = "SELECT * FROM `km_product` WHERE `prodNo` = ? ";
	
}
