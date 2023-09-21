package kr.co.kmarket.db;

public class SQL_ORDER {
	
	public static final String INSERT_ORDER="INSERT INTO `km_product_order` SET"
											+ "`ordUid`=?,"
											+ "`ordCount`=?,"
											+ "`ordPrice`=?,"
											+ "`ordDiscount`=?,"
											+ "`ordDelivery`=?,"
											+ "`savePoint`=?,"
											+ "`usedPoint`=?,"
											+ "`ordTotPrice`=?,"
											+ "`recipName`=?,"
											+ "`recipHp`=?,"
											+ "`recipZip`=?,"
											+ "`recipAddr1`=?,"
											+ "`recipAddr2`=?,"
											+ "`ordPayment`=?,"
											+ "`ordComplete`=1,"
											+ "`ordDate`=NOW()";
	
	public static final String INSERT_ITEM="INSERT INTO `km_product_order_item` SET"
											+ "`ordNo`=?,"
											+ "`prodNo`=?,"
											+ "`count`=?,"
											+ "`price`=?,"
											+ "`discount`=?,"
											+ "`point`=?,"
											+ "`delivery`=?,"
											+ "`total`=?";
	
	public static final String SELECT_ORDERS="SELECT MAX(`ordNo`) FROM `km_product_order`";

	public static final String SELECT_ORDER="SELECT * FROM `km_product_order_item` AS a JOIN `km_product` AS b ON a.prodno=b.prodno WHERE `ordno`=?";
	
	public static final String SELECT_ORDER2="SELECT * FROM `km_product_order` WHERE `ordno`=?";
}
