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
	
	//Qna답변
	public final static String INSERT_ANSWER = "INSERT INTO `km_article` SET "
										+ "`parent`= ? , "
										+ "`group` = ? , "
										+ "`cate` = ? , "
										+ "`type` = ? , "
										+ "`title` = ? , "
										+ "`content`= ? , "
										+ "`writer`= ? , "
										+ "`regip`= ? , "
										+ "`rdate`=NOW()";
	//Qna 답출력
	public final static String SELECT_ANSWER = "SELECT * FROM `km_article` WHERE `parent` = ? " ;
	
	
	public final static String SELECT_ARTICLE = "SELECT a.*, b.cateName, c.typeName "
											+ "FROM `km_article` AS a "
											+ "JOIN `km_article_cate` AS b "
											+ "ON a.`cate` = b.`cate`\r\n"
											+ "JOIN `km_article_type` AS c "
											+ "ON a.`cate`=b.cate "
											+ "WHERE `no`= ? ";
	
	public final static String SELECT_ARTICLE_TYPE = "SELECT a.*, b.`cateName`, c.`typeName` "
													+ "FROM `km_article` AS a "
													+ "JOIN `km_article_cate` AS b ON a.`cate` = b.`cate` "
													+ "JOIN `km_article_type` AS c ON a.`type` = c.`type` "
													+ "WHERE `no`=?";

	public final static String SELECT_ARTICLES_ALL = "SELECT a.*, b.`cateName`, c.`typeName` "
												+ "FROM `km_article` AS a "
												+ "JOIN `km_article_cate` AS b "
												+ "ON a.`cate` = b.`cate` "
												+ "JOIN `km_article_type` AS c "
												+ "ON a.`type` = c.`type` "
												+ "WHERE `group`= ? AND parent = 0 " 
												+ "ORDER BY `no` DESC LIMIT ?, 10";
	
	public final static String SELECT_ARTICLES_CATE = "SELECT a.*, b.`cateName`"
													+ "FROM `km_article` AS a "
													+ "JOIN `km_article_cate` AS b ON a.`cate` = b.`cate` "
												    +"WHERE `group`= ? AND a.`cate`= ? AND parent = 0 "
												    +"ORDER BY `no` DESC LIMIT ?, 10";
	
	public final static String SELECT_ARTICLES_TYPE_ALL = "SELECT a.*, b.`cateName`, c.`typeName` "
														+ "FROM `km_article` AS a "
														+ "JOIN `km_article_cate` AS b ON a.`cate` = b.`cate` "
														+ "JOIN `km_article_type` AS c ON a.`type` = c.`type` "
														+"WHERE `group`= ? "
														+"ORDER BY `no` DESC LIMIT ?, 10";
	
	public final static String SELECT_ARTICLES_TYPE = "SELECT a.*, b.`cateName`, c.`typeName` "
													+ "FROM `km_article` AS a "
													+ "JOIN `km_article_cate` AS b ON a.`cate` = b.`cate` "
													+ "JOIN `km_article_type` AS c ON a.`type` = c.`type` "
													+ "WHERE `group` = ? AND a.`cate` = ? AND a.`type` = ? "
													+ "ORDER BY `no` DESC "
													+ "LIMIT ?, 10;";
	public final static String SELECT_ARTICLES_GROUP_ALL = "SELECT a.*, b.`cateName`, c.`typeName` "
			+ "FROM `km_article` AS a "
			+ "JOIN `km_article_cate` AS b ON a.`cate` = b.`cate` "
			+ "JOIN `km_article_type` AS c ON a.`type` = c.`type` "
			+ "WHERE `group` = ? AND a.`cate` = ?  "
			+ "ORDER BY `no` DESC "
			+ "LIMIT ?, 10;";
	
	public final static String SELECT_COUNT_ARTICLE_ALL = "SELECT COUNT(*) FROM `km_article` WHERE `group`=?";
	public final static String SELECT_COUNT_ARTICLE_CATE = "SELECT COUNT(*) FROM `km_article` WHERE `group`=? AND `cate`=?";
	
	public final static String UPDATE_ARTICLE = "UPDATE `km_article` SET `cate`=?, `title`=?, `content`=? WHERE `no`=? AND `parent`= 0";
	public final static String UPDATE_ARTICLE_TYPE = "UPDATE `km_article` SET `cate`=?, `type`=?, `title`=?, `content`=? WHERE `no`=? AND `parent`= 0";
	public final static String DELETE_ARTICLE = "DELETE FROM `km_article` WHERE `no`=?";
	
	//상품선택
	public final static String SELECT_PRODUCT = "SELECT * FROM `km_product` WHERE `prodNo` = ? ";
	
}
