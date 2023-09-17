package kr.co.kmarket.db;

public class SQL_Cart {

	public final static String INSERT_PRODUCT_CART = "INSERT INTO `km_product_cart` SET "
													+ "`cartNo`=?, "
													+ "`uid`=?, "
													+ "`prodNo`=?, "
													+ "`count`=?, "
													+ "`price`=?, "
													+ "`discount`=?, "
													+ "`point`=?, "
													+ "`delivery`=?, "
													+ "`total`=?, "
													+ "`rdate`=NOW()";
	
	public static final String SELECT_CARTS =  "SELECT * FROM `km_product_cart` WHERE `cartNo`=?";

}
