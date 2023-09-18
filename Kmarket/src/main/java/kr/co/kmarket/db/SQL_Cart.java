package kr.co.kmarket.db;

public class SQL_Cart {

	public final static String INSERT_PRODUCT_CART = "INSERT INTO `km_product_cart` SET "
													+ "`uid`=?"
													+ ",`prodNo`=?"
													+ ",`count`=?"
													+ ",`price`=?"
													+ ",`discount`=?"
													+ ",`point`=?"
													+ ",`delivery`=?"
													+ ",`total`=`count`*(price-(price*(discount*0.01)))+delivery"
													+ ",`rdate`=NOW()";
												
	
	public static final String SELECT_CARTS =  "SELECT a.*,b.prodName,b.descript  FROM `km_product_cart` as a join km_product as b  ON a.prodNo =b.prodNo  WHERE `uid`=?;";

}
