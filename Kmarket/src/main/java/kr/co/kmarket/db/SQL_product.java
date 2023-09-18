package kr.co.kmarket.db;

public class SQL_product {

	public final static String INSERT_PRODUCT = "INSERT INTO `km_product` SET "
												+ "`prodCate1`=?, "
												+ "`prodCate2`=?, "
												+ "`prodName`=?, "
												+ "`descript`=?, "
												+ "`seller`=?, "
												+ "`company`=?, "
												+ "`price`=?, "
												+ "`discount`=?, "
												+ "`point`=?, "
												+ "`stock`=?, "
												+ "`sold`=?, "
												+ "`delivery`=?, "
												+ "`hit`=?, "
												+ "`score`=?, "
												+ "`review`=?, "
												+ "`thumb1`=?, "
												+ "`thumb2`=?, "
												+ "`thumb3`=?, "
												+ "`detail`=?, "
												+ "`status`=?, "
												+ "`duty`=?, "
												+ "`receipt`=?, "
												+ "`bizType`=?, "
												+ "`origin`=?, "
												+ "`ip`=?, "
												+ "`etc1`=?, "
												+ "`etc2`=?, "
												+ "`etc3`=?, "
												+ "`etc4`=?, "
												+ "`etc5`=?, "
												+ "`rdate`=NOW()";


	public final static String SELECT_PRODUCT = "SELECT * FROM `km_product` WHERE `prodNo`=?";
	public final static String SELECT_PRODUCTS = "SELECT * FROM `km_product` LIMIT ?,10";
	public final static String SELECT_COUNT_PRODUCT_TOTAL = "SELECT COUNT(*) FROM `km_product`";

	public static final String SELECT_PRODUCTS_SELLING = "SELECT * FROM `km_product` ORDER BY sold DESC LIMIT ?, 5";
	public static final String SELECT_PRODUCTS_LOWPRICE = "SELECT * FROM `km_product` ORDER BY price ASC LIMIT ?, 5";
	public static final String SELECT_PRODUCTS_HIGHPRICE = "SELECT * FROM `km_product` ORDER BY price DESC LIMIT ?, 5";
	public static final String SELECT_PRODUCTS_HIGHRATING = "SELECT * FROM `km_product` ORDER BY score DESC LIMIT ?, 5";
	public static final String SELECT_PRODUCTS_MANYREVIEWS = "SELECT * FROM `km_product` ORDER BY review DESC LIMIT ?, 5";
	public static final String SELECT_PRODUCTS_RECENT = "SELECT * FROM `km_product` ORDER BY rdate DESC LIMIT ?, 5";

}
