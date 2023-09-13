package kr.co.kmarket.db;

public class SQL_product {

	public final static String INSERT_PRODUCT = "INSERT INTO `Product` SET "
												+ "`prodNo`=?,"
												+ "`prodCate1`=?,"
												+ "`prodCate2`=?,"
												+ "`prodName`=?,"
												+ "`descript`=?,"
												+ "`seller`=?,"
												+ "`company`=?,"
												+ "`price`=?,"
												+ "`discount`=?,"
												+ "`point`=?,"
												+ "`stock`=?,"
												+ "`sold`=?,"
												+ "`delivery`=?,"
												+ "`hit`=?,"
												+ "`score`=?,"
												+ "`review`=?,"
												+ "`thumb1`=?,"
												+ "`thumb2`=?,"
												+ "`thumb3`=?,"
												+ "`detail`=?,"
												+ "`status`=?,"
												+ "`duty`=?,"
												+ "`receipt`=?,"
												+ "`bizType`=?,"
												+ "`origin`=?,"
												+ "`ip`=?,"
												+ "`rdate`=?,"
												+ "`etc1`=?,"
												+ "`etc2`=?,"
												+ "`etc3`=?,"
												+ "`etc4`=?,"
												+ "`etc5`=?";

	public final static String SELECT_PRODUCT = "SELECT * FROM `Product` WHERE `prodNo`=?";
}
