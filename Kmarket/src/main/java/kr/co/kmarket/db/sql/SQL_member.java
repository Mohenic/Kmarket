package kr.co.kmarket.db.sql;

public class SQL_member {
	//INSERT
	public static final String INSERT_MEMBER ="INSERT INTO `km_member` SET `uid`=?, `pass`=SHA2(?,256), name=?, gender=?"
											+ ", hp=? , email=?, type=?, zip=?, addr1=?, addr2=?, regip=?, rdate=NOW()";
	
	public static final String INSERT_MEMBER_SELLER ="INSERT INTO `km_member` SET `uid`=?, `pass`=SHA2(?,256),"
												+ "  email=?, type=?, zip=?, addr1=?, addr2=?,"
												+ " company=?, ceo=?, bizRegNum=?, comRegNum=? ,tel=?, manager=?, managerHp=?, fax=?, "
												+ "regip=?, rdate=NOW(),level=5";

	
	//SELECT
	public static final String SELECT_TEMRS = "SELECT `terms`,`privacy`,`location`,`finance` FROM `km_member_terms` ";
	public static final String SELECT_TAX = "SELECT `tax`,`privacy`,`finance` FROM `km_member_terms` ";
	
	//DELETE
	
	//UPDATE
}
