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
	public final static String UPDATE_PRODUCT_HIT = "UPDATE `km_product` SET `hit`=`hit`+1 WHERE `prodNo`=?";
	
	// category
	public final static String SELECT_PRODUCT_CATE = "SELECT * FROM `km_product` WHERE `prodCate1`=? AND `prodCate2`=?";
	
	//상품분류
	public static String productListQeury(String sort, String order){
		if(sort == null && order == null) {
			return "SELECT * FROM km_product WHERE prodCate1=? AND prodCate2=?";
		}
        return "SELECT * FROM km_product WHERE prodCate1=? AND prodCate2=? ORDER BY " + sort + " " + order + " LIMIT ?, 5";
    }
	
	public static final String DELETE_PRODUCT = "DELETE FROM `km_product` WHERE `prodNo` = ?";

}
