package kr.co.kmarket.db;

public class SQL_INDEX {


	//SELECT
	public static final String SELECT_PRODUCTS_HIT="SELECT * FROM `km_product` order by `hit` DESC limit 8";
	public static final String SELECT_PRODUCTS_SCORE="SELECT * FROM `km_product` order by `score` DESC limit 8";
	public static final String SELECT_PRODUCTS_DISCOUNT="SELECT * FROM `km_product` order by `discount` DESC limit 8";
	public static final String SELECT_PRODUCTS_NEW="SELECT * FROM `km_product` order by `prodno` DESC limit 8";
	public static final String SELECT_PRODUCTS_SOLD="SELECT * FROM `km_product` order by `sold` DESC limit 5";
	
}
