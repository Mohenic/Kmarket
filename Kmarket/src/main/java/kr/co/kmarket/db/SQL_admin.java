package kr.co.kmarket.db;

public class SQL_admin {
	
	
	public final static String INSERT_ARTICLE = "INSERT INTO `km_article` SET "
											  + "`group` = ?, "
											  + "`cate` = ?, "
											  + "`type` = ?, "
											  + "`title` = ?, "
											  + "`content` = ?, "
											  + "`writer` = ?, "
											  + "`regip` = ?, "
											  + "`rdate` = NOW()";
	
	public final static String SELECT_ARTICLE = "SELECT a.*, b.cateName "
											  + "FROM `km_article` AS a "
											  + "JOIN `km_article_cate` AS b "
											  + "ON a.`cate` = b.`cate` "
											  + "WHERE `no`=?";

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
	public final static String UPDATE_ARTICLE = "UPDATE `km_article` SET `cate`=?, `title`=?, `content`=? WHERE `no`=? AND `parent`= 0";
	public final static String DELETE_ARTICLE = "DELETE FROM `km_article` WHERE `no`=?";
	
	//상품선택
	public final static String SELECT_PRODUCT = "SELECT * FROM `km_product` WHERE `prodNo` = ? ";
	
}
