package kr.co.kmarket.db;

public class SQL_Admin {
	
	public static final String INSERT_ORDER = "	INSERT INTO `km_product` SET"
															+ "	`prodCate1` = ? , "
															+ "	`prodCate2` = ? ,"
															+ "	`prodName` = ? ,"
															+ "	`descript` = ? ,"
															+ "	`seller` = ? ,"
															+ "	`company` = ? ,"
															+ "	`price` =  ? ,"
															+ "	`discount` = ? ,"
															+ "	`point` = ? ,"
															+ "	`stock` = ? ,"
															+ "	`delivery` = ? ,"
															+ "	`thumb1` = ? ,"
															+ "	`thumb2` = ? ,"
															+ "	`thumb3` = ? ,"
															+ "	`detail` = ? ,"
															+ "	`status` =  ? ,"
															+ "	`duty` = ? ,"
															+ "	`receipt` = ? ,"
															+ "	`bizType` = ? ,"
															+ "	`origin` = ? ,"
															+ "	`ip` = ? ,"
															+ "	`rdate` = NOW();";
}
