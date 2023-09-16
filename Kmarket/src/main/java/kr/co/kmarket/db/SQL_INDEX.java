package kr.co.kmarket.db;

public class SQL_INDEX {


	//SELECT
	public static final String SELECT_PRODUCTS_SOLD="SELECT `prodName`,`descript`,`price`,`discount`,`thumb1` FROM `km_product` order by `sold` DESC limit 8";
	public static final String SELECT_PRODUCTS_SCORE="SELECT `prodName`,`descript`,`price`,`discount`,`thumb1`,`delivery` FROM `km_product` order by `score` DESC limit 8";
	public static final String SELECT_PRODUCTS_DISCOUNT="SELECT `prodName`,`descript`,`price`,`discount`,`thumb1`,`delivery` FROM `km_product` order by `discount` DESC limit 8";
	public static final String SELECT_PRODUCTS_NEW="SELECT `prodName`,`descript`,`price`,`discount`,`thumb1`,`delivery` FROM `km_product` order by `prodno` DESC limit 8";
	
}
